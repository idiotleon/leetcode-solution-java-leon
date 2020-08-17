/**
 * https://leetcode.com/problems/combination-sum-iv/
 * 
 * Time Complexity:     O(N * target)
 * Space Complexity:    O(target)
 * 
 * References:
 *  https://leetcode.com/problems/combination-sum-iv/discuss/111860/Coin-change-AND-this-problem
 * 
 * Almost the same Problems:
 *  https://leetcode.com/problems/coin-change-2/
 */
package com.zea7ot.leetcode.lvl3.lc0377;

public class SolutionApproach0Knapsack {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int i = 1; i <= target; i++){
            for(int num : nums){
                if(i >= num){
                    dp[i] += dp[i - num];
                }
            }
        }
        
        return dp[target];
    }
}