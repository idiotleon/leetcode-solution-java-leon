/**
 * https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/
 * 
 * Time Complexity:     O(M * N)
 * Space Complexity:    O(M * N)
 * 
 *  dp[i][j] represents the minimum deletion for str1.substring(0, i), i exclusive, and str2.substring(0, j), j exclusive
 * 
 * References:
 *  https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/discuss/108811/JavaDP(With-Explanation)/300816
 *  https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/discuss/642422/for-those-who-have-no-clue-%3A-step-by-step
 */
package com.zea7ot.lc.lvl3.lc0712;

public class SolutionApproach0DP2D1 {
    public int minimumDeleteSum(String s1, String s2) {
        final int M = s1.length(), N = s2.length();
        
        int[][] dp = new int[M + 1][N + 1];
        for(int i = 1; i <= M; i++){
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
        }
        
        for(int j = 1; j <= N; j++){
            dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);
        }
        
        for(int i = 1; i <= M; i++){
            for(int j = 1; j <= N; j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    dp[i][j] = Math.min(dp[i - 1][j] + s1.charAt(i - 1), dp[i][j - 1] + s2.charAt(j - 1));
                }
            }
        }
        
        return dp[M][N];
    }
}