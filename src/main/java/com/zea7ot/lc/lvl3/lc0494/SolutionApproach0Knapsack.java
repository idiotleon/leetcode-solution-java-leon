/**
 * https://leetcode.com/problems/target-sum/
 * 
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/target-sum/discuss/97335/Short-Java-DP-Solution-with-Explanation
 *  https://leetcode.com/problems/target-sum/discuss/97335/Short-Java-DP-Solution-with-Explanation/239358
 */
package com.zea7ot.lc.lvl3.lc0494;

public class SolutionApproach0Knapsack {
    public int findTargetSumWays(int[] nums, int S) {
        // sanity check
        if(nums == null || nums.length == 0) return 0;
        
        final int L = nums.length;
        
        int sum = 0;
        for(int num : nums) sum += num;
        if(S > sum || S < -sum) return 0;
        
        int[] dp = new int[2 * sum + 1];
        dp[0 + sum] = 1;
        for(int i = 0; i < L; i++){
            int[] next = new int[2 * sum + 1];
            for(int k = 0; k < 2 * sum + 1; k++){
                if(dp[k] != 0){
                    next[k + nums[i]] += dp[k];
                    next[k - nums[i]] += dp[k];
                }
            }
            dp = next;
        }
        
        return dp[sum + S];
    }
}