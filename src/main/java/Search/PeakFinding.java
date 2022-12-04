package Search;

public class PeakFinding {
    static int find(int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;
        int mid = 0;

        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (mid == 0 || mid == arr.length - 1) {
                return arr[mid]; // if recurse until boundary values -> boundary values are peaks
            }

            if (arr[mid] < arr[mid + 1]) {
                lo = mid + 1;
            } else if (arr[mid] < arr[mid - 1]) {
                hi = mid - 1;
            } else {
                return arr[mid];
            }
        }
        return arr[mid];
    }
}
