package com.idiotleon.leetcode.lvl4.lc0084;

import com.idiotleon.util.Constant;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * <p>
 * References:
 * https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/28900/Short-and-Clean-O(n)-stack-based-JAVA-solution
 * https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/28900/Short-and-Clean-O(n)-stack-based-JAVA-solution/27725
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0MonoStack1 {
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
                int top = stack.pop(); // concave/lowest
                maxArea = Math.max(maxArea, heights[top] * (stack.isEmpty() ? idx : idx - 1 - stack.peek()));
            }
        }

        return maxArea;
    }
}
