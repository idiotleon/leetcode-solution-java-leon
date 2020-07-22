/**
 * https://leetcode.com/problems/delete-operation-for-two-strings/
 * 
 * Time Complexity:     O(L1 * L2)
 * Space Complexity:    O(L2)
 * 
 * References:
 *  https://leetcode.com/problems/delete-operation-for-two-strings/discuss/103214/Java-DP-Solution-(Longest-Common-Subsequence)/106397
 */
package com.zea7ot.lc.lvl3.lc0583;

public class SolutionApproach0DP2Dimen {
    public int minDistance(String word1, String word2) {
        final int L1 = word1.length(), L2 = word2.length();
        
        int[] dp = new int[L2 + 1];
        for(int i = 0; i < L1; ++i){
            int prev = 0;
            for(int j = 0; j < L2; ++j){
                final int TEMP = dp[j + 1];
                dp[j + 1] = Math.max(dp[j + 1], dp[j]);
                if(word1.charAt(i) == word2.charAt(j)){
                    dp[j + 1] = Math.max(dp[j + 1], prev + 1);
                }
                
                prev = TEMP;
            }
        }
        
        int common = dp[L2];
        return (L1 - common) + (L2 - common);
    }
}