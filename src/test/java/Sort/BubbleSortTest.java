package Sort;

import static Util.TestUtil.expectEquals;
import static Sort.SortUtil.EMPTY;
import static Sort.SortUtil.REVERSED_UNIQUE;
import static Sort.SortUtil.SINGLE;
import static Sort.SortUtil.SORTED_UNIQUE;

import org.junit.jupiter.api.Test;

public class BubbleSortTest {

    @Test
    public void bubbleSort_reversed_success() {
        int[] arr = REVERSED_UNIQUE;
        BubbleSort.sort(arr);
        expectEquals(SORTED_UNIQUE, arr);
    }

    @Test
    public void bubbleSort_sorted_success() {
        int[] arr = SORTED_UNIQUE;
        BubbleSort.sort(arr);
        expectEquals(SORTED_UNIQUE, arr);
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

}
