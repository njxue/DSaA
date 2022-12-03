package Sort;

import static Util.TestUtil.expectEquals;
import static Sort.SortUtil.EMPTY;
import static Sort.SortUtil.REVERSED_UNIQUE;
import static Sort.SortUtil.SINGLE;
import static Sort.SortUtil.SORTED_UNIQUE;

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

}
