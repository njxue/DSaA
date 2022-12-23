package Sort;

import static Sort.SortUtil.randomArr;
import static Util.TestUtil.expectEquals;
import static Sort.SortUtil.DUPLICATES;
import static Sort.SortUtil.EMPTY;
import static Sort.SortUtil.RANDOM_DUPLICATES;
import static Sort.SortUtil.RANDOM_UNIQUE;
import static Sort.SortUtil.REVERSED_DUPLICATES;
import static Sort.SortUtil.REVERSED_UNIQUE;
import static Sort.SortUtil.REVERSED_UNIQUE_ALT;
import static Sort.SortUtil.SINGLE;
import static Sort.SortUtil.SORTED_DUPLICATES;
import static Sort.SortUtil.SORTED_UNIQUE;
import static Sort.SortUtil.SORTED_UNIQUE_ALT;


import java.util.Arrays;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class QuickSortTest {

    @RepeatedTest(10)
    public void quickSort_reversedEvenNumberOfElements_success() {
        int[] arr = REVERSED_UNIQUE;
        QuickSort.sort(arr);
        expectEquals(SORTED_UNIQUE, arr);
    }

    @RepeatedTest(10)
    public void quickSort_reversedOddNumberOfElements_success() {
        int[] arr = REVERSED_UNIQUE_ALT;
        QuickSort.sort(arr);
        expectEquals(SORTED_UNIQUE_ALT, arr);
    }

    @RepeatedTest(10)
    public void quickSort_sortedDuplicates_success() {
        int[] arr = SORTED_DUPLICATES;
        QuickSort.sort(arr);
        expectEquals(SORTED_DUPLICATES, arr);
    }

    @RepeatedTest(10)
    public void quickSort_reversedDuplicates_success() {
        int[] arr = REVERSED_DUPLICATES;
        QuickSort.sort(arr);
        expectEquals(SORTED_DUPLICATES, arr);
    }


    @RepeatedTest(10)
    public void quickSort_allDuplicates_success() {
        int[] arr = DUPLICATES;
        QuickSort.sort(arr);
        expectEquals(DUPLICATES, arr);
    }

    @RepeatedTest(10)
    public void quickSort_sortedEvenNumberOfElements_success() {
        int[] arr = SORTED_UNIQUE;
        QuickSort.sort(arr);
        expectEquals(SORTED_UNIQUE, arr);
    }

    @RepeatedTest(10)
    public void quickSort_sortedOddNumberOfElements_success() {
        int[] arr = SORTED_UNIQUE_ALT;
        QuickSort.sort(arr);
        expectEquals(SORTED_UNIQUE_ALT, arr);
    }

    @Test
    public void quickSort_empty_success() {
        int[] arr = EMPTY;
        QuickSort.sort(arr);
        expectEquals(EMPTY, arr);
    }

    @Test
    public void quickSort_singleElement_success() {
        int[] arr = SINGLE;
        QuickSort.sort(arr);
        expectEquals(SINGLE, arr);
    }

    @RepeatedTest(10)
    public void quickSort_randomElements_success() {
        int[] arr = randomArr();
        int[] expected = Arrays.copyOf(arr, arr.length);
        Arrays.sort(expected);
        QuickSort.sort(arr);
        expectEquals(expected, arr);
    }
}
