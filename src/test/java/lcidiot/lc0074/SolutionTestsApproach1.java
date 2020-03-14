package test.java.lcidiot.lc0074;

import org.junit.jupiter.api.Test;

import test.java.lcidiot.utils.Constants.Matrix;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class SolutionTestsApproach1 {
    private final SolutionApproach1 approach1 = new SolutionApproach1();

    @Test
    void testRegularMatrix() {
        assertTrue(approach1.searchMatrix(Matrix.ROW_COLUMN_INTEGRALLY_SORTED, 3));
        assertFalse(approach1.searchMatrix(Matrix.ROW_COLUMN_INTEGRALLY_SORTED, 13));
    }

    @Test
    void testShortMatrix() {
        assertTrue(approach1.searchMatrix(Matrix.SHORT, 3));
        assertFalse(approach1.searchMatrix(Matrix.SHORT, 5));
    }

    @Test
    void testLeanMatrix() {
        assertTrue(approach1.searchMatrix(Matrix.LEAN, 3));
        assertFalse(approach1.searchMatrix(Matrix.LEAN, 5));
    }

    @Test
    void testTinyMatrix() {
        assertTrue(approach1.searchMatrix(Matrix.TINY, 1));
        assertFalse(approach1.searchMatrix(Matrix.TINY, 5));
    }

    @Test
    void testEmptyMatrix() {
        assertFalse(approach1.searchMatrix(Matrix.EMPTY, 3));
        assertFalse(approach1.searchMatrix(Matrix.EMPTY, 5));
    }
}