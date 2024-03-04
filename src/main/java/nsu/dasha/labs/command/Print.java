package nsu.dasha.labs.command;

import nsu.dasha.labs.Context;
import nsu.dasha.labs.exception.ScriptExceptions;
import org.apache.log4j.Logger;

public class Print implements Command {
    private static final Logger logger = Logger.getLogger(Print.class.getName());

    public Print() {
        logger.info("The command " + this.getClass().getName() + " was created.");
    }

    @Override
    public void calculate(Context context, String[] k) throws ScriptExceptions {
        logger.info("Trying to calculate into " + this.getClass().getName());
        logger.info("Trying to printLastInStack.");

        context.printLastInStack();
    }

}
