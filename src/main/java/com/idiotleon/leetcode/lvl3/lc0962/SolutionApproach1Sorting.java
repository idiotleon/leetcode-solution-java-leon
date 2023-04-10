/**
 * https://leetcode.com/problems/maximum-width-ramp/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/maximum-width-ramp/discuss/265765/Detailed-Explaination-of-all-the-three-approaches
 */
package com.idiotleon.leetcode.lvl3.lc0962;

import java.util.Arrays;

public class SolutionApproach1Sorting {
    public int maxWidthRamp(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;

        int[][] pairs = new int[N][2];
        for (int i = 0; i < N; ++i) {
            pairs[i] = new int[] { nums[i], i };
        }
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

        int widest = 0;
        int shortest = N;

        for (int[] pair : pairs) {
            widest = Math.max(widest, pair[1] - shortest);
            shortest = Math.min(shortest, pair[1]);
        }

        return widest;
    }
}
