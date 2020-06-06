/**
 * https://leetcode.com/problems/delete-operation-for-two-strings/
 * 
 * Time Complexity:     O(M * N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/delete-operation-for-two-strings/discuss/103214/Java-DP-Solution-(Longest-Common-Subsequence)/106397
 */
package com.zea7ot.lc.lvl3.lc0583;

public class SolutionApproach0DP2D {
    public int minDistance(String word1, String word2) {
        final int M = word1.length(), N = word2.length();
        
        int[] dp = new int[N + 1];
        for(int i = 0; i < M; i++){
            int prev = 0;
            for(int j = 0; j < N; j++){
                final int cur = dp[j + 1];
                dp[j + 1] = Math.max(dp[j + 1], dp[j]);
                if(word1.charAt(i) == word2.charAt(j)){
                    dp[j + 1] = Math.max(dp[j + 1], prev + 1);
                }
                
                prev = cur;
            }
        }
        
        int common = dp[N];
        return (M - common) + (N - common);
    }
}