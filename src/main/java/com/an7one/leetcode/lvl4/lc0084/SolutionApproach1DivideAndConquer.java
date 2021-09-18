package com.an7one.leetcode.lvl4.lc0084;

import com.an7one.util.Constant;

/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * <p>
 * Time complexity :
 * Average Case:   O(N * logN)
 * Worst Case:     O(N ^ 2)
 * If the numbers in the array are sorted, we don't gain the advantage of divide and conquer.
 * <p>
 * Space complexity : O(N)
 * O(N), consumed as the auxiliary space by the recursion
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach1DivideAndConquer {
    public int largestRectangleArea(int[] heights) {
        // sanity check
        if (heights == null || heights.length == 0)
            return 0;

        final int N = heights.length;
        return calculateArea(0, N - 1, heights);
    }

    private int calculateArea(int lo, int hi, final int[] HEIGHTS) {
        if (lo > hi)
            return 0;

        int minIndex = lo;
        for (int i = lo; i <= hi; ++i) {
            if (HEIGHTS[i] < HEIGHTS[minIndex]) {
                minIndex = i;
            }
        }

        return Math.max(HEIGHTS[minIndex] * (hi - lo + 1),
                Math.max(calculateArea(lo, minIndex - 1, HEIGHTS), calculateArea(minIndex + 1, hi, HEIGHTS)));
    }
}