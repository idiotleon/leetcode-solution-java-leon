/**
 * https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/submissions/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/discuss/356057/Java-O(d-*-f-*-target)-dp-straightforward-and-fast
 */
package com.idiotleon.leetcode.lvl3.lc1155;

public class SolutionApproach0DPMemoization {
    public int numRollsToTarget(int d, int f, int target) {
        final int MOD = (int)(1e9 + 7);
        int[][] dp = new int[d + 1][target + 1];
        dp[0][0] = 1;
        for(int i = 1; i <= d; i++){
            for(int j = 1; j <= target; j++){
                if(j > i * f) continue;
                else for(int k = 1; k <= f && k <= j; k++){
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % MOD;
                }
            }
        }
        return dp[d][target];
    }
}