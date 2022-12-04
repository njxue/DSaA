package Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class QueueTest {
    @Test
    public void dequeue_emptyQueue_throwsException() {
        Queue<Integer> queue = new Queue<Integer>();
        assertThrows(Exception.class, queue::dequeue);
    }

    @Test
    public void dequeue_nonEmptyQueue_success() throws Exception {
        Queue<Integer> queue = new Queue<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
    }

    @Test
    public void peak_emptyQueue_throwsException() {
        Queue<Integer> queue = new Queue<Integer>();
        assertThrows(Exception.class, queue::peak);
    }

    @Test
    public void peak_nonEmptyQueue_success() throws Exception {
        Queue<Integer> queue = new Queue<Integer>(10);
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(1, queue.peak());
    }

    @Test
    public void enqueue_fullQueue_throwsException() throws Exception {
        Queue<Integer> queue = new Queue<Integer>(1);
        queue.enqueue(1);
        assertThrows(Exception.class, () -> queue.enqueue(2));
    }

    @Test
    public void enqueue_nonFullQueue_success() {
        Queue<Integer> queue = new Queue<Integer>(10);
        try {
            queue.enqueue(1);
        } catch (Exception e) {
            fail("Should not throw Exception");
        }
    }

    @Test
    public void getSize() throws Exception {
        Queue<Integer> queue = new Queue<Integer>(10);
        queue.enqueue(1);
        assertEquals(1, queue.getSize());
        queue.enqueue(2);
        assertEquals(2, queue.getSize());
        queue.enqueue(3);
        assertEquals(3, queue.getSize());
    }


    @Test
    public void isEmpty() throws Exception {
        Queue<Integer> queue = new Queue<Integer>();
        assertTrue(queue.isEmpty());
        queue.enqueue(1);
        assertFalse(queue.isEmpty());
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void isFull() throws Exception {
        Queue<Integer> queue = new Queue<Integer>(2);
        assertFalse(queue.isFull());
        queue.enqueue(1);
        assertFalse(queue.isFull());
        queue.enqueue(2);
        assertTrue(queue.isFull());
    }
}
