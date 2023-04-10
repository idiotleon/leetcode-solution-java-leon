package com.idiotleon.leetcode.lvl3.lc0764;

import com.idiotleon.util.Constant;

import java.util.Arrays;

/**
 * @author: Leon
 * https://leetcode.com/problems/largest-plus-sign/
 *
 * Time Complexity:         O(`N` ^ 2)
 * Space Complexity:        O(`N` ^ 2)
 *
 * References:
 *  https://leetcode.com/problems/largest-plus-sign/discuss/146531/java-simple-DP-solution-using-one-matrix-easy-to-undersatnd/623755
 *  https://leetcode.com/problems/largest-plus-sign/discuss/146531/java-simple-DP-solution-using-one-matrix-easy-to-undersatnd
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DP2Dimen {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        final int[][] dp = new int[N][N];
        for (final int[] row : dp) {
            Arrays.fill(row, N);
        }
        for (final int[] mine : mines) {
            dp[mine[0]][mine[1]] = 0;
        }

        // from the left to the right
        for (int row = 0; row < N; ++row) {
            int streak = 0;
            for (int col = 0; col < N; ++col) {
                if (dp[row][col] > 0)
                    dp[row][col] = Math.min(dp[row][col], ++streak);
                else if (dp[row][col] == 0)
                    streak = 0;
            }
        }

        // from the right to the left
        for (int row = 0; row < N; ++row) {
            int streak = 0;
            for (int col = N - 1; col >= 0; --col) {
                if (dp[row][col] > 0)
                    dp[row][col] = Math.min(dp[row][col], ++streak);
                else if (dp[row][col] == 0)
                    streak = 0;
            }
        }

        // from the top to the bottom
        for (int col = 0; col < N; ++col) {
            int streak = 0;
            for (int row = 0; row < N; ++row) {
                if (dp[row][col] > 0)
                    dp[row][col] = Math.min(dp[row][col], ++streak);
                else if (dp[row][col] == 0)
                    streak = 0;
            }
        }

        // from the bottom to the top
        for (int col = 0; col < N; ++col) {
            int streak = 0;
            for (int row = N - 1; row >= 0; --row) {
                if (dp[row][col] > 0)
                    dp[row][col] = Math.min(dp[row][col], ++streak);
                else if (dp[row][col] == 0)
                    streak = 0;
            }
        }

        int max = 0;
        for (int row = 0; row < N; ++row) {
            for (int col = 0; col < N; ++col) {
                max = Math.max(max, dp[row][col]);
            }
        }
        return max;
    }
}