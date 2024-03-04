package nsu.dasha.labs.command;

import nsu.dasha.labs.Context;
import nsu.dasha.labs.exception.NotEnoughArgsException;
import nsu.dasha.labs.exception.ScriptExceptions;
import nsu.dasha.labs.exception.TooManyArgsException;
import org.apache.log4j.Logger;

public class Define implements Command {
    private static final Logger logger = Logger.getLogger(Define.class.getName());

    public Define() {
        logger.info("The command " + this.getClass().getName() + " was created.");
    }

    @Override
    public void calculate(Context context, String[] k) throws ScriptExceptions {
        logger.info("Trying to calculate into " + this.getClass().getName());

        if (k.length < 3) {
            throw new NotEnoughArgsException();
        } else if (k.length > 3) {
            throw new TooManyArgsException();
        }

        try {
            context.addVariable(k[1], Double.parseDouble(k[2]));
        } catch (NumberFormatException ex) {
            logger.error("Couldn't cast " + k[2] + " to double");
        }
    }
}
