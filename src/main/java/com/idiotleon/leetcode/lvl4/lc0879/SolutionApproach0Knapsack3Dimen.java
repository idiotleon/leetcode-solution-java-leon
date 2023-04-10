/**
 * https://leetcode.com/problems/profitable-schemes/
 * 
 * Time Complexity:     O(K * P * G)
 * Space Complexity:    O(K * P * G)
 * 
 * `dp[k][i][j]`, number of schemes to achieve `i` profit with `j` people by assigning the first `k` tasks
 * 
 * Initialization: dp[0][0][0] = 1
 * 
 * Transition:
 *  p = profit[k - 1]
 *  g = group[k - 1]
 *  dp[k][i][j] = dp[k - 1][i][j] 
 *                + dp[k - 1][i - p][j - g] if j >= g else 0
 *  (0 <= i <= P, 0 <= j <= G)
 * 
 * Answer:
 *  sums(dp[K][P])
 * 
 * References:
 *  http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-879-profitable-schemes/
 *  https://www.youtube.com/watch?v=MjOIR61txFc
 */
package com.idiotleon.leetcode.lvl4.lc0879;

public class SolutionApproach0Knapsack3Dimen {
    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        final int MOD = (int)1e9 + 7;
        final int K = group.length;
        
        int[][][] dp = new int[K + 1][P + 1][G + 1];
        dp[0][0][0] = 1;
        
        for(int k = 1; k <= K; ++k){
            final int p = profit[k - 1];
            final int g = group[k - 1];
            for(int i = 0; i <= P; ++i)
                for(int j = 0; j <= G; ++j)
                    dp[k][i][j] = (dp[k - 1][i][j] + (j < g ? 0 : dp[k - 1][Math.max(0, i - p)][j - g])) % MOD;
        }
        
        int ans = 0;
        for(int num : dp[K][P]){
            ans += num;
            ans %= MOD;
        }
        
        return ans;
    }
}