package Sort;

public class SelectionSort {
    static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = getMinIndex(i, arr);
            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }
    }

    private static int getMinIndex(int start, int[] arr) {
        int minIndex = start;
        for (int i = start; i < arr.length; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }
}
