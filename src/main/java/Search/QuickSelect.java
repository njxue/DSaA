package Search;

import static Sort.QuickSort.getPivotIndex;
import static Sort.QuickSort.partition;


public class QuickSelect {

    // precondition: k = arr.length && k >= 1
    static int select(int[] arr, int k) {
        return selectHelper(arr, k - 1, 0, arr.length);
    }

    private static int selectHelper(int[] arr, int k, int start, int end) {
        int pivotIndex = getPivotIndex(arr, start, end);
        int pos = partition(arr, start, end, pivotIndex);
        if (pos == k) {
            return arr[pos];
        } else if (k < pos) {
            return selectHelper(arr, k, start, pos);
        } else {
            return selectHelper(arr, k, pos + 1, end);
        }
    }
}
