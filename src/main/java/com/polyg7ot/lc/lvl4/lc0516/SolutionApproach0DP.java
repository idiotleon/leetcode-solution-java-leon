/**
 * https://leetcode.com/problems/longest-palindromic-subsequence/
 * 
 * Time Complexity:     O(L ^ 2)
 * Space Complexity:    O(L)
 * 
 * References:
 *  https://leetcode.com/problems/longest-palindromic-subsequence/discuss/194748/Java-DP-From-O(n2)-to-O(n)-space-with-only-one-array
 */
package com.polyg7ot.lc.lvl4.lc0516;

public class SolutionApproach0DP {
    public int longestPalindromeSubseq(String s) {
        // sanity check
        if(s == null || s.isEmpty()) return 0;
        final int L = s.length();
        
        char[] chs = s.toCharArray();
        int[] dp = new int[L];
        for(int i = L - 1; i >= 0; i--){
            dp[i] = 1;
            int pre = 0;
            for(int j = i + 1; j < L; j++){
                int temp = dp[j];
                if(chs[i] == chs[j]){
                    dp[j] = pre + 2;
                }else{
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                pre = temp;
            }
        }
        
        return dp[L - 1];
    }
}