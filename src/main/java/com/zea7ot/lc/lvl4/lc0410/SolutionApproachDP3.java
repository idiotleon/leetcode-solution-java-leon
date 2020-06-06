/**
 * https://leetcode.com/problems/split-array-largest-sum/
 * 
 * http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-410-split-array-largest-sum/
 * Time Complexity: O(m * n ^ 2)
 * Space Complexity: O(m * n)
 */
package com.zea7ot.lc.lvl4.lc0410;

public class SolutionApproachDP3 {
    public int splitArray(int[] nums, int m) {
        final int N = nums.length;
        
        int[] preSums = new int[N];
        preSums[0] = nums[0];
        
        int[][] dp = new int[m + 1][N];
        for(int i = 0; i < m + 1; i++){
            for(int j = 0; j < N; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        
        for(int i = 1; i < N; i++){
            preSums[i] = preSums[i - 1] + nums[i];
        }
        
        for(int i = 0; i < N; i++){
            dp[1][i] = preSums[i];
        }
        
        for(int i = 2; i < m + 1; i++){
            for(int j = i - 1; j < N; ++j){
                for(int k = 0; k < j; k++){
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i - 1][k], preSums[j] - preSums[k]));
                }
            }
        }
        
        return dp[m][N - 1];
    }
}