package nsu.dasha.labs.command;

import nsu.dasha.labs.Context;
import nsu.dasha.labs.exception.ArithmeticException;
import nsu.dasha.labs.exception.DivideByZeroException;
import nsu.dasha.labs.exception.ScriptExceptions;
import org.apache.log4j.Logger;

public class Division implements Command {
    private static final Logger logger = Logger.getLogger(Division.class.getName());

    public Division() {
        logger.info("The command " + this.getClass().getName() + " was created.");
    }

    @Override
    public void calculate(Context context, String[] k) throws ArithmeticException, ScriptExceptions {
        logger.info("Trying to calculate into " + this.getClass().getName());

        double val1 = context.popStackValue();
        double val2 = context.popStackValue();

        if (val2 == 0) {
            logger.error("Trying to div by 0.");
            throw new DivideByZeroException();
        }

        logger.info("Trying to div " + val1 + " by " + val2 + ".");
        context.pushStackValue(val1 / val2);
    }
}

