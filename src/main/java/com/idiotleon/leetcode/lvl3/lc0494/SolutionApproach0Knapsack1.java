/**
 * https://leetcode.com/problems/target-sum/
 * 
 * Time Compelxity:     O(N ^ 2)
 * Space Complexity:    O(N ^ 2)
 * 
 * References:
 *  https://leetcode.com/problems/target-sum/discuss/97335/Short-Java-DP-Solution-with-Explanation/101899
 *  https://leetcode.com/problems/target-sum/discuss/97335/Short-Java-DP-Solution-with-Explanation/239358
 *  https://leetcode.com/problems/target-sum/discuss/97335/Short-Java-DP-Solution-with-Explanation/220467
 */
package com.idiotleon.leetcode.lvl3.lc0494;

public class SolutionApproach0Knapsack1 {
    public int findTargetSumWays(int[] nums, int S) {
        // sanity check
        if(nums == null || nums.length == 0) return 0;
        
        int sum = 0;
        for(int num : nums) sum += num;
        
        // sanity check
        if(S < -sum || S > sum) return 0;
        
        final int RANGE = sum * 2 + 1;

        final int L = nums.length;
        int[][] dp = new int[L + 1][RANGE];
        dp[0][sum] = 1;
        
        for(int i = 1; i <= L; i++){
            for(int j = 0; j < RANGE; j++){
                if(j + nums[i - 1] < 2 * sum + 1){
                    dp[i][j] += dp[i - 1][j + nums[i - 1]];
                }
                
                if(j - nums[i - 1] >= 0){
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        
        return dp[L][sum + S];
    }
}