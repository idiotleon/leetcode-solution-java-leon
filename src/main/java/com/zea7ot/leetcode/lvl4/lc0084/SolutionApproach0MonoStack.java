/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/28900/Short-and-Clean-O(n)-stack-based-JAVA-solution
 *  https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/28900/Short-and-Clean-O(n)-stack-based-JAVA-solution/27725
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

        int maxArea = 0;

        Deque<Integer> stack = new ArrayDeque<>();
        int idx = 0;

        while (idx <= N) {
            int height = (idx == N) ? 0 : heights[idx];
            if (stack.isEmpty() || height >= heights[stack.peek()]) {
                stack.push(idx++);
            } else {
                int top = stack.pop();
                maxArea = Math.max(maxArea, heights[top] * (stack.isEmpty() ? idx : idx - 1 - stack.peek()));
            }
        }

        return maxArea;
    }
}
