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

public class SolutionApproach0MonoStack1 {
    public int maximalRectangle(char[][] matrix) {
        // sanity check
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        final int NR = matrix.length, NC = matrix[0].length;
        final int[] HEIGHTS = new int[NC + 1];
        HEIGHTS[NC] = 0;

        int max = 0;

        for (int row = 0; row < NR; ++row) {
            Deque<Integer> stack = new ArrayDeque<Integer>();
            for (int col = 0; col <= NC; ++col) {
                if (col < NC) {
                    if (matrix[row][col] == '1')
                        ++HEIGHTS[col];
                    else
                        HEIGHTS[col] = 0;
                }

                if (stack.isEmpty() || HEIGHTS[stack.peek()] <= HEIGHTS[col])
                    stack.push(col);
                else
                    while (!stack.isEmpty() && HEIGHTS[col] < HEIGHTS[stack.peek()]) {
                        int top = stack.pop();
                        int area = HEIGHTS[top] * (stack.isEmpty() ? col : (col - stack.peek() - 1));
                        if (area > max)
                            max = area;
                    }

                stack.push(col);
            }
        }

        return max;
    }
}