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

public class RadixSortTest {
    @Test
    public void radixSort_reversed_success() {
        int[] arr = REVERSED_UNIQUE;
        RadixSort.sort(arr);
        System.out.println(SORTED_UNIQUE);
        expectEquals(SORTED_UNIQUE, arr);
    }

    @Test
    public void radixSort_sorted_success() {
        int[] arr = SORTED_UNIQUE;
        RadixSort.sort(arr);
        expectEquals(SORTED_UNIQUE, arr);
    }

    @Test
    public void radixSort_empty_success() {
        int[] arr = EMPTY;
        RadixSort.sort(arr);
        expectEquals(EMPTY, arr);
    }

    @Test
    public void radixSort_singleElement_success() {
        int[] arr = SINGLE;
        RadixSort.sort(arr);
        expectEquals(SINGLE, arr);
    }

    @RepeatedTest(10)
    public void radixSort_randomElements_success() {
        int[] arr = randomArr();
        int[] expected = Arrays.copyOf(arr, arr.length);
        Arrays.sort(expected);
        RadixSort.sort(arr);
        expectEquals(expected, arr);
    }
}
