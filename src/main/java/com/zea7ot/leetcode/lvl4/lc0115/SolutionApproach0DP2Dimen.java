/**
 * https://leetcode.com/problems/distinct-subsequences/
 * 
 * Time Complexity:     O(LEN_S * LEN_T)
 * Space Complexity:    O(LEN_S * LEN_T)
 * 
 * References:
 *  https://leetcode.com/problems/distinct-subsequences/discuss/37413/Concise-JAVA-solution-based-on-DP
 *  https://leetcode.wang/leetcode-115-Distinct-Subsequences.html
 */
package com.zea7ot.leetcode.lvl4.lc0115;

public class SolutionApproach0DP2Dimen {
    public int numDistinct(String s, String t) {
        final int LEN_S = s.length(), LEN_T = t.length();
        int[][] dp = new int[LEN_S + 1][LEN_T + 1];
        for(int i = 0; i < LEN_S; i++) dp[i][0] = 1;
        
        for(int i = 1; i <= LEN_S; ++i){
            for(int j = 1; j <= LEN_T; ++j){
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        return dp[LEN_S][LEN_T];
    }
}