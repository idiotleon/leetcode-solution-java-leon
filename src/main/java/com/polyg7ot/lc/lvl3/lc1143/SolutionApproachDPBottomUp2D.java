/**
 * https://leetcode.com/problems/longest-common-subsequence/
 * 

 * https://leetcode.com/problems/longest-common-subsequence/discuss/348884/C%2B%2B-with-picture-O(nm)
 */
package com.polyg7ot.lc.lvl3.lc1143;

public class SolutionApproachDPBottomUp2D {
    /**
     * Time Complexity: O(M * N)
     * Space Complexity: O(M * N)
     * 
     * @param text1
     * @param text2
     * @return
     */
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

    /**
     * Tne may notice that we are only looking one row up in the solution above. 
     * So, we just need to store two rows.
     * 
     * Time Complexity: O(M * N)
     * Space Complexity: O(min(M, N))
     * 
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence2(String text1, String text2) {
        
        final int L1 = text1.length(), L2 = text2.length();
        if(L1 < L2) return longestCommonSubsequence(text2, text1);
        
        int[][] dp = new int[2][L2 + 1];
        for(int i = 1; i < L1 + 1; ++i){
            for(int j = 1; j < L2 + 1; ++j){
                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dp[i % 2][j] = dp[(i - 1) % 2][j - 1] + 1;
                }else{
                    dp[i % 2][j] = Math.max(dp[(i - 1) % 2][j], dp[i % 2][j - 1]);
                }
            }
        }
        
        return dp[L1 % 2][L2];
    }
}