package nsu.dasha.labs.exception;

public class FileNotFoundException extends FileException {
    public FileNotFoundException() {
        super("File didn't find!");
    }
}
