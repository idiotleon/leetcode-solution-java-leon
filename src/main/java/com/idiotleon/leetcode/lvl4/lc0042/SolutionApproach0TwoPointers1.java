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

public class SolutionApproach0TwoPointers1 {
    public int trap(int[] heights) { // [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
        // sanity check
        if (heights == null || heights.length < 2)
            return 0;

        final int N = heights.length; // 12
        int lo = 0, hi = N - 1; // left: 0, right: 11
        int water = 0;
        int loMax = heights[lo], hiMax = heights[hi]; // leftMax: 0, rightMax: 1

        while (lo < hi) {
            if (loMax < hiMax) {
                water += loMax - heights[lo];
                loMax = Math.max(loMax, heights[++lo]);
            } else {
                water += hiMax - heights[hi];
                hiMax = Math.max(hiMax, heights[--hiMax]);
            }
        }

        return water;
    }
}