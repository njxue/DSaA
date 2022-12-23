package Sort;

import java.util.Arrays;

public class RadixSort {
    public static void sort(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        int[] sorted;
        int exp = (int) Math.ceil(Math.log10(findMax(arr)));

        for (int i = 0; i <= exp; i++) {
            int e = (int) Math.pow(10, i);
            int[] buckets = new int[10];
            sorted = new int[arr.length];
            for (int n : arr) {
                buckets[(Math.abs(n) / e) % 10]++;
            }

            for (int j = 1; j < 10; j++) {
                buckets[j] += buckets[j - 1];
            }

            // iterate from the back ensures stability
            for (int k = arr.length - 1; k >= 0; k--) {
                int idx = buckets[(Math.abs(arr[k]) / e) % 10];
                sorted[idx - 1] = arr[k];
                buckets[(Math.abs(arr[k]) / e) % 10]--;
            }

            for (int m = 0; m < arr.length; m++) {
                arr[m] = sorted[m];
            }
        }

        // account for negative numbers. This disrupts stability
        int p = arr.length - 1;
        int n = 0;
        sorted = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] >= 0) {
                sorted[p] = arr[i];
                p--;
            } else {
                sorted[n] = arr[i];
                n++;
            }
        }

        // restores stability by reversing sequences of the same negative integers. Runs in O(n)
        int s = 0; int e = 0;
        while (s < n) {
            while (sorted[e] == sorted[s]) {
                e++;
            }
            reverse(s, e - 1, sorted);
            s = e;
        }

        for (int m = 0; m < arr.length; m++) {
            arr[m] = sorted[m];
        }
    }

    private static int findMax(int[] arr) {
        int max = arr[0];
        for (int i : arr) {
            max = Math.max(max, i);
        }
        return max;
    }

    private static void reverse(int s, int e, int[] arr) {
        while (s < e) {
            int tmp = arr[s];
            arr[s] = arr[e];
            arr[e] = tmp;
            s++;
            e--;
        }
    }
}
