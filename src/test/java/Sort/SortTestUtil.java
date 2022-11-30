package Sort;

public class SortTestUtil {
    public static void expectEquals(int[] expectedArr, int[] actualArr) {
        if (expectedArr.length != actualArr.length) {
            throw new AssertionError("Arrays not equal");
        }

        for (int i = 0; i < expectedArr.length; i++) {
            if (expectedArr[i] != actualArr[i]) {
                throw new AssertionError("Arrays not equals");
            }
        }
    }
}
