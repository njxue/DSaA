package Sort;

import Tree.Heap.MinHeap;

public class HeapSort {

    static void sort(int[] arr) {
        MinHeap mh = MinHeap.heapify(arr);
        int[] sorted = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            sorted[i] = mh.extractMin();
        }
        System.arraycopy(sorted, 0, arr, 0, arr.length);
    }
}
