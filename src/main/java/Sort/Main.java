package Sort;

import static Sort.SortUtil.REVERSED;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = REVERSED;
        BubbleSort.sort(arr);
        System.out.println(Arrays.toString(REVERSED));
    }
}
