package Sort;

public class SortUtil {
    static int[] SORTED_UNIQUE = {0,1,2,3,4,5,6,7,8,9};
    static int[] SORTED_UNIQUE_ALT = {0,1,2,3,4,5,6,7,8,9,10};
    static int[] SORTED_DUPLICATES = {0,0,1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9};

    static int[] REVERSED_UNIQUE = {9,8,7,6,5,4,3,2,1,0};
    static int[] REVERSED_UNIQUE_ALT = {10,9,8,7,6,5,4,3,2,1,0};
    static int[] REVERSED_DUPLICATES = {9,9,8,8,7,7,6,6,5,5,4,4,3,3,2,2,1,1,0,0};

    static int[] RANDOM_UNIQUE = {1,9,8,5,3,7,2,4,6,0};
    static int[] RANDOM_DUPLICATES = {1,9,8,5,3,7,2,4,6,0,1,9,8,5,3,7,2,4,6,0};

    static int[] DUPLICATES = {1,1,1,1,1,1,1,1,1,1};
    static int[] EMPTY = {};
    static int[] SINGLE = {0};

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
