/**
 * https://leetcode.com/problems/paint-house-ii/
 * 
 * Time Complexity:     O(NR * (NC ^ 2)) ~ O(N * (K ^ 2))
 * Space Complexity:    O(NR * NC) ~ O(N * K)
 * 
 * References:
 *  https://leetcode.com/problems/paint-house-ii/discuss/69492/AC-Java-solution-without-extra-space/71565
 */
package com.zea7ot.leetcode.lvl4.lc0265;

public class SolutionApproach0DP2 {
    public int minCostII(int[][] costs) {
        // sanity check
        if(costs == null || costs.length == 0 || costs[0].length == 0) return 0;
        
        final int NR = costs.length, NC = costs[0].length;
        int[][] dp = new int[NR][NC];
        for(int col = 0; col < NC; col++) dp[0][col] = costs[0][col];
        
        for(int row = 1; row < NR; ++row){
            for(int col = 0; col < NC; ++col){
                dp[row][col] = Integer.MAX_VALUE;
                for(int k = 0; k < NC; k++){
                    if(col == k) continue;
                    dp[row][col] = Math.min(dp[row][col], dp[row - 1][k] + costs[row][col]);
                }
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for(int col = 0; col < NC; ++col){
            ans = Math.min(ans, dp[NR - 1][col]);
        }
        
        return ans;
    }
}