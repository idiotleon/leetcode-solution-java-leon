package lcidiot.lc0240;

import org.junit.jupiter.api.Test;

import lcidiot.utils.Constants;

import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertTrue;


import static org.junit.jupiter.api.Assertions.assertFalse;

class SolutionTests {
    private final SolutionApproachBinarySearch approachBinarySearch = new SolutionApproachBinarySearch();

    @Test
    @DisplayName("240. Search a 2D Matrix II")
    void test() {
        assertTrue(approachBinarySearch.searchMatrix(Constants.Matrix.ROW_COLUMN_SEPARATELY_SORTED, 5));
        assertFalse(approachBinarySearch.searchMatrix(Constants.Matrix.ROW_COLUMN_SEPARATELY_SORTED, 20));
    }
}