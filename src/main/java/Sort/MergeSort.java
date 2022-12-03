package Sort;

public class MergeSort {
    static void sort(int[] arr) {
        sortHelper(arr, 0, arr.length - 1);
    }

    static void sortHelper(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        sortHelper(arr, start, mid);
        sortHelper(arr, mid + 1, end);
        merge(arr, start, end, mid);
    }

    static void merge(int[] arr, int start, int end, int mid) {
        int[] merged = new int[end - start + 1];
        int ptrA = start;
        int ptrB = mid + 1;
        int i = 0;
        while (ptrA <= mid && ptrB <= end) {
            if (arr[ptrA] < arr[ptrB]) {
                merged[i] = arr[ptrA];
                ptrA++;
            } else {
                merged[i] = arr[ptrB];
                ptrB++;
            }
            i++;
        }
        while (ptrA <= mid) {
            merged[i] = arr[ptrA];
            ptrA++;
            i++;
        }

        while (ptrB <= mid) {
            merged[i] = arr[ptrB];
            ptrB++;
            i++;
        }

        // copy from merged to arr
        for (int j = 0; j < merged.length; j++) {
            arr[start + j] = merged[j];
        }
    }
}
