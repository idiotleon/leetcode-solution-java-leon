package com.polyg7ot.lc.lvl3.lc0074;

import com.polyg7ot.lc.utils.Constants.Matrix;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SolutionTestsApproachBinarySearch1 {
    private final SolutionApproachBinarySearch1 binarySearch1 = new SolutionApproachBinarySearch1();

    @Test
    void testRegularMatrix() {
        assertTrue(binarySearch1.searchMatrix(Matrix.ROW_COLUMN_INTEGRALLY_SORTED, 3));
        assertFalse(binarySearch1.searchMatrix(Matrix.ROW_COLUMN_INTEGRALLY_SORTED, 13));
    }

    @Test
    void testShortMatrix() {
        assertTrue(binarySearch1.searchMatrix(Matrix.SHORT, 3));
        assertFalse(binarySearch1.searchMatrix(Matrix.SHORT, 5));
    }

    @Test
    void testLeanMatrix() {
        assertTrue(binarySearch1.searchMatrix(Matrix.LEAN, 3));
        assertFalse(binarySearch1.searchMatrix(Matrix.LEAN, 5));
    }

    @Test
    void testTinyMatrix() {
        assertTrue(binarySearch1.searchMatrix(Matrix.TINY, 1));
        assertFalse(binarySearch1.searchMatrix(Matrix.TINY, 5));
    }

    @Test
    void testEmptyMatrix() {
        assertFalse(binarySearch1.searchMatrix(Matrix.EMPTY, 3));
        assertFalse(binarySearch1.searchMatrix(Matrix.EMPTY, 5));
    }
}