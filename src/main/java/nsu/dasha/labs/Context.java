package nsu.dasha.labs;

import nsu.dasha.labs.exception.ScriptExceptions;
import nsu.dasha.labs.exception.WrongKeyException;
import nsu.dasha.labs.exception.WrongNameException;
import org.apache.log4j.Logger;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;

public class Context {
    private final Stack<Double> values = new Stack<>();
    private final HashMap<String, Double> mapValues = new HashMap<>();
    private final PrintStream out;
    private boolean exitFlag = false;


    private static final Logger logger = Logger.getLogger(Context.class.getName());

    public Context(OutputStream out) {
        this.out = new PrintStream(out);

        logger.info("The command " + this.getClass().getName() + " was created.");
    }

    public void pushStackValue(double value) {
        values.push(value);
        logger.info("Pushed " + value + " into stack.");
    }

    public double popStackValue() throws ScriptExceptions {
        try {
            return values.pop();
        } catch (EmptyStackException ex) {
            logger.error("Stack is empty. ", ex);
            throw new ScriptExceptions("Stack is empty. ", ex);
        }
    }

    public void addVariable(String name, double value) throws ScriptExceptions {
        // Validate name and value
        checkName(name);
        if (mapValues.containsKey(name)) {
            throw new WrongKeyException();
        }

        mapValues.put(name, value);
        logger.info(String.format("Put into map pair (%s, %f).", name, value));
    }

    public double getVariable(String name) {
        //TODO: add custom exception
        return mapValues.get(name);
    }

    public void printLastInStack() {
        //Maybe better to throw it away?
        try {
            out.println(peekStack());
        } catch (ScriptExceptions ex) {
            logger.error("Stack is empty. ", ex);
        }
    }

    public PrintStream getOut() {
        return out;
    }

    public double peekStack() throws ScriptExceptions {
        try {
            return values.peek();
        } catch (EmptyStackException ex) {
            throw new ScriptExceptions("Stack is empty. ", ex);
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

    private void checkName(String name) throws WrongNameException {
        if (name.isEmpty() || !containsLetter(name)) {
            throw new WrongNameException();
        }
    }
    public void setExitFlag() {
        exitFlag = true;
    }
    public boolean getExitFlag() {
        return exitFlag;
    }

}
