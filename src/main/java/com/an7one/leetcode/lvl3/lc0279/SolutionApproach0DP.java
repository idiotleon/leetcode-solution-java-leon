/**
 * https://leetcode.com/problems/perfect-squares/
 * 
 * Time Complexity:     O(n * sqrt(n)) ~ O(n ^ (1.5))
 * Space Complexity:    O(n)
 * 
 * References:
 *  https://leetcode.com/problems/perfect-squares/discuss/71495/An-easy-understanding-DP-solution-in-Java
 */
package com.an7one.leetcode.lvl3.lc0279;

import java.util.Arrays;

public class SolutionApproach0DP {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }
}