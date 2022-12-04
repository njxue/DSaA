package Search;

import static Search.SearchUtil.RANDOM_EVEN_LENGTH;
import static Search.SearchUtil.RANDOM_ODD_LENGTH;
import static Search.SearchUtil.SINGLE;
import static Search.SearchUtil.SORTED_EVEN_LENGTH;
import static Search.SearchUtil.SORTED_ODD_LENGTH;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class QuickSelectTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11})
    public void select_validPositionSortedOddLength_success(int k) {
        int[] arr = SORTED_ODD_LENGTH;
        assertEquals(k - 1, QuickSelect.select(arr, k));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11})
    public void select_validPositionRandomOddLength_success(int k) {
        int[] arr = RANDOM_ODD_LENGTH;
        assertEquals(k - 1, QuickSelect.select(arr, k));
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    public void select_validPositionSortedEvenLength_success(int k) {
        int[] arr = SORTED_EVEN_LENGTH;
        assertEquals(k - 1, QuickSelect.select(arr, k));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    public void select_validPositionRandomEvenLength_success(int k) {
        int[] arr = RANDOM_EVEN_LENGTH;
        assertEquals(k - 1, QuickSelect.select(arr, k));
    }

    @Test
    public void select_singleElement_success() {
        int[] arr = SINGLE;
        assert SINGLE[0] == 0;
        assertEquals(0, QuickSelect.select(arr, 1));
    }
}
