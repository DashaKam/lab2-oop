package nsu.dasha.labs.exception;

public class FileIsEmptyException extends FileException {
    public FileIsEmptyException() {
        super("File is empty!");
    }
}
