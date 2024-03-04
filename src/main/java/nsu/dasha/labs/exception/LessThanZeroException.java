package nsu.dasha.labs.exception;

public class LessThanZeroException extends ArithmeticException {
    public LessThanZeroException() {
        super("The number is less than zero!");
    }
}
