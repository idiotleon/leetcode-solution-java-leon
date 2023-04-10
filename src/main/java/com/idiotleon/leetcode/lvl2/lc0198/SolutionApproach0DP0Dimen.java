/**
 * https://leetcode.com/problems/house-robber/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/house-robber/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems.
 */
package com.idiotleon.leetcode.lvl2.lc0198;

public class SolutionApproach0DP0Dimen {
    public int rob(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        int inclusive = 0, exclusive = 0;

        for (int num : nums) {
            final int PREV_EXCLUSIVE = exclusive;
            final int PREV_INCLUSIVE = inclusive;

            exclusive = Math.max(PREV_EXCLUSIVE, PREV_INCLUSIVE);
            inclusive = num + PREV_EXCLUSIVE;
        }

        return Math.max(exclusive, inclusive);
    }
}