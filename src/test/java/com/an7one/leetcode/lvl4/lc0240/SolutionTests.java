package com.an7one.leetcode.lvl4.lc0240;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.an7one.util.Constants;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class SolutionTests {
    private final SolutionApproachBinarySearch approachBinarySearch = new SolutionApproachBinarySearch();

    @Test
    @DisplayName("240. Search a 2D Matrix II")
    void test() {
        assertTrue(approachBinarySearch.searchMatrix(Constants.Matrix.ROW_COLUMN_SEPARATELY_SORTED, 5));
        assertFalse(approachBinarySearch.searchMatrix(Constants.Matrix.ROW_COLUMN_SEPARATELY_SORTED, 20));
    }
}