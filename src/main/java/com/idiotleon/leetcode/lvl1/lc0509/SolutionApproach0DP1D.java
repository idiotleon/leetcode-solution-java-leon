package com.idiotleon.leetcode.lvl1.lc0509;

import com.idiotleon.util.Constant;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/fibonacci-number/">LC0509</a>
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * <p>
 * References:
 * <a href="https://leetcode.com/problems/fibonacci-number/discuss/215992/Java-Solutions">LC Discussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DP1D {
    public int fib(int N) {
        if (N <= 1)
            return N;

        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= N; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[N];
    }
}