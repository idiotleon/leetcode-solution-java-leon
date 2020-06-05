/**
 * https://leetcode.com/problems/delete-operation-for-two-strings/
 * 
 * Time Complexity:     O(M * N)
 * Space Complexity:    O(M * N)
 * 
 * References:
 *  https://leetcode.com/problems/delete-operation-for-two-strings/discuss/103214/Java-DP-Solution-(Longest-Common-Subsequence)/106401
 */
package com.polyg7ot.lc.lvl3.lc0583;

public class SolutionApproach0DP2D1 {
    public int minDistance(String word1, String word2) {
        final int M = word1.length(), N = word2.length();
        
        int[][] dp = new int[M + 1][N + 1];
        for(int i = 1; i <= M; i++){
            for(int j = 1; j <= N; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        int common = dp[M][N];
        return (M - common) + (N - common);
    }
}