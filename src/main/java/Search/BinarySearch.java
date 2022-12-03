package Search;

public class BinarySearch {
    static int search(int[] arr, int value) {
        int lo = 0;
        int hi = arr.length;
        int mid;

        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] < value) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return -1;
    }
}
