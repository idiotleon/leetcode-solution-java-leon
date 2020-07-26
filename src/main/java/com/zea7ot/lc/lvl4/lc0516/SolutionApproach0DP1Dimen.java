/**
 * https://leetcode.com/problems/longest-palindromic-subsequence/
 * 
 * Time Complexity:     O(L ^ 2)
 * Space Complexity:    O(L)
 * 
 * References:
 *  https://leetcode.com/problems/longest-palindromic-subsequence/discuss/194748/Java-DP-From-O(n2)-to-O(n)-space-with-only-one-array
 *  https://www.youtube.com/watch?v=_nCsPn7_OgI
 *  https://youtu.be/FLbqgyJ-70I?t=6680
 */
package com.zea7ot.lc.lvl4.lc0516;

public class SolutionApproach0DP1Dimen {
    public int longestPalindromeSubseq(String s) {
        // sanity check
        if(s == null || s.isEmpty()) return 0;
        final int L = s.length();
        
        char[] chs = s.toCharArray();
        int[] dp = new int[L];
        for(int i = L - 1; i >= 0; i--){
            dp[i] = 1;
            int prev = 0;
            for(int j = i + 1; j < L; j++){
                int temp = dp[j];
                if(chs[i] == chs[j]){
                    dp[j] = prev + 2;
                }else{
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                prev = temp;
            }
        }
        
        return dp[L - 1];
    }
}