/**
 * https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
 * 
 * Time Complexity:     O(d * f * target)
 * Space Complexity:    O(target)
 * 
 * References:
 *  https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/discuss/355940/C%2B%2B-Coin-Change-2
 */
package com.zea7ot.lc.lvl3.lc1155;

public class SolutionApproachDPTabulation {
    public int numRollsToTarget(int d, int f, int target) {
        final int MOD = (int)(1e9 + 7);
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int i = 1; i <= d; i++){
            int[] dp1 = new int[target + 1];
            for(int j = 1; j <= f; j++){
                for(int k = j; k <= target; k++){
                    dp1[k] = (dp1[k] + dp[k - j]) % MOD;
                }
            }
            dp = dp1;
        }
        return dp[target];
    }
}