/**
 * https://leetcode.com/problems/jump-game/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
package com.zea7ot.lc.lvl3.lc0055;

public class SolutionApproach0Greedy {
    public boolean canJump(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return false;

        final int N = nums.length;
        int furthest = 0;
        for (int i = 0; i < N; i++) {
            if (i > furthest)
                return false;
            furthest = Math.max(furthest, nums[i] + i);
        }

        return true;
    }
}