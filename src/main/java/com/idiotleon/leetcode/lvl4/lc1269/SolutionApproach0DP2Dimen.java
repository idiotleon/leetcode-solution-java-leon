/**
 * https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/
 * 
 * Time Complexity:     O(steps * min(steps / 2 + 1, arrLen))
 * space Complexity:    O(steps * min(steps / 2 + 1, arrLen))
 * 
 * `dp[steps][position]`:
 *  to stay:        dp[steps - 1][position]
 *  to go right:    dp[steps - 1][position + 1]
 *  to go left:     dp[steps - 1][position - 1]
 * 
 * 
 * References:
 *  https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/discuss/437700/Very-simple-and-easy-to-understand-java-solution
 */
package com.idiotleon.leetcode.lvl4.lc1269;

public class SolutionApproach0DP2Dimen {
    private static final int MOD = (int) 1e9 + 7;

    public int numWays(int steps, int arrLen) {
        int maxPos = Math.min(steps / 2 + 1, arrLen);
        long[][] dp = new long[steps + 1][maxPos + 1];

        dp[1][0] = 1;
        dp[1][1] = 1;

        for (int i = 2; i <= steps; ++i) {
            for (int j = 0; j < maxPos; ++j) {
                dp[i][j] = (dp[i - 1][j] + dp[i - 1][j + 1] + (j > 0 ? dp[i - 1][j - 1] : 0)) % MOD;
            }
        }

        return (int) dp[steps][0];
    }
}