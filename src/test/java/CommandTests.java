import nsu.dasha.labs.Context;
import nsu.dasha.labs.command.*;
import nsu.dasha.labs.exception.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandTests {

    @Test
    public void testPush() throws ScriptExceptions {
        Context context = new Context(System.out);
        Push push1 = new Push();
        push1.calculate(context, new String[]{"PUSH","5"});
        assertEquals(5, context.peekStack());
        assertThrows(NotEnoughArgsException.class, ()-> push1.calculate(context, new String[]{"1"}));
        assertThrows(TooManyArgsException.class, ()-> push1.calculate(context, new String[]{"PUSH", "1", "5", "6"}));
        //Assertions.assertThrows(WrongNameException.class, ()-> push1.calculate(context, new String[]{"PUSH"}));
        Define def = new Define();
        def.calculate(context, new String[]{"DEFINE","a1", "5"});
        push1.calculate(context, new String[]{"PUSH","a1"});
        assertEquals(5, context.getVariable("a1"));


    }

    @Test
    public void testPop() throws ScriptExceptions {
        Context context = new Context(System.out);
        Pop pop = new Pop();
        assertThrows(ScriptExceptions.class, ()->pop.calculate(context, new String[]{"POP"}));
        context.pushStackValue(5);
        pop.calculate(context, new String[]{"POP"});
        assertThrows(ScriptExceptions.class, context::popStackValue);
    }

    @Test
    public void testDefine() {
        Context context = new Context(System.out);
        Define def = new Define();
        assertDoesNotThrow(() -> def.calculate(context, new String[]{"DEFINE", "a1", "5"}));
        assertEquals(5, context.getVariable("a1"));
        assertThrows(NotEnoughArgsException.class, ()-> def.calculate(context, new String[]{"1"}));
        assertThrows(TooManyArgsException.class, ()-> def.calculate(context, new String[]{"DEFINE", "a1", "5", "1"}));

    }

    @Test
    public void testSqrt(){
        Context context = new Context(System.out);
        Sqrt sqrt = new Sqrt();
        context.pushStackValue(-1);
        assertThrows(LessThanZeroException.class, ()-> sqrt.calculate(context, new String[]{"SQRT"}));
        context.pushStackValue(4);
        assertDoesNotThrow(() -> sqrt.calculate(context, new String[]{"SQRT"}));
        try {
            assertEquals(2, context.popStackValue());
        }catch (ScriptExceptions ex){
            System.out.println("exception");
        }
    }

    @Test
    public void testAdd(){
        Context context = new Context(System.out);
        Add add = new Add();
        context.pushStackValue(10);
        context.pushStackValue(-2);
        context.pushStackValue(-15);
        assertDoesNotThrow(() -> add.calculate(context, new String[]{"Sub"}));
        try {
            assertEquals(-17, context.peekStack());
            assertDoesNotThrow(() -> add.calculate(context, new String[]{"Sub"}));
            assertEquals(-7, context.popStackValue());
        }catch (ScriptExceptions ex){
            System.out.println("exception");
        }
    }

    @Test
    public void testSub(){
        Context context = new Context(System.out);
        Subtraction sub = new Subtraction();
        context.pushStackValue(10);
        context.pushStackValue(-2);
        context.pushStackValue(-15);
        assertDoesNotThrow(() -> sub.calculate(context, new String[]{"Sub"}));
        try {
            assertEquals(-13, context.peekStack());
            assertDoesNotThrow(() -> sub.calculate(context, new String[]{"Sub"}));
            assertEquals(-23, context.popStackValue());
        }catch (ScriptExceptions ex){
            System.out.println("exception");
        }
    }

    @Test
    public void testMul(){
        Context context = new Context(System.out);
        Multiply mul = new Multiply();
        context.pushStackValue(-10);
        context.pushStackValue(-2);
        context.pushStackValue(-15);
        assertDoesNotThrow(() -> mul.calculate(context, new String[]{"Mul"}));
        try {
            assertEquals(30, context.peekStack());
            assertDoesNotThrow(() -> mul.calculate(context, new String[]{"Mul"}));
            assertEquals(-300, context.popStackValue());
        }catch (ScriptExceptions ex){
            System.out.println("exception");
        }
    }

    @Test
    public void testDiv(){
        Context context = new Context(System.out);
        Division div = new Division();
        context.pushStackValue(-10);
        context.pushStackValue(3);
        context.pushStackValue(-15);
        assertDoesNotThrow(() -> div.calculate(context, new String[]{"Mul"}));
        try {
            assertEquals(-5, context.peekStack());
            assertDoesNotThrow(() -> div.calculate(context, new String[]{"Mul"}));
            assertEquals(0.5, context.popStackValue());
        }catch (ScriptExceptions ex){
            System.out.println("exception");
        }
        context.pushStackValue(0);
        context.pushStackValue(70);
        assertThrows(DivideByZeroException.class, ()-> div.calculate(context, new String[]{"DIV"}));

    }




}
