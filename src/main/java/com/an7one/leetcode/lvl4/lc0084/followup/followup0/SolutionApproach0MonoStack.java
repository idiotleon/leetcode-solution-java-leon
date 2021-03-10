/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * to get the largest rectangle, with one cerntain column included
 * 
 * e.g.:
 *  to get the largest rectangle, with x = 3 (heights[3]) included
 * 
 * this solution is NOT verified
 */
package com.an7one.leetcode.lvl4.lc0084.followup.followup0;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0MonoStack {
    public int largestRectangleArea(int[] heights, int target) {
        // sanity check
        if (heights == null || heights.length == 0)
            return 0;

        final int N = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;

        for (int idx = 0; idx < N; ++idx) {
            while (!stack.isEmpty() && heights[idx] < heights[stack.peek()]) {
                // the height of the concave
                int shortest = heights[stack.pop()];
                // the current width
                int width = idx - (stack.isEmpty() ? 0 : (stack.peek() + 1));
                // the current area
                int area = shortest * width;
                if (isIncluded(target, stack.peek(), idx)) {
                    maxArea = Math.max(maxArea, area);
                }
            }

            stack.push(idx);
        }

        while (!stack.isEmpty()) {
            // the height of the concave
            int shortest = heights[stack.pop()];
            // the current width
            int width = N - (stack.isEmpty() ? 0 : (stack.peek() + 1));
            // the current area
            int area = shortest * width;
            if (isIncluded(target, stack.peek(), N - 1)) {
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }

    // whether the target is included in the range [lo, hi], both ends included
    private boolean isIncluded(int target, int lo, int hi) {
        return target >= lo && target <= hi;
    }
}