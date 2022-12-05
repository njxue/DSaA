package Deque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class DequeTest {

    @Test
    public void dequeueFront_emptyDeque_throwsException() {
        Deque<Integer> deque = new Deque<Integer>();
        assertThrows(Exception.class, deque::dequeueFront);
    }

    @Test
    public void dequeueBack_emptyDeque_throwsException() {
        Deque<Integer> deque = new Deque<Integer>();
        assertThrows(Exception.class, deque::dequeueBack);
    }

    @Test
    public void dequeueFront_nonEmptyDeque_success() throws Exception {
        Deque<Integer> deque = new Deque<Integer>();
        deque.enqueueFront(1);
        deque.enqueueFront(2);
        assertEquals(2, deque.dequeueFront());
        assertEquals(1, deque.dequeueFront());
    }

    @Test
    public void dequeueBack_nonEmptyDeque_success() throws Exception {
        Deque<Integer> deque = new Deque<Integer>();
        deque.enqueueFront(1);
        deque.enqueueFront(2);
        assertEquals(1, deque.dequeueBack());
        assertEquals(2, deque.dequeueBack());
    }

    @Test
    public void peakFront_emptyDeque_throwsException() {
        Deque<Integer> deque = new Deque<Integer>();
        assertThrows(Exception.class, deque::peakFront);
    }

    @Test
    public void peakBack_emptyDeque_throwsException() {
        Deque<Integer> deque = new Deque<Integer>();
        assertThrows(Exception.class, deque::peakBack);
    }

    @Test
    public void peakFront_nonEmptyDeque_success() throws Exception {
        Deque<Integer> deque = new Deque<Integer>(10);
        deque.enqueueFront(1);
        deque.enqueueBack(2);
        assertEquals(1, deque.peakFront());
    }

    @Test
    public void peakBack_nonEmptyDeque_success() throws Exception {
        Deque<Integer> deque = new Deque<Integer>(10);
        deque.enqueueFront(1);
        deque.enqueueBack(2);
        assertEquals(1, deque.peakFront());
    }

    @Test
    public void enqueueFront_fullDeque_throwsException() throws Exception {
        Deque<Integer> deque = new Deque<Integer>(1);
        deque.enqueueFront(1);
        assertThrows(Exception.class, () -> deque.enqueueFront(2));
    }

    @Test
    public void enqueueBack_fullDeque_throwsException() throws Exception {
        Deque<Integer> deque = new Deque<Integer>(1);
        deque.enqueueFront(1);
        assertThrows(Exception.class, () -> deque.enqueueBack(2));
    }

    @Test
    public void enqueueFront_nonFullDeque_success() {
        Deque<Integer> deque = new Deque<Integer>(10);
        try {
            deque.enqueueFront(1);
        } catch (Exception e) {
            fail("Should not throw Exception");
        }
    }

    @Test
    public void enqueueBack_nonFullDeque_success() {
        Deque<Integer> deque = new Deque<Integer>(10);
        try {
            deque.enqueueBack(1);
        } catch (Exception e) {
            fail("Should not throw Exception");
        }
    }

    @Test
    public void getSize() throws Exception {
        Deque<Integer> deque = new Deque<Integer>(10);
        deque.enqueueFront(1);
        assertEquals(1, deque.getSize());
        deque.enqueueFront(2);
        assertEquals(2, deque.getSize());
        deque.enqueueFront(3);
        assertEquals(3, deque.getSize());
    }


    @Test
    public void isEmpty() throws Exception {
        Deque<Integer> deque = new Deque<Integer>();
        assertTrue(deque.isEmpty());
        deque.enqueueFront(1);
        assertFalse(deque.isEmpty());
        deque.dequeueBack();
        assertTrue(deque.isEmpty());
    }

    @Test
    public void isFull() throws Exception {
        Deque<Integer> deque = new Deque<Integer>(2);
        assertFalse(deque.isFull());
        deque.enqueueFront(1);
        assertFalse(deque.isFull());
        deque.enqueueBack(2);
        assertTrue(deque.isFull());
    }
}
