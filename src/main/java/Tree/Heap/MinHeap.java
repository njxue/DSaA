package Tree.Heap;

import java.util.Arrays;

public class MinHeap {
    int[] heap;
    int size = 0;

    public MinHeap(int maxSize) {
        heap = new int[maxSize];
    }

    public void insert(int i) {
        heap[size] = i;
        size++;
        bubbleUp(size - 1);
    }

    public int extractMin() {
        int max = heap[0];
        swap(0, size - 1);
        heap[size - 1] = Integer.MAX_VALUE;
        size--;
        bubbleDown(0);
        return max;
    }

    /**
     * Deletes key at index {@code i}.
     */
    public void delete(int i) {
        updateKey(i, Integer.MIN_VALUE);
        extractMin();
    }

    public void updateKey(int i, int newKey) {
        int oldKey = heap[i];
        if (oldKey == newKey) {
            return;
        }

        heap[i] = newKey;
        if (oldKey < newKey) { // increased key
            bubbleDown(i);
        } else { // decreased key
            bubbleUp(i);
        }
    }

    public static MinHeap heapify(int[] arr) {
        MinHeap h = new MinHeap(arr.length);
        h.heap = arr;
        h.size = arr.length;
        for (int i = arr.length - 1; i >= 0; i--) {
            h.bubbleDown(i);
        }
        return h;
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
        while (i != 0 && heap[i] < heap[getParentIndex(i)]) {
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
                if (heap[i] <= heap[l] && heap[i] <= heap[r]) {
                    return;
                }
                toSwap = heap[l] <= heap[r] ? l : r;
            } else {
                toSwap = l < size ? l : r;
                if (heap[i] <= heap[toSwap]) {
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
