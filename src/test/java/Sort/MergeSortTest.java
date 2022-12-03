package Sort;

import static Util.TestUtil.expectEquals;
import static Sort.SortUtil.EMPTY;
import static Sort.SortUtil.REVERSED_UNIQUE;
import static Sort.SortUtil.SINGLE;
import static Sort.SortUtil.SORTED_UNIQUE;

import org.junit.jupiter.api.Test;

public class MergeSortTest {

    @Test
    public void mergeSort_reversed_success() {
        int[] arr = REVERSED_UNIQUE;
        MergeSort.sort(arr);
        expectEquals(SORTED_UNIQUE, arr);
    }

    @Test
    public void mergeSort_sorted_success() {
        int[] arr = SORTED_UNIQUE;
        MergeSort.sort(arr);
        expectEquals(SORTED_UNIQUE, arr);
    }

    @Test
    public void mergeSort_empty_success() {
        int[] arr = EMPTY;
        MergeSort.sort(arr);
        expectEquals(EMPTY, arr);
    }

    @Test
    public void mergeSort_singleElement_success() {
        int[] arr = SINGLE;
        MergeSort.sort(arr);
        expectEquals(SINGLE, arr);
    }

}
