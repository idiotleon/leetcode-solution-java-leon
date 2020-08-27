/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * to maintain a "non-descreasing" stack
 *  1. the content(s) of the `stack` is(are) index(es)
 *  2. the elements/heights, accessed by indexes, are non-descreasing
 */
package com.zea7ot.leetcode.lvl4.lc0084;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0MonoStack {
    public int largestRectangleArea(int[] heights) {
        // sanity check
        if (heights == null || heights.length == 0)
            return 0;

        final int N = heights.length;

        Deque<Integer> stack = new ArrayDeque<Integer>();
        int idx = 0;
        int max = 0;

        while (idx < N) {
            // once a lower height has been found, to "check out" to the leftmost taller
            // height
            // 1. to calculate the area for each left taller height
            // 2. to get the max area/value among all along the way
            while (!stack.isEmpty() && heights[idx] < heights[stack.peek()])
                max = Math.max(max, heights[stack.pop()] * (idx - (stack.isEmpty() ? 0 : stack.peek() + 1)));

            stack.push(idx);
            ++idx;
        }

        // if there is any element/height left,
        // their heights all are "non-decreasing"
        while (!stack.isEmpty()) {
            max = Math.max(max, heights[stack.pop()] * (N - (stack.isEmpty() ? 0 : stack.peek() + 1)));
        }

        return max;
    }
}