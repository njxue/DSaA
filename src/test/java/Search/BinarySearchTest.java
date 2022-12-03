package Search;

import static Search.SearchUtil.EMPTY;
import static Search.SearchUtil.SORTED_EVEN_LENGTH;
import static Search.SearchUtil.SORTED_ODD_LENGTH;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BinarySearchTest {
    @Test
    public void search_existingElementOddLength_success() {
        int[] arr = SORTED_ODD_LENGTH;
        assertEquals(BinarySearch.search(arr, 0), 0);
        assertEquals(BinarySearch.search(arr, 10), 10);

        assertEquals(BinarySearch.search(arr, 1), 1);
        assertEquals(BinarySearch.search(arr, 9), 9);

        assertEquals(BinarySearch.search(arr, 5), 5);
        assertEquals(BinarySearch.search(arr, 6), 6);
    }

    @Test
    public void search_existingElementEvenLength_success() {
        int[] arr = SORTED_EVEN_LENGTH;
        assertEquals(BinarySearch.search(arr, 0), 0);
        assertEquals(BinarySearch.search(arr, 9), 9);

        assertEquals(BinarySearch.search(arr, 1), 1);
        assertEquals(BinarySearch.search(arr, 8), 8);

        assertEquals(BinarySearch.search(arr, 4), 4);
        assertEquals(BinarySearch.search(arr, 5), 5);
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
