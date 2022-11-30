package Sort;

public class BubbleSort {

    public static void sort(int[] arr) {
        boolean done = false;
        int i = arr.length - 1;
        while (!done) {
            done = true;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    done = false;
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
            i--;
        }
    }
}
