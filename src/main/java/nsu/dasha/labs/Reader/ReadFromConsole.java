package nsu.dasha.labs.Reader;
import org.apache.log4j.Logger;

import java.io.EOFException;
import java.util.Scanner;

public class ReadFromConsole implements Reader {
    private static final Logger logger = Logger.getLogger(ReadFromConsole.class.getName());
    private final Scanner scanner;

    public ReadFromConsole() {
        scanner = new Scanner(System.in);
        if (endOfFile()) {
            logger.info("FileIsEmptyException");
        }

    }
@Override
    public String[] read() throws EOFException {
        return scanner.nextLine().split(" ");
    }
@Override
    public boolean endOfFile() {
        return !scanner.hasNextLine();
    }

}

