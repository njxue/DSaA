package Tree.Heap;
import java.util.Arrays;
import java.util.HashMap;


/**
 * Represents a max-heap that allows duplicates. Therefore, it does not support increase/decrease key operations
 */
public class MaxHeap {
    Integer[] heap;
    int size = 0;

    public MaxHeap(int maxSize) {
        heap = new Integer[maxSize];
    }

    public void insert(int i) {
        heap[size] = i;
        size++;
        bubbleUp(size - 1);
    }

    public int extractMax() {
        int max = heap[0];
        swap(0, size - 1);
        heap[size - 1] = null;
        size--;
        bubbleDown(0);
        return max;
    }

    /**
     * Deletes key at index {@code i}.
     */
    public void delete(int i) {
        updateKey(i, Integer.MAX_VALUE);
        extractMax();
    }


    public void updateKey(int i, int newKey) {
        int oldKey = heap[i];
        if (oldKey == newKey) {
            return;
        }

        heap[i] = newKey;
        if (oldKey < newKey) { // increased key
            bubbleUp(i);
        } else { // decreased key
            bubbleDown(i);
        }
    }

    public static MaxHeap heapify(int[] arr) {
        MaxHeap heap = new MaxHeap(arr.length);
        for (int i : arr) {
            heap.insert(i);
        }
        return heap;
    }

    @Override
    public String toString() {
        return Arrays.toString(heap);
    }

    private int getParentIndex(int i) {
        return (i - 1) / 2;
    }

    private int getLeftIndex(int i) {
        return i * 2 + 1;
    }

    private int getRightIndex(int i) {
        return i * 2 + 2;
    }

    private void bubbleUp(int i) {
       while (i != 0 && heap[i] > heap[getParentIndex(i)]) {
           swap(i, getParentIndex(i));
           i = getParentIndex(i);
       }
    }

    private void bubbleDown(int i) {
        while (!isLeaf(i)) {
            int l = getLeftIndex(i);
            int r = getRightIndex(i);
            int toSwap;

            if (l < size && r < size) {
                if (heap[i] >= heap[l] && heap[i] >= heap[r]) {
                    return;
                }
                toSwap = heap[l] >= heap[r] ? l : r;
            } else {
                toSwap = l < size ? l : r;
                if (heap[i] >= heap[toSwap]) {
                    return;
                }
            }
            swap(i, toSwap);
            i = toSwap;
        }
    }

    private boolean isLeaf(int i) {
        return getRightIndex(i) >= size && getLeftIndex(i) >= size;
    }

    private void swap(int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }
}
