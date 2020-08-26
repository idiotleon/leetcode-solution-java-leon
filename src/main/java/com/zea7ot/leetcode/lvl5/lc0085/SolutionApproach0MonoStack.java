/**
 * https://leetcode.com/problems/maximal-rectangle/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(NR * NC)
 * 
 * References:
 *  https://leetcode.com/problems/maximal-rectangle/discuss/29064/A-O(n2)-solution-based-on-Largest-Rectangle-in-Histogram
 */
package com.zea7ot.leetcode.lvl5.lc0085;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0MonoStack {
    public int maximalRectangle(char[][] matrix) {
        // sanity check
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        final int NR = matrix.length, NC = matrix[0].length;
        final int[] HEIGHTS = new int[NC];

        int max = 0;

        for (int row = 0; row < NR; ++row) {
            for (int col = 0; col < NC; ++col) {
                if (matrix[row][col] == '1')
                    ++HEIGHTS[col];
                else
                    HEIGHTS[col] = 0;
            }

            max = Math.max(max, getMaxArea(HEIGHTS));
        }

        return max;
    }

    private int getMaxArea(final int[] HEIGHTS) {
        final int N = HEIGHTS.length;

        Deque<Integer> stack = new ArrayDeque<>();
        int max = 0;
        int idx = 0;

        while (idx < N) {
            while (!stack.isEmpty() && HEIGHTS[idx] < HEIGHTS[stack.peek()])
                max = Math.max(max, HEIGHTS[stack.pop()] * (idx - (stack.isEmpty() ? 0 : stack.peek() + 1)));

            stack.push(idx);
            ++idx;
        }

        while (!stack.isEmpty())
            max = Math.max(max, HEIGHTS[stack.pop()] * (N - (stack.isEmpty() ? 0 : stack.peek() + 1)));

        return max;
    }
}