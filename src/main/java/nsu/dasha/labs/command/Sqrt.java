package nsu.dasha.labs.command;

import nsu.dasha.labs.Context;
import nsu.dasha.labs.exception.ArithmeticException;
import nsu.dasha.labs.exception.LessThanZeroException;
import nsu.dasha.labs.exception.ScriptExceptions;
import org.apache.log4j.Logger;

public class Sqrt implements Command {
    private static final Logger logger = Logger.getLogger(Sqrt.class.getName());

    public Sqrt() {
        logger.info("The command " + this.getClass().getName() + " was created.");
    }

    @Override
    public void calculate(Context context, String[] k) throws ArithmeticException, ScriptExceptions {
        logger.info("Trying to calculate into " + this.getClass().getName());

        double val = context.popStackValue();
        if (val < 0) {
            throw new LessThanZeroException();
        }

        logger.info("Trying to pushStackValue.");
        context.pushStackValue(Math.sqrt(val));
    }

}
