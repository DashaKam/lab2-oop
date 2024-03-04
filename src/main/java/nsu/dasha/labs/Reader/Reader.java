package nsu.dasha.labs.Reader;

import java.io.EOFException;

public interface Reader {
    String[] read() throws EOFException;

    boolean endOfFile();
}
