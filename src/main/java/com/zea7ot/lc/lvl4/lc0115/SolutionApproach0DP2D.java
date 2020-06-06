/**
 * https://leetcode.com/problems/distinct-subsequences/
 * 
 * Time Complexity:     O(M * N)
 * Space Complexity:    O(M * N)
 * 
 * References:
 *  https://leetcode.com/problems/distinct-subsequences/discuss/37413/Concise-JAVA-solution-based-on-DP
 *  https://leetcode.wang/leetcode-115-Distinct-Subsequences.html
 */
package com.zea7ot.lc.lvl4.lc0115;

public class SolutionApproach0DP2D {
    public int numDistinct(String s, String t) {
        final int M = s.length(), N = t.length();
        int[][] dp = new int[M + 1][N + 1];
        for(int i = 0; i < M; i++){
            dp[i][0] = 1;
        }
        
        for(int i = 1; i <= M; i++){
            for(int j = 1; j <= N; j++){
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        return dp[M][N];
    }
}