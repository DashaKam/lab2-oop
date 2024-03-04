package nsu.dasha.labs.command;

import nsu.dasha.labs.Context;
import nsu.dasha.labs.exception.NotEnoughArgsException;
import nsu.dasha.labs.exception.ScriptExceptions;
import nsu.dasha.labs.exception.TooManyArgsException;
import org.apache.log4j.Logger;

public class Push implements Command {
    private static final Logger logger = Logger.getLogger(Push.class.getName());

    public Push() {
        logger.info("The command " + this.getClass().getName() + " was created.");
    }

    @Override
    public void calculate(Context context, String[] k) throws ScriptExceptions {
        if (k.length < 2) {
            throw new NotEnoughArgsException();
        } else if (k.length > 2) {
            throw new TooManyArgsException();
        }

        String valueToPush = k[1];

        if (containsLetter(valueToPush)) {
            context.pushStackValue(context.getVariable(valueToPush));
        } else {
            context.pushStackValue(Double.parseDouble(valueToPush));
        }
    }

    private boolean containsLetter(String name) {
        for (char c : name.toCharArray()) {
            if (Character.isLetter(c)) {
                return true;
            }
        }
        return false;
    }
}
