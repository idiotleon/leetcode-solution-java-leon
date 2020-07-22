/**
 * https://leetcode.com/problems/longest-common-subsequence/
 * 
 * Time Complexity:     O(L1 * L2)
 * Space Complexity:    O(L1 * L2)
 * 
 * References:
 *  https://leetcode.com/problems/longest-common-subsequence/discuss/348884/C%2B%2B-with-picture-O(nm)
 */
package com.zea7ot.lc.lvl3.lc1143;

public class SolutionApproach0DP2Dimen {
    public int longestCommonSubsequence(String text1, String text2) {
        final int L1 = text1.length(), L2 = text2.length();
        int[][] dp = new int[L1 + 1][L2 + 1];
        for(int i = 1; i < L1 + 1; ++i){
            for(int j = 1; j < L2 + 1; ++j){
                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        return dp[L1][L2];
    }
}