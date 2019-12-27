package com.idiotleon.java.lc0378;

import com.idiotleon.java.utils.Constants;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTestsApproachBinarySearch {
    private final SolutionApproachBinarySearch approachBinarySearch = new SolutionApproachBinarySearch();

    @Test
    @DisplayName("0378. Kth Smallest Element in a Sorted Matrix - Binary Search")
    void test() {
        assertEquals(13, approachBinarySearch.kthSmallest(Constants.Matrix.ROW_COLUMN_SEPARATELY_SORTED, 8));
        assertEquals(13, approachBinarySearch.kthSmallest(Constants.Matrix.ROW_COLUMN_SEPARATELY_SORTED, 7));
    }

    @Test
    @DisplayName("0378. Kth Smallest Element in a Sorted Matrix - Empty Matrix - Binary Search")
    void testEmptyMatrix() {
        assertEquals(-1, approachBinarySearch.kthSmallest(Constants.Matrix.EMPTY, 8));
        assertEquals(-1, approachBinarySearch.kthSmallest(Constants.Matrix.EMPTY, 0));
    }

    @Test
    @DisplayName("0378. Kth Smallest Element in a Sorted Matrix - Invalid Input - Binary Search")
    void testInvalidInput() {
        // invalid k
        assertEquals(-1, approachBinarySearch.kthSmallest(Constants.Matrix.EMPTY, -1));
        assertEquals(-1, approachBinarySearch.kthSmallest(Constants.Matrix.ROW_COLUMN_SEPARATELY_SORTED, 10000));
    }
}