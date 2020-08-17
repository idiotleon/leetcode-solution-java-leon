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
 * 
 * References:
 *  https://leetcode.com/problems/partition-equal-subset-sum/discuss/90627/Java-Solution-similar-to-backpack-problem-Easy-to-understand/95101
 *  https://youtu.be/r6I-ikllNDM
 *  http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-416-partition-equal-subset-sum/
 */
package com.zea7ot.leetcode.lvl3.lc0416;

public class SolutionApproach0Knapsack1 {
    public boolean canPartition(int[] nums) {
        // sanity check
        if(nums == null || nums.length == 0) return true;
        
        int volumn = 0;
        for(int num : nums) volumn += num;
        
        if(volumn % 2 != 0) return false;
        
        volumn /= 2;
        
        boolean[] dp = new boolean[volumn + 1];
        dp[0] = true;
        
        for(int i = 0; i < nums.length; i++){
            for(int j = volumn; j >= nums[i]; --j){
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        
        return dp[volumn];
    }
}