package Search;

import static Search.SearchUtil.EMPTY;
import static Search.SearchUtil.SORTED_EVEN_LENGTH;
import static Search.SearchUtil.SORTED_ODD_LENGTH;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BinarySearchTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 10, 1, 9, 5, 6})
    public void search_existingElementOddLength_success(int k) {
        int[] arr = SORTED_ODD_LENGTH;
        assertEquals(k, BinarySearch.search(arr, k));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 9, 1, 8, 4, 5})
    public void search_existingElementEvenLength_success(int k) {
        int[] arr = SORTED_EVEN_LENGTH;
        assertEquals(k, BinarySearch.search(arr, k));
    }

    @Test
    public void search_nonExistingElementOddLength_success() {
        int[] arr = SORTED_ODD_LENGTH;
        assertEquals(BinarySearch.search(arr, -1), -1);
        assertEquals(BinarySearch.search(arr, 11), -1);
    }

    @Test
    public void search_nonExistingElementEvenLength_success() {
        int[] arr = SORTED_EVEN_LENGTH;
        assertEquals(BinarySearch.search(arr, -1), -1);
        assertEquals(BinarySearch.search(arr, 11), -1);
    }

    @Test
    public void search_empty_success() {
        assertEquals(BinarySearch.search(EMPTY, 0), -1);
    }
}
