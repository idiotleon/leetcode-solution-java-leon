/**
 * https://leetcode.com/problems/trapping-rain-water/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/trapping-rain-water/discuss/17395/A-different-O(n)-approach-easy-to-understand-and-simple-code
 */
package com.an7one.leetcode.lvl4.lc0042;

public class SolutionApproach0DP1Dimen {
    public int trap(int[] height) { // [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
        // sanity check
        if (height == null || height.length == 0)
            return 0;

        final int N = height.length;
        int[] left = new int[N], right = new int[N];
        int water = 0;

        for (int i = 0; i < N; ++i) { // [0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3]
            left[i] = (i == 0) ? height[i] : Math.max(left[i - 1], height[i]);
        }

        for (int i = N - 1; i >= 0; --i) { // [3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 1]
            right[i] = (i == N - 1) ? height[i] : Math.max(right[i + 1], height[i]);
        }

        /**
         * left: [0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3] right: [3, 3, 3, 3, 3, 3, 3, 3, 2,
         * 2, 2, 1] Math.min(left[i], right[i]): [0, 1, 1, 2, 2, 2, 2, 3, 2, 2, 2, 1]
         * height: [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
         * 
         * Math.min(left[i], right[i]) - height[i]: [0, 0, 1, 0, 1, 2, 1, 0, 0, 1, 0, 0]
         * 
         * water = 6
         */
        for (int i = 0; i < N; ++i) {
            water += Math.min(left[i], right[i]) - height[i];
        }

        return water;
    }
}