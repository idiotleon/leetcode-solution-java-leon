package com.an7one.leetcode.lvl4.lc0084;

import com.an7one.util.Constant;

/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * <p>
 * `loweFromLeft[i]`, the first index/coordinate oft he bar to the left with a height of `heights[l] < heights[i]`
 * `loweFromRight[i]`, the first index/coordinate oft he bar to the right with a height of `heights[r] < heights[i]`
 * <p>
 * References:
 * https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/28902/5ms-O(n)-Java-solution-explained-(beats-96)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DP1Dimen {
    public int largestRectangleArea(int[] heights) {
        // sanity check
        if (heights == null || heights.length == 0)
            return 0;

        final int N = heights.length;

        int[] lowerFromLeft = new int[N];
        lowerFromLeft[0] = -1;
        int[] lowerFromRight = new int[N];
        lowerFromRight[N - 1] = N;

        for (int i = 1; i < N; ++i) {
            int prev = i - 1;

            while (prev >= 0 && heights[prev] >= heights[i]) {
                prev = lowerFromLeft[prev];
            }

            lowerFromLeft[i] = prev;
        }

        for (int i = N - 2; i >= 0; --i) {
            int prev = i + 1;

            while (prev < N && heights[prev] >= heights[i]) {
                prev = lowerFromRight[prev];
            }

            lowerFromRight[i] = prev;
        }

        int maxArea = 0;
        for (int i = 0; i < N; ++i) {
            maxArea = Math.max(maxArea, heights[i] * (lowerFromRight[i] - lowerFromLeft[i] - 1));
        }

        return maxArea;
    }
}
