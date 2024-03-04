package nsu.dasha.labs.reader;

import java.io.EOFException;

public interface Reader {
    String[] read() throws EOFException;

    boolean endOfFile();
}
