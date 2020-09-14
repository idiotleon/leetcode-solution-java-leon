/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * 
 * Time complexity:     O(N)
 * Space complexity:    O(N)
 */
package com.zea7ot.leetcode.lvl4.lc0084;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0MonoStack2 {
    public int largestRectangleArea(int[] heights) {
        // sanity check
        if (heights == null || heights.length == 0)
            return 0;

        final int N = heights.length;
        int maxArea = 0;

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);

        for (int i = 0; i < N; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
            }

            stack.push(i);
        }

        while (stack.peek() != -1) {
            maxArea = Math.max(maxArea, heights[stack.pop()] * (N - stack.peek() - 1));
        }

        return maxArea;
    }
}