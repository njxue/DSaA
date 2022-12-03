package Sort;

import static Sort.SortUtil.swap;

import java.util.Random;

public class QuickSort {
    static void sort(int[] arr) {
        sortHelper(arr, 0, arr.length);
    }

    static void sortHelper(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivotIndex = getPivotIndex(arr, start, end);
        int pos = 0;

        pos = partition(arr, start, end, pivotIndex);

        sortHelper(arr, start, pos);
        sortHelper(arr, pos + 1, end);
    }

    // 3-way partition
    static int partition(int[] arr, int start, int end, int pivotIndex) {
        if (start >= end - 1) {
            return pivotIndex;
        }

        int pivot = arr[pivotIndex];
        swap(arr, start, pivotIndex);
        int lo = start + 1;
        int hi = end - 1;
        while (lo <= hi) {
            while (lo < end && arr[lo] <= pivot) {
                lo++;
            }
            while (hi > 0 && arr[hi] > pivot) {
                hi--;
            }
            if (lo < hi) {
                swap(arr, lo, hi);
            }
        }

        int pos = lo - 1;
        swap(arr, pos, start);

        // group duplicates
        hi = pos - 1;
        lo = 0;

        while (lo < hi) {
            while (lo < hi && arr[lo] != pivot) {
                lo++;
            }
            while (hi > 0 && arr[hi] == pivot) {
                hi--;
            }
            if (lo < hi) {
                swap(arr, lo, hi);
                pos = hi;
            }
        }
        return pos;
    }

    // returns a random pivot between (inclusive) start and (exclusive) end
    static int getPivotIndex(int[] arr, int start, int end) {
        Random rand = new Random();
        return rand.nextInt(end - start) + start;
    }

    static boolean isGoodPivot(int pos) {
        return true;
    }
}
