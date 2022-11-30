package Sort;

import static Sort.SortTestUtil.expectEquals;
import static Sort.SortUtil.EMPTY;
import static Sort.SortUtil.REVERSED;
import static Sort.SortUtil.SINGLE;
import static Sort.SortUtil.SORTED;

import org.junit.jupiter.api.Test;

public class SortTest {

    // ======================================== BUBBLE SORT ========================================
    @Test
    public void bubbleSort_reversed_success() {
        int[] arr = REVERSED;
        BubbleSort.sort(arr);
        expectEquals(SORTED, arr);
    }

    @Test
    public void bubbleSort_sorted_success() {
        int[] arr = SORTED;
        BubbleSort.sort(arr);
        expectEquals(SORTED, arr);
    }

    @Test
    public void bubbleSort_empty_success() {
        int[] arr = EMPTY;
        BubbleSort.sort(arr);
        expectEquals(EMPTY, arr);
    }

    @Test
    public void bubbleSort_singleElement_success() {
        int[] arr = SINGLE;
        BubbleSort.sort(arr);
        expectEquals(SINGLE, arr);
    }

    // ======================================== INSERTION SORT ========================================

    @Test
    public void insertionSort_reversed_success() {
        int[] arr = REVERSED;
        InsertionSort.sort(arr);
        expectEquals(SORTED, arr);
    }

    @Test
    public void insertionSort_sorted_success() {
        int[] arr = SORTED;
        InsertionSort.sort(arr);
        expectEquals(SORTED, arr);
    }

    @Test
    public void insertionSort_empty_success() {
        int[] arr = EMPTY;
        InsertionSort.sort(arr);
        expectEquals(EMPTY, arr);
    }

    @Test
    public void insertionSort_singleElement_success() {
        int[] arr = SINGLE;
        InsertionSort.sort(arr);
        expectEquals(SINGLE, arr);
    }

    // ======================================== SELECTION SORT ========================================

    @Test
    public void selectionSort_reversed_success() {
        int[] arr = REVERSED;
        SelectionSort.sort(arr);
        expectEquals(SORTED, arr);
    }

    @Test
    public void selectionSort_sorted_success() {
        int[] arr = SORTED;
        SelectionSort.sort(arr);
        expectEquals(SORTED, arr);
    }

    @Test
    public void selectionSort_empty_success() {
        int[] arr = EMPTY;
        SelectionSort.sort(arr);
        expectEquals(EMPTY, arr);
    }

    @Test
    public void selectionSort_singleElement_success() {
        int[] arr = SINGLE;
        SelectionSort.sort(arr);
        expectEquals(SINGLE, arr);
    }
}
