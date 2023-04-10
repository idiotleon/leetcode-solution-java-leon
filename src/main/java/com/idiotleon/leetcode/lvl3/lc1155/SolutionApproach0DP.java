/**
 * https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
 * 
 * Time Complexity:     O(d * f * target)
 * Space Complexity:    O(target)
 * 
 * References:
 *  https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/discuss/355940/C%2B%2B-Coin-Change-2
 */
package com.idiotleon.leetcode.lvl3.lc1155;

public class SolutionApproach0DP {
    public int numRollsToTarget(int d, int f, int target) {
        final int MOD = (int)(1e9 + 7);
        int[] dp = new int[target + 1];
        dp[0] = 1;
        int i, j, k;
        for(i = 1; i <= d; i++){
            for(k = target; k >= (i == d ? target : 0); --k){
                for(j = k - 1, dp[k] = 0; j >= Math.max(0, k - f); --j){
                    dp[k] = (dp[k] + dp[j]) % MOD;
                }
            }
        }
        return dp[target];
    }
}