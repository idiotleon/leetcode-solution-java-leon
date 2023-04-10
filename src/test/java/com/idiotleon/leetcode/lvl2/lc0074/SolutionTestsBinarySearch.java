package com.idiotleon.leetcode.lvl2.lc0074;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.idiotleon.util.Constants.Matrix;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class SolutionTestsBinarySearch {
    private final SolutionApproach0BinarySearch binarySearch = new SolutionApproach0BinarySearch();

    @Test
    void testRegularMatrix() {
        assertTrue(binarySearch.searchMatrix(Matrix.ROW_COLUMN_INTEGRALLY_SORTED, 3));
        assertFalse(binarySearch.searchMatrix(Matrix.ROW_COLUMN_INTEGRALLY_SORTED, 13));
    }

    @Test
    void testShortMatrix() {
        assertTrue(binarySearch.searchMatrix(Matrix.SHORT, 3));
        assertFalse(binarySearch.searchMatrix(Matrix.SHORT, 5));
    }

    @Test
    void testLeanMatrix() {
        assertTrue(binarySearch.searchMatrix(Matrix.LEAN, 3));
        assertFalse(binarySearch.searchMatrix(Matrix.LEAN, 5));
    }

    @Test
    void testTinyMatrix() {
        assertTrue(binarySearch.searchMatrix(Matrix.TINY, 1));
        assertFalse(binarySearch.searchMatrix(Matrix.TINY, 5));
    }

    @Test
    void testEmptyMatrix() {
        assertFalse(binarySearch.searchMatrix(Matrix.EMPTY, 3));
        assertFalse(binarySearch.searchMatrix(Matrix.EMPTY, 5));
    }
}