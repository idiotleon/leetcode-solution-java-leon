/**
 * https://leetcode.com/problems/profitable-schemes/
 * 
 * Time Complexity:     O(K * P * G)
 * Space Complexity:    O(P * G)
 * 
 * if dp[i][*] is only dependent on dp[i][*]
 * Dimension/Space reduction with a rolling array
 *  1. to iterate `j` in the reverse order
 *  2. to update `dp[j']` using `dp[j]` where `j'` > `j`
 * 
 * References:
 *  http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-879-profitable-schemes/
 */
package com.zea7ot.lc.lvl4.lc0879;

public class SolutionApproach0Knapsack2Dimen {
    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        final int MOD = (int)1e9 + 7;
        final int K = group.length;
        int[][] dp = new int[P + 1][G + 1];
        dp[0][0] = 1;
        
        for(int k = 0; k < K; ++k){
            int p = profit[k];
            int g = group[k];
            for(int i = P; i >= 0; --i){
                int ip = Math.min(P, i + p);
                for(int j = G - g; j >= 0; --j){
                    dp[ip][j + g] = (dp[ip][j + g] + dp[i][j]) % MOD;
                }
            }
        }
        
        int ans = 0;
        for(int num : dp[P]){
            ans += num;
            ans %= MOD;
        }
        return ans;
    }
}