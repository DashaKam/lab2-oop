package nsu.dasha.labs.exception;

public class FileException extends CalculatorException {
    public FileException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileException(String message) {
        super(message);
    }
}
