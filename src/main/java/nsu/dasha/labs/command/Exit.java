package nsu.dasha.labs.command;

import nsu.dasha.labs.Context;
import nsu.dasha.labs.exception.ArithmeticException;
import nsu.dasha.labs.exception.ScriptExceptions;
import org.apache.log4j.Logger;

public class Exit implements Command{
    private static final Logger logger = Logger.getLogger(Multiply.class.getName());

    public Exit() {
        logger.info("The command " + this.getClass().getName() + " was created.");
    }

    @Override
    public void calculate(Context context, String[] k) throws ScriptExceptions{
        context.setExitFlag();
   }

}
