/**
 * https://leetcode.com/problems/ones-and-zeroes/
 * 
 * Time Complexity:     O(N * m * n)
 * Space Complexity:    O(N * m * n)
 * 
 * References:
 *  https://leetcode.com/problems/ones-and-zeroes/discuss/95807/0-1-knapsack-detailed-explanation.
 */
package com.idiotleon.leetcode.lvl4.lc0474;

public class SolutionApproach0Knapsack2 {
    public int findMaxForm(String[] strs, int m, int n) {
        final int N = strs.length;
        int[][][] dp = new int[N + 1][m + 1][n + 1];
        
        for(int i = 0; i < N + 1; ++i){
            int[] nums = {0, 0};
            if(i > 0) nums = count(strs[i - 1]);
            
            for(int j = 0; j < m + 1; ++j){
                for(int k = 0; k < n + 1; ++k){
                    if(i == 0) dp[i][j][k] = 0;
                    else if(j >= nums[0] && k >= nums[1]){
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], 
                                               dp[i - 1][j - nums[0]][k - nums[1]] + 1);
                    }else dp[i][j][k] = dp[i - 1][j][k];
                }
            }
        }
        
        return dp[N][m][n];
    }
    
    private int[] count(String str){
        int[] res = new int[2];
        
        for(char ch : str.toCharArray()){
            if(ch == '0') ++res[0];
            else if(ch == '1') ++res[1];
        }
        
        return res;
    }
}