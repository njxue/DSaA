package Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import Sort.Stack.Stack;

public class StackTest {

    @Test
    public void pop_emptyStack_throwsException() {
        Stack<Integer> stack = new Stack<>();
        assertThrows(Exception.class, stack::pop);
    }

    @Test
    public void pop_nonEmptyStack_success() throws Exception {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        assertEquals(2,  stack.pop());
        assertEquals(1,  stack.pop());
    }

    @Test
    public void peak_emptyStack_throwsException() {
        Stack<Integer> stack = new Stack<>();
        assertThrows(Exception.class, stack::peak);
    }

    @Test
    public void peak_nonEmptyStack_success() throws Exception {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        assertEquals(2,  stack.peak());
    }

    @Test
    public void push_fullStack_throwsException() throws Exception {
        Stack<Integer> stack = new Stack<>(1);
        stack.push(1);
        assertThrows(Exception.class, () -> stack.push(2));
    }

    @Test
    public void push_nonFullStack_success() {
        Stack<Integer> stack = new Stack<>(10);
        try {
            stack.push(1);
        } catch (Exception e) {
            fail("Should not throw Exception");
        }
    }

    @Test
    public void getSize() throws Exception {
        Stack<Integer> stack = new Stack<>(10);
        stack.push(1);
        assertEquals(1, stack.getSize());
        stack.push(2);
        assertEquals(2, stack.getSize());
        stack.push(3);
        assertEquals(3, stack.getSize());
    }


    @Test
    public void isEmpty() throws Exception {
        Stack<Integer> stack = new Stack<>();
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void isFull() throws Exception {
        Stack<Integer> stack = new Stack<>(2);
        assertFalse(stack.isFull());
        stack.push(1);
        assertFalse(stack.isFull());
        stack.push(2);
        assertTrue(stack.isFull());
    }
}

