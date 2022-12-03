package Util;

import java.util.Arrays;

public class TestUtil {
    public static final String MESSAGE = "Arrays not equal\nExpected: %s\nActual: %s";

    public static void expectEquals(int[] expectedArr, int[] actualArr) {
        if (expectedArr.length != actualArr.length) {
            throw new AssertionError(String.format(MESSAGE,
                    Arrays.toString(expectedArr), Arrays.toString(actualArr)));
        }

        for (int i = 0; i < expectedArr.length; i++) {
            if (expectedArr[i] != actualArr[i]) {
                throw new AssertionError(String.format(MESSAGE,
                        Arrays.toString(expectedArr), Arrays.toString(actualArr)));
            }
        }
    }
}
