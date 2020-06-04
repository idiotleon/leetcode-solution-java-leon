/**
 * https://leetcode.com/problems/longest-palindromic-subsequence/
 * 
 * Time Complexity:     O(L ^ 2)
 * Space Complexity:    O(L ^ 2) + O(L)/O(1)
 * 
 *  dp[i][j] represents the length of lognest palindromic subsequence, 
 *      in the substring(i, j), both ends inclusive.
 *  i represents the left index
 *  j represents the right index
 * 
 * References:
 *  https://leetcode.com/problems/longest-palindromic-subsequence/discuss/99101/Straight-forward-Java-DP-solution
 */
package com.polyg7ot.lc.lvl4.lc0516;

public class SolutionApproach0DP1 {
    public int longestPalindromeSubseq(String s) {
        // sanity check
        if(s == null || s.isEmpty()) return 0;
        
        final int L = s.length();
        
        int[][] dp = new int[L][L];
        
        char[] chs = s.toCharArray();
        for(int i = L - 1; i >= 0; i--){
            dp[i][i] = 1;   // base case
            for(int j = i + 1; j < L; j++){
                if(chs[i] == chs[j]){
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        
        return dp[0][L - 1];
    }
}