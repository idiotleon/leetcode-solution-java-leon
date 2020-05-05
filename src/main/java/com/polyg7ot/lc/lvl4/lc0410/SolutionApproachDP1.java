/**
 * https://leetcode.com/problems/split-array-largest-sum/ 
 */
package com.polyg7ot.lc.lvl4.lc0410;

public class SolutionApproachDP1 {
    public int splitArray(int[] nums, int m) {
        final int N = nums.length;
        
        int[][] dp = new int[N + 1][m + 1];
        // the element at current index is exclusive
        int[] preSum = new int[N + 1];
        
        for(int i = 0; i <= N; i++){
            for(int j = 0; j <= m; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        
        for(int i = 0; i < N; i++){
            preSum[i + 1] = preSum[i] + nums[i];
        }
        
        dp[0][0] = 0;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= m; j++){
                for(int k = 0; k < i; k++){
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], preSum[i] - preSum[k]));
                }
            }
        }
        
      return dp[N][m];
    }
}