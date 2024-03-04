package nsu.dasha.labs.command;

import nsu.dasha.labs.exception.NotEnoughArgsException;

public class CommandFactory {
    public Command get(String name) throws NotEnoughArgsException {
        return switch (name.toUpperCase()) {
            case "PUSH" -> new Push();
            case "POP" -> new Pop();
            case "+" -> new Add();
            case "-" -> new Subtraction();
            case "*" -> new Multiply();
            case "/" -> new Division();
            case "#" -> new Comment();
            case "SQRT" -> new Sqrt();
            case "PRINT" -> new Print();
            case "DEFINE" -> new Define();
            default -> throw new NotEnoughArgsException();
        };
    }
}
