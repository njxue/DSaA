package Sort;

import static Sort.SortUtil.randomArr;
import static Util.TestUtil.expectEquals;
import static Sort.SortUtil.EMPTY;
import static Sort.SortUtil.REVERSED_UNIQUE;
import static Sort.SortUtil.SINGLE;
import static Sort.SortUtil.SORTED_UNIQUE;

import java.util.Arrays;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class InsertionSortTest {

    @Test
    public void insertionSort_reversed_success() {
        int[] arr = REVERSED_UNIQUE;
        InsertionSort.sort(arr);
        expectEquals(SORTED_UNIQUE, arr);
    }

    @Test
    public void insertionSort_sorted_success() {
        int[] arr = SORTED_UNIQUE;
        InsertionSort.sort(arr);
        expectEquals(SORTED_UNIQUE, arr);
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

    @RepeatedTest(10)
    public void insertionSort_randomElements_success() {
        int[] arr = randomArr();
        int[] expected = Arrays.copyOf(arr, arr.length);
        Arrays.sort(expected);
        InsertionSort.sort(arr);
        expectEquals(expected, arr);
    }
}
