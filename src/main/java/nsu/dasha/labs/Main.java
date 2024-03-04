package nsu.dasha.labs;


import nsu.dasha.labs.reader.ReadFile;
import nsu.dasha.labs.reader.ReadFromConsole;
import nsu.dasha.labs.command.Command;
import nsu.dasha.labs.command.CommandFactory;
import nsu.dasha.labs.exception.ArithmeticException;
import nsu.dasha.labs.exception.FileIsEmptyException;
import nsu.dasha.labs.exception.NotEnoughArgsException;
import nsu.dasha.labs.exception.ScriptExceptions;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.Scanner;


public class Main {
    private static final String PATH_TO_RESOURCES = "src/main/resources/";
    private static final String RESULT_FILENAME = "result.txt";
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws EOFException, ArithmeticException, ScriptExceptions, FileNotFoundException {

            logger.info("Attempt to read file name");
            System.out.print("Write file name: ");
            String fileName = new Scanner(System.in).nextLine();
            logger.info("Read fileName: " + fileName);

        CommandFactory factory = new CommandFactory();
        FileOutputStream outputStream = new FileOutputStream(PATH_TO_RESOURCES + RESULT_FILENAME);
        Context context = new Context(outputStream);


        try {
                ReadFile rf = new ReadFile(PATH_TO_RESOURCES + fileName + ".txt");
                while (!rf.endOfFile()) {
                    String[] splitCommand = rf.read();
                    Command command = factory.get(splitCommand[0]);
                    command.calculate(context, splitCommand);
                }
                rf.closeFile();
            } catch (FileNotFoundException ex) {
                logger.error("FileNotFoundException");
                logger.info("Use console.");
                System.out.println("File isn't exist\n");
                System.out.println("You can try to enter commands from console. To complete your entry, press Ctrl+D\n");
                try {
                    ReadFromConsole rf1 = new ReadFromConsole();
                    while (!rf1.endOfFile()) {
                        String[] splitCommand = rf1.read();
                        Command command = factory.get(splitCommand[0]);
                        command.calculate(context, splitCommand);
                    }
                }catch (EOFException ex1) {
                    logger.info("EOFException");
                } catch (NotEnoughArgsException e) {
                    logger.info("NotEnoughArgsException");
                } catch (ArithmeticException e) {
                    logger.info("ArithmeticException");
                } catch (ScriptExceptions e) {
                    logger.info("ScriptExceptions");
                }
            } catch (FileIsEmptyException ex) {
                logger.error("FileIsEmptyException");
            } catch (EOFException ex) {
                logger.info("EOFException");
            } catch (NotEnoughArgsException ex) {
                logger.info("NotEnoughArgsException");
            } catch (ArithmeticException e) {
                logger.info("ArithmeticException");
            } catch (ScriptExceptions e) {
                logger.info("ScriptExceptions");
            }
    }
}