package nsu.dasha.labs.command;

import nsu.dasha.labs.Context;
import nsu.dasha.labs.exception.ArithmeticException;
import nsu.dasha.labs.exception.ScriptExceptions;

public interface Command {
    void calculate(Context context, String[] k) throws ArithmeticException, ScriptExceptions;
}
