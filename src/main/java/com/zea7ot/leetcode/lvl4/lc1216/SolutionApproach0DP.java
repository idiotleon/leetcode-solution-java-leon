/**
 * https://leetcode.com/problems/valid-palindrome-iii/
 * 
 * Time Complexity:     O(L ^ 2)
 * Space Complexity:    O(L ^ 2)
 * 
 * References:
 *  https://leetcode.com/problems/valid-palindrome-iii/discuss/397606/Find-Longest-Palindromic-Subsequence./358118
 * 
 * Similar Problems:
 *  4   0516    https://leetcode.com/problems/longest-palindromic-subsequence/
 */
package com.zea7ot.leetcode.lvl4.lc1216;

public class SolutionApproach0DP {
    public boolean isValidPalindrome(String s, int k) {
        // sanity check
        if(s == null || s.isEmpty() || k <= 0) return false;
        
        final int L = s.length();
        int[][] dp = new int[L][L];
        
        for(int i = L - 1; i >= 0; --i){
            dp[i][i] = 1;
            for(int j = i + 1; j < L; ++j){
                if(s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        
        return L - dp[0][L - 1] <= k;
    }
}