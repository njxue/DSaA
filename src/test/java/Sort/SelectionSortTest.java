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

public class SelectionSortTest {

    @Test
    public void selectionSort_reversed_success() {
        int[] arr = REVERSED_UNIQUE;
        SelectionSort.sort(arr);
        System.out.println(SORTED_UNIQUE);
        expectEquals(SORTED_UNIQUE, arr);
    }

    @Test
    public void selectionSort_sorted_success() {
        int[] arr = SORTED_UNIQUE;
        SelectionSort.sort(arr);
        expectEquals(SORTED_UNIQUE, arr);
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

    @RepeatedTest(10)
    public void selectionSort_randomElements_success() {
        int[] arr = randomArr();
        int[] expected = Arrays.copyOf(arr, arr.length);
        Arrays.sort(expected);
        SelectionSort.sort(arr);
        expectEquals(expected, arr);
    }
}
