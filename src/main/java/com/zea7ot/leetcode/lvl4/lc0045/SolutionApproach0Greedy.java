/**
 * https://leetcode.com/problems/jump-game-ii/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N) / O(1)
 * 
 * To find the next best/farthest jump in the range this jump can reach.
 * If any position cannot be reached, to return -1.
 * 
 * References:
 *  https://youtu.be/G88X89Eo2C0?t=696
 */
package com.zea7ot.leetcode.lvl4.lc0045;

public class SolutionApproach0Greedy {
    public int jump(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;
        int[] maxRange = new int[N];
        for (int i = 0; i < N; ++i) {
            maxRange[i] = i + nums[i];
        }

        int jumps = 0;
        // the previous max jump
        int left = 0;
        // the max it can jump
        int end = 0;

        for (int i = 0; i < N; ++i) {
            if (i > end)
                return -1;
            if (i > left) { // this means, a jump is required
                ++jumps;
                left = end;
            }

            end = Math.max(end, maxRange[i]);
        }

        return jumps;
    }
}