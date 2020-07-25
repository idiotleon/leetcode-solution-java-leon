/**
 * https://leetcode.com/problems/split-array-largest-sum/
 * 
 * Time Complexity:     O(m * (N ^ 2))
 * Space Complexity:    O(m * N)
 * 
 * References:
 *  http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-410-split-array-largest-sum/
 */
package com.zea7ot.lc.lvl4.lc0410;

public class SolutionApproach0DP2Dimen1 {
    public int splitArray(int[] nums, int m) {
        // sanity check
        if(nums == null || nums.length == 0) return 0;

        final int N = nums.length;
        
        int[] prefixSums = new int[N];
        prefixSums[0] = nums[0];
        
        int[][] dp = new int[m + 1][N];
        for(int i = 0; i < m + 1; i++){
            for(int j = 0; j < N; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        
        for(int i = 1; i < N; i++){
            prefixSums[i] = prefixSums[i - 1] + nums[i];
        }
        
        for(int i = 0; i < N; i++){
            dp[1][i] = prefixSums[i];
        }
        
        for(int i = 2; i < m + 1; i++){
            for(int j = i - 1; j < N; ++j){
                for(int k = 0; k < j; k++){
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i - 1][k], prefixSums[j] - prefixSums[k]));
                }
            }
        }
        
        return dp[m][N - 1];
    }
}