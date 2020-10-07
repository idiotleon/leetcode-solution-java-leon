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
package com.zea7ot.leetcode.lvl4.lc0042;

public class SolutionApproach0TwoPointers2 {
    public int trap(int[] heights) {
        // sanity check
        if (heights == null || heights.length < 2)
            return 0;

        final int N = heights.length;

        int lo = 0, hi = N - 1;
        int ans = 0;
        int loMax = 0, hiMax = 0;

        while (lo < hi)
            if (heights[lo] < heights[hi]) {
                if (heights[lo] >= loMax)
                    loMax = heights[lo];
                else
                    ans += (loMax - heights[lo]);
                ++lo;
            } else {
                if (heights[hi] >= hiMax)
                    hiMax = heights[hi];
                else
                    ans += (hiMax - heights[hi]);
                --hi;
            }

        return ans;
    }
}