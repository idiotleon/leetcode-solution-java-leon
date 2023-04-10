/**
 * https://leetcode.com/problems/trapping-rain-water/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/trapping-rain-water/discuss/17391/Share-my-short-solution./185869
 *  https://leetcode.com/problems/trapping-rain-water/discuss/17391/Share-my-short-solution.
 */
package com.idiotleon.leetcode.lvl4.lc0042;

public class SolutionApproach0TwoPointers {
    public int trap(int[] heights) {
        // sanity check
        if (heights == null || heights.length == 0)
            return 0;

        final int N = heights.length;

        int lo = 0, hi = N - 1;
        int loMax = Integer.MIN_VALUE, hiMax = Integer.MIN_VALUE;
        int water = 0;

        while (lo <= hi) {
            loMax = Math.max(loMax, heights[lo]);
            hiMax = Math.max(hiMax, heights[hi]);

            if (loMax < hiMax) {
                water += loMax - heights[lo];
                ++lo;
            } else {
                water += hiMax - heights[hi];
                --hi;
            }
        }

        return water;
    }
}
