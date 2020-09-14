/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/28902/5ms-O(n)-Java-solution-explained-(beats-96)
 */
package com.zea7ot.leetcode.lvl4.lc0084;

public class SolutionApproach0DP1Dimen {
    public int largestRectangleArea(int[] heights) {
        // sanity check
        if (heights == null || heights.length == 0)
            return 0;

        final int N = heights.length;

        int[] lessFromLeft = new int[N];
        lessFromLeft[0] = -1;
        int[] lessFromRight = new int[N];
        lessFromRight[N - 1] = N;

        for (int i = 1; i < N; ++i) {
            int p = i - 1;

            while (p >= 0 && heights[p] >= heights[i]) {
                p = lessFromLeft[p];
            }

            lessFromLeft[i] = p;
        }

        for (int i = N - 2; i >= 0; --i) {
            int p = i + 1;

            while (p < N && heights[p] >= heights[i]) {
                p = lessFromRight[p];
            }

            lessFromRight[i] = p;
        }

        int maxArea = 0;
        for (int i = 0; i < N; ++i) {
            maxArea = Math.max(maxArea, heights[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }

        return maxArea;
    }
}
