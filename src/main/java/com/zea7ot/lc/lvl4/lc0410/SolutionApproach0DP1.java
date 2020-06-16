/**
 * https://leetcode.com/problems/split-array-largest-sum/
 * 
 * Time Complexity:     O(m * N ^ 2)
 * Space Complexity:    O(m * N)
 * 
 * this approach applies to situations where there is any negative number
 * 
 * 
 * Subproblem: shorter, fewer groups
 * 
 * dp[i][j]: answer of sub-problem, splitting nums[0] ~ nums[j] into i groups
 * dp[1][j]: sum(0, j)
 * dp[i][j]: Math.min{Math.max(dp[i - 1][k], sums(k + 1, j), ...)} 0 <= k < j
 * 
 * 
 * 
 * References:
 *  https://youtu.be/_k-Jb4b7b_0
 */
package com.zea7ot.lc.lvl4.lc0410;

public class SolutionApproach0DP1 {
    private int[][] dp;
    private int[] preSums;
    
    public int splitArray(int[] nums, int m) {
        // sanity check
        if(nums == null || nums.length == 0) return 0;
        
        final int N = nums.length;
        
        dp = new int[N][m + 1];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < m + 1; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        
        preSums = new int[N];
        preSums[0] = nums[0];
        
        for(int i = 1; i < N; i++){
            preSums[i] = preSums[i - 1] + nums[i];
        }
        
        return splitArray(nums, N - 1, m);
    }
    
    private int splitArray(int[] nums, int k, int m){
        if(m == 1) return preSums[k];
        if(m > k + 1) return Integer.MAX_VALUE;
        if(dp[k][m] != Integer.MAX_VALUE) return dp[k][m];
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < k; i++){
            ans = Math.min(ans, Math.max(splitArray(nums, i, m - 1), preSums[k] - preSums[i]));
        }
        
        return dp[k][m] = ans;
    }
}