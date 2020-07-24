/**
 * https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/
 * 
 * Time Complexity:     O((N ^ 2) * D)
 * Space Complexity:    O(N * D)
 * 
 * References:
 *  https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/discuss/490297/Java-Bottom-Up-DP
 */
package com.zea7ot.lc.lvl4.lc1335;

public class SolutionApproach0DP2Dimen {
    public int minDifficulty(int[] jobDifficulty, int D) {
        final int N = jobDifficulty.length;
        if(N < D) return -1;
        int[][] dp = new int[D][N];
        
        dp[0][0] = jobDifficulty[0];
        for(int j = 1; j < N; ++j){
            dp[0][j] = Math.max(jobDifficulty[j], dp[0][j - 1]);
        }
        
        for(int d = 1; d < D; ++d){
            for(int len = d; len < N; ++len){
                int localMax = jobDifficulty[len];
                dp[d][len] = Integer.MAX_VALUE;
                for(int schedule = len; schedule >= d; --schedule){
                    localMax = Math.max(localMax, jobDifficulty[schedule]);
                    dp[d][len] = Math.min(dp[d][len], dp[d - 1][schedule - 1] + localMax);
                }
            }
        }
        
        return dp[D - 1][N - 1];
    }
}