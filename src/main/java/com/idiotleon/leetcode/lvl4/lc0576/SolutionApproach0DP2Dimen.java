package com.idiotleon.leetcode.lvl4.lc0576;

import com.idiotleon.util.Constant;

/**
 * https://leetcode.com/problems/out-of-boundary-paths/
 * <p>
 * Time Complexity:     O(`m` * `n` * `maxMove`)
 * Space Complexity:    O(`m` * `n`)
 * <p>
 * Reference:
 * https://leetcode.com/problems/out-of-boundary-paths/discuss/102967/Java-Solution-DP-with-space-compression
 * DP[i][j][k] stands for how many possible ways to walk into cell j,k in step i,
 * DP[i][j][k] only depends on DP[i - 1][j][k],
 * so we can compress 3 dimensional dp array to 2 dimensional.
 * <p>
 * Space Compression:
 * https://leetcode.com/problems/out-of-boundary-paths/discuss/102967/Java-Solution-DP-with-space-compression/266686
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DP2Dimen {
    private static final int[] DIRS = {0, 1, 0, -1, 0};
    private static final int MOD = (int) 1e9 + 7;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][] dp = new int[m][n];
        dp[startRow][startColumn] = 1;
        int ans = 0;

        for (int k = 0; k < maxMove; k++) {
            // the k-th move
            int[][] dpNext = new int[m][n];

            for (int row = 0; row < m; ++row) {
                for (int col = 0; col < n; ++col) {
                    if (dp[row][col] == 0) continue;

                    for (int d = 0; d < 4; d++) {
                        int r = row + DIRS[d], c = col + DIRS[d + 1];

                        if (r < 0 || r >= m || c < 0 || c >= n) {
                            ans = (ans + dp[row][col]) % MOD;
                        } else {
                            dpNext[r][c] = (dpNext[r][c] + dp[row][col]) % MOD;
                        }
                    }
                }
            }

            dp = dpNext;
        }

        return ans;
    }
}