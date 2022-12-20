package Sort;

import static Sort.SortUtil.EMPTY;
import static Sort.SortUtil.REVERSED_UNIQUE;
import static Sort.SortUtil.SINGLE;
import static Sort.SortUtil.SORTED_UNIQUE;
import static Util.TestUtil.expectEquals;

import org.junit.jupiter.api.Test;

public class HeapSortTest {
    @Test
    public void heapSort_reversed_success() {
        int[] arr = REVERSED_UNIQUE;
        HeapSort.sort(arr);
        expectEquals(SORTED_UNIQUE, arr);
    }

    @Test
    public void heapSort_sorted_success() {
        int[] arr = SORTED_UNIQUE;
        HeapSort.sort(arr);
        expectEquals(SORTED_UNIQUE, arr);
    }

    @Test
    public void heapSort_empty_success() {
        int[] arr = EMPTY;
        HeapSort.sort(arr);
        expectEquals(EMPTY, arr);
    }

    @Test
    public void heapSort_singleElement_success() {
        int[] arr = SINGLE;
        HeapSort.sort(arr);
        expectEquals(SINGLE, arr);
    }

}
