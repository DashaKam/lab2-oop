package nsu.dasha.labs.command;

import nsu.dasha.labs.Context;
import nsu.dasha.labs.exception.ArithmeticException;
import nsu.dasha.labs.exception.ScriptExceptions;
import org.apache.log4j.Logger;

public class Comment implements Command {
    private static final Logger logger = Logger.getLogger(Comment.class.getName());

    public Comment() {
        logger.info("The command " + this.getClass().getName() + " was created.");
    }

    @Override
    public void calculate(Context context, String[] k) throws ArithmeticException, ScriptExceptions {
        logger.info("Trying to calculate into " + this.getClass().getName());
        logger.info("Read comment: " + String.join(" ", k));
        context.getOut().println(String.join(" ", k));
    }
}
