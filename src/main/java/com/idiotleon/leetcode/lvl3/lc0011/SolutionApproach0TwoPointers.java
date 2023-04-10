package com.idiotleon.leetcode.lvl3.lc0011;

import com.idiotleon.util.Constant;

/**
 * <a href="https://leetcode.com/problems/container-with-most-water/">LC0011</a>
 * <p>
 * Time Complexity:     O(`N`)
 * Space Complexity:    O(1)
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/container-with-most-water/discuss/6091/Easy-Concise-Java-O(N)-Solution-with-Proof-and-Explanation">LC Discussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0TwoPointers {
    public int maxArea(int[] heights) {
        // sanity check
        if (heights == null || heights.length == 0)
            return 0;
        final int N = heights.length;
        int lo = 0, hi = N - 1;
        int maxArea = 0;

        while (lo < hi) {
            final int area = Math.min(heights[lo], heights[hi]) * (hi - lo);
            maxArea = Math.max(maxArea, area);

            if (heights[lo] < heights[hi])
                ++lo;
            else
                --hi;
        }

        return maxArea;
    }
}
