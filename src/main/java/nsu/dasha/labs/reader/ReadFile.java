package nsu.dasha.labs.reader;


import nsu.dasha.labs.exception.FileIsEmptyException;
import org.apache.log4j.Logger;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile implements Reader {
    private static final Logger logger = Logger.getLogger(ReadFile.class.getName());
    private final Scanner file;

    public ReadFile(String fileName)  throws FileIsEmptyException, FileNotFoundException {
            file = new Scanner(new File(fileName));
            if (endOfFile()) {
            logger.error("FileIsEmptyException");
            throw new FileIsEmptyException();
        }
    }

    @Override
    public String[] read() throws EOFException {
        return file.nextLine().split(" ");
    }
@Override
    public boolean endOfFile() {
        return !file.hasNextLine();
    }

    public void closeFile(){
        file.close();
    }
}
