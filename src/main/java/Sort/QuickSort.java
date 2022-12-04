package Sort;

import static Sort.SortUtil.swap;

import java.util.Random;

public class QuickSort {
    static void sort(int[] arr) {
        sortHelper(arr, 0, arr.length);
    }

    private static void sortHelper(int[] arr, int start, int end) {
        if (start >= end - 1) {
            return;
        }

        int pos;

        do {
            int pivotIndex = getPivotIndex(arr, start, end);
            pos = partition(arr, start, end, pivotIndex);
        } while (!isGoodPivot(pos, start, end));

        sortHelper(arr, start, pos);
        sortHelper(arr, pos + 1, end);
    }

    // 3-way partition
    public static int partition(int[] arr, int start, int end, int pivotIndex) {
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
    public static int getPivotIndex(int[] arr, int start, int end) {
        Random rand = new Random();
        return rand.nextInt(end - start) + start;
    }

    private static boolean isGoodPivot(int pos, int start, int end) {
        int numTotal = end - start;
        int numLeft = pos - start + 1;
        int numRight = end - pos + 1;
        return ((float)numLeft / numTotal) > 0.1 && ((float) numRight / numTotal) > 0.1;
    }
}
