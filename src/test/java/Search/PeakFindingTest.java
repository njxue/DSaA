package Search;

import static Search.SearchUtil.RANDOM_EVEN_LENGTH;
import static Search.SearchUtil.RANDOM_ODD_LENGTH;
import static Search.SearchUtil.REVERSED_EVEN_LENGTH;
import static Search.SearchUtil.REVERSED_ODD_LENGTH;
import static Search.SearchUtil.SINGLE;
import static Search.SearchUtil.SORTED_EVEN_LENGTH;
import static Search.SearchUtil.SORTED_ODD_LENGTH;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PeakFindingTest {

    @Test
    public void select_sortedOddLength_success() {
        int[] arr = SORTED_ODD_LENGTH;
        assertEquals(10, PeakFinding.find(arr));
    }

    @Test
    public void select_randomOddLength_success() {
        int[] arr = RANDOM_ODD_LENGTH;
        assertEquals(10, PeakFinding.find(arr));
    }

    @Test
    public void select_reversedOddLength_success() {
        int[] arr = REVERSED_ODD_LENGTH;
        assertEquals(10, PeakFinding.find(arr));
    }

    @Test
    public void select_sortedEvenLength_success() {
        int[] arr = SORTED_EVEN_LENGTH;
        assertEquals(9, PeakFinding.find(arr));
    }

    @Test
    public void select_randomEvenLength_success() {
        int[] arr = RANDOM_EVEN_LENGTH;
        assertEquals(9, PeakFinding.find(arr));
    }

    @Test
    public void select_reversedEvenLength_success() {
        int[] arr = REVERSED_EVEN_LENGTH;
        assertEquals(9, PeakFinding.find(arr));
    }

    @Test
    public void select_singleElement_success() {
        int[] arr = SINGLE;
        assert SINGLE[0] == 0;
        assertEquals(0, PeakFinding.find(arr));
    }
}
