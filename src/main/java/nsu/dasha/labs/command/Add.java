package nsu.dasha.labs.command;

import nsu.dasha.labs.Context;
import nsu.dasha.labs.exception.ScriptExceptions;
import org.apache.log4j.Logger;

public class Add implements Command {
    private static final Logger logger = Logger.getLogger(Add.class.getName());

    public Add() {
        logger.info("The command " + this.getClass().getName() + " was created.");
    }

    @Override
    public void calculate(Context context, String[] k) throws ScriptExceptions {
        logger.info("Trying to calculate into " + this.getClass().getName());

        double val1 = context.popStackValue();
        double val2 = context.popStackValue();

        logger.info("Trying to add " + val1 + " and " + val2 + ".");
        context.pushStackValue(val1 + val2);
    }

}
