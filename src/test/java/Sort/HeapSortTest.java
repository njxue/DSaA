package Sort;

import static Sort.SortUtil.EMPTY;
import static Sort.SortUtil.REVERSED_UNIQUE;
import static Sort.SortUtil.SINGLE;
import static Sort.SortUtil.SORTED_UNIQUE;
import static Sort.SortUtil.randomArr;
import static Util.TestUtil.expectEquals;

import java.util.Arrays;

import org.junit.jupiter.api.RepeatedTest;
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

    @RepeatedTest(10)
    public void heapSort_randomElements_success() {
        int[] arr = randomArr();
        int[] expected = Arrays.copyOf(arr, arr.length);
        Arrays.sort(expected);
        HeapSort.sort(arr);
        expectEquals(expected, arr);
    }
}
