/**
 * https://leetcode.com/problems/partition-equal-subset-volume/
 * 
 * Time Complexity:     O(`N` * `volume`)
 * Space Complexity:    O(`volume`)
 * 
 * the characteristic of Knapsack problems is that
 * its time and space complexity is highly related 
 * to the range, in this case the "volume", of the actual problem
 * 
 * References:
 *  https://youtu.be/r6I-ikllNDM
 *  http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-416-partition-equal-subset-sum/
 */
package com.an7one.leetcode.lvl3.lc0416;

public class SolutionApproach0Knapsack {
    public boolean canPartition(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return false;

        // not used
        // final int N = nums.length;

        int volume = 0;
        for (int num : nums) {
            volume += num;
        }
        if (volume % 2 != 0)
            return false;

        boolean[] dp = new boolean[volume + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int sum = volume; sum >= 0; --sum) {
                if (dp[sum]) {
                    dp[sum + num] = true;
                }
            }

            if (dp[volume / 2])
                return true;
        }

        return false;
    }
}