/**
 * https://leetcode.com/problems/two-city-scheduling/
 * 
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(N ^ 2)
 * 
 * dp[i][j] represents the cost where, 
 * among the first (i + j) people, 
 * i people are assigned to city A,
 * and j people are assigned to city B.
 *  Please be noted that "i" and "j" are actual numbers, NOT sequence.
 * 
 * References:
 *  https://leetcode.com/problems/two-city-scheduling/discuss/278731/Java-DP-Easy-to-Understand
 */
package com.zea7ot.lc.lvl2.lc1029;

public class SolutionApproach0DP2D {
    public int twoCitySchedCost(int[][] costs) {
        // sanity check
        if(costs == null || costs.length == 0) return 0;
        
        final int N = costs.length / 2;
        int[][] dp = new int[N + 1][N + 1];
        for(int i = 1; i < N + 1; i++){
            dp[i][0] = dp[i - 1][0] + costs[i - 1][0];
        }
        for(int j = 1; j < N + 1; j++){
            dp[0][j] = dp[0][j - 1] + costs[j - 1][1];
        }
        
        for(int i = 1; i < N + 1; i++){
            for(int j = 1; j < N + 1; j++){
                dp[i][j] = Math.min(dp[i - 1][j] + costs[i + j - 1][0], // to assign one more to city A
                    dp[i][j - 1] + costs[i + j - 1][1]);                // to assign one more to city B
            }
        }
        
        return dp[N][N];
    }
}