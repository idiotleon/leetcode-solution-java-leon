/**
 * https://leetcode.com/problems/minimum-window-subsequence/
 * 
 * Time Complexity:     O(LEN_T * LEN_S)
 * Space Complexity:    O(LEN_T * LEN_S)
 * 
 * 
 * 
 * References:
 *  https://leetcode.com/problems/minimum-window-subsequence/discuss/109362/Java-Super-Easy-DP-Solution-(O(mn))
 */
package com.zea7ot.leetcode.lvl4.lc0727;

public class SolutionApproach0DP2Dimen1 {
    public String minWindow(String S, String T) {
        final int LEN_T = T.length(), LEN_S = S.length();
        int[][] dp = new int[LEN_T + 1][LEN_S + 1];
        for(int j = 0; j <= LEN_S; ++j) dp[0][j] = j + 1;
        
        for(int i = 1; i <= LEN_T; ++i){
            for(int j = 1; j <= LEN_S; ++j){
                if(T.charAt(i - 1) == S.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        
        int start = 0, len = LEN_S + 1;
        for(int j = 1; j <= LEN_S; ++j){
            if(dp[LEN_T][j] == 0) continue;
            if(j - dp[LEN_T][j] + 1 < len){
                start = dp[LEN_T][j] - 1;
                len = j - dp[LEN_T][j] + 1;
            }
        }
        
        return len == LEN_S + 1 ? "" : S.substring(start, start + len);
    }
}