import nsu.dasha.labs.Context;
import nsu.dasha.labs.exception.ScriptExceptions;
import nsu.dasha.labs.exception.WrongKeyException;
import nsu.dasha.labs.exception.WrongNameException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ContextTest {
    @Test
    public void testAddVariable() {

        Context context = new Context(System.out);
        double res = 0.0;
        try {
            context.addVariable("a", 2);
            context.pushStackValue(context.getVariable("a"));
            res = context.peekStack();

        } catch (ScriptExceptions ex) {
            System.out.println("exception");
        }
        assertEquals(2, res);
        assertThrows(WrongNameException.class, ()-> context.addVariable("1", 2));
        assertThrows(WrongNameException.class, () -> context.addVariable("", 2));
    }

    @Test
    public void testPeek(){
        Context context = new Context(System.out);
        context.pushStackValue(5.0);
        Double res = 0.0;
        try {
            res = context.peekStack();
            assertEquals(5, res);
            context.popStackValue();

        }catch (ScriptExceptions ex){
            System.out.println("exception");
        }
        assertThrows(ScriptExceptions.class, () -> context.peekStack());
    }
    @Test
    public void testPop() {
        Context context = new Context(System.out);
        context.pushStackValue(5.0);
        Double res = 0.0;
        try{
            res = context.popStackValue();
        }catch (ScriptExceptions ex){
            System.out.println("exception");
        }
        assertEquals(5, res);
        assertThrows(ScriptExceptions.class, () -> context.popStackValue());
    }

    @Test
    public void testPush() {
        Context context = new Context(System.out);
        Double res = 0.0;
        try{
            context.pushStackValue(5.0);
            res = context.popStackValue();
        }catch (ScriptExceptions ex){
            System.out.println("exception");
        }
        assertEquals(5, res);
    }

}
