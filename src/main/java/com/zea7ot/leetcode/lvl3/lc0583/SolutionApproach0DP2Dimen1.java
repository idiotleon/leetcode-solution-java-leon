/**
 * https://leetcode.com/problems/delete-operation-for-two-strings/
 * 
 * Time Complexity:     O(L1 * L2)
 * Space Complexity:    O(L1 * L2)
 * 
 * References:
 *  https://leetcode.com/problems/delete-operation-for-two-strings/discuss/103214/Java-DP-Solution-(Longest-Common-Subsequence)/106401
 */
package com.zea7ot.leetcode.lvl3.lc0583;

public class SolutionApproach0DP2Dimen1 {
    public int minDistance(String word1, String word2) {
        final int L1 = word1.length(), L2 = word2.length();
        
        int[][] dp = new int[L1 + 1][L2 + 1];
        for(int i = 1; i <= L1; ++i){
            for(int j = 1; j <= L2; ++j){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        int common = dp[L1][L2];
        return (L1 - common) + (L2 - common);
    }
}