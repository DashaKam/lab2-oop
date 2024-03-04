package nsu.dasha.labs.exception;

public class DivideByZeroException extends ArithmeticException {
    public DivideByZeroException() {
        super("Division by zero!");
    }
}
