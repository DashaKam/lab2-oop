package nsu.dasha.labs.exception;

public class ScriptExceptions extends CalculatorException {
    public ScriptExceptions(String message) {
        super(message);
    }

    public ScriptExceptions(String message, Throwable cause) {
        super(message, cause);
    }
}
