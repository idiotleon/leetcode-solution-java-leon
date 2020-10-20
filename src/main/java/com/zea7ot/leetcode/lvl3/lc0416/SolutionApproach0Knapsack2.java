/**
 * https://leetcode.com/problems/partition-equal-subset-sum/
 * 
 * Time Complexity:     
 * Space Complexity:    
 * 
 * Since the problem is a 0-1 backpack problem, 
 * we only have two choices which are take or not. 
 * Thus in this problem, 
 * by using the sum value as the index of DP array, 
 * we transfer the problem to "whether should we take the currently visited number into the sum or not".
 * 
 * 
 * Refences:
 *  https://leetcode.com/problems/partition-equal-subset-sum/discuss/90627/Java-Solution-similar-to-backpack-problem-Easy-to-understand
 *  https://leetcode.com/problems/partition-equal-subset-sum/discuss/90627/Java-Solution-similar-to-backpack-problem-Easy-to-understand/95090
 */
package com.zea7ot.leetcode.lvl3.lc0416;

public class SolutionApproach0Knapsack2 {
    public boolean canPartition(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return true;

        // to preprocess
        int volumn = 0;
        for (int num : nums) {
            volumn += num;
        }
        if (volumn % 2 != 0)
            return false;

        volumn /= 2;
        boolean[] dp = new boolean[volumn + 1];
        dp[0] = true;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = volumn; j >= nums[i - 1]; j--) {
                if (dp[volumn])
                    return true;
                dp[j] = dp[j] || dp[j - nums[i - 1]];
            }
        }

        return dp[volumn];
    }
}