/**
 * https://leetcode.com/problems/partition-equal-subset-volumn/
 * 
 * Time Complexity:     O(N * VOLUMN)
 * Space Complexity:    O(VOLUMN)
 * 
 * the characteristic of Knapsack problems is that
 * its time and space complexity is highly related 
 * to the range, in this case the "volumn", of the actual problem
 * 
 * References:
 *  https://youtu.be/r6I-ikllNDM
 *  http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-416-partition-equal-subset-sum/
 */
package com.zea7ot.leetcode.lvl3.lc0416;

public class SolutionApproach0Knapsack {
    public boolean canPartition(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return false;

        int volumn = 0;
        for (int num : nums) {
            volumn += num;
        }
        if (volumn % 2 != 0)
            return false;

        int[] dp = new int[volumn + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int i = volumn; i >= 0; --i) {
                if (dp[i] > 0) {
                    dp[i + num] = 1;
                }
            }
            if (dp[volumn / 2] > 0)
                return true;
        }

        return false;
    }
}