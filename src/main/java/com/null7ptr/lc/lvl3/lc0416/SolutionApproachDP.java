/**
 * https://leetcode.com/problems/partition-equal-subset-sum/
 * 
 * 
 */
package com.null7ptr.lc.lvl3.lc0416;

public class SolutionApproachDP {
    public boolean canPartition(int[] nums) {
        // sanity check
        if(nums == null || nums.length == 0) return true;
        
        // to preprocess
        int volumn = 0;
        for(int num : nums){
            volumn += num;
        }
        if(volumn % 2 != 0) return false;
        
        volumn /= 2;
        boolean[] dp = new boolean[volumn + 1];
        dp[0] = true;
        for(int i = 1; i <= nums.length; i++){
            for(int j = volumn; j >= nums[i - 1]; j--){
                if(dp[volumn]) return true;
                dp[j] = dp[j] || dp[j - nums[i - 1]];
            }
        }
        
        return dp[volumn];
    }
}