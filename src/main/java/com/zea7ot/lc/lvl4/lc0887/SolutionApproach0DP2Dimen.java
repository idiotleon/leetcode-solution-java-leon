/**
 * https://leetcode.com/problems/super-egg-drop/
 * 
 * Time Complexity:     O(K * N * lg(N))
 * Space Complexity:    O(K * N)
 * 
 * `dp[k][n]`, minimum number of moves to test `n` floors with `k` eggs
 * 
 * to drop an egg from the `n`-th floor, there are only two outcomes:
 *  1. broken:   `k - 1` egges left, and `n - 1`, 1 ~ `n - 1`, floors left => `dp[k - 1][n - 1]`
 *  2. unbroken: `k` egges left, and 'N - n', `n + 1` ~ `N`, floors left -> `dp[k, N - i]` 
 * 
 * the worse(worst) case is of the interest: max(dp[k - 1][n], dp[k][N - i]).
 * 
 * Among all the choices, to pick the best one
 *  dp[k][n] := 1 + min{max(dp[k - 1][n], dp[k][N - i])}, for 1 <= `n` <= `N`
 *
 *  
 * References:
 *  https://leetcode.com/problems/super-egg-drop/discuss/159055/Java-DP-solution-from-O(KN2)-to-O(KNlogN)/350332
 *  https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-887-super-egg-drop/
 *  https://youtu.be/aPY6sps_Q44
 */
package com.zea7ot.lc.lvl4.lc0887;

public class SolutionApproach0DP2Dimen {
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];
        for (int col = 1; col <= N; ++col)
            dp[1][col] = col;

        for (int k = 2; k <= K; ++k) {
            for (int n = 1; n <= N; ++n) {
                int min = Integer.MAX_VALUE;

                // to search for `k` in `[1, j]` to minimize number of moves
                int lo = 1, hi = n;
                while (lo <= hi) {
                    int mid = lo + (hi - lo) / 2;
                    int broken = dp[k - 1][mid - 1];
                    int unbroken = dp[k][n - mid];
                    // to the take the worse(worst) case, thus the bigger(max),
                    // between `broken` and `unbroken`
                    min = Math.min(min, Math.max(dp[k - 1][mid - 1], dp[k][n - mid]) + 1);
                    if (broken == unbroken)
                        break;
                    else if (broken < unbroken)
                        lo = mid + 1;
                    else
                        hi = mid - 1;
                }

                dp[k][n] = min;
            }
        }

        return dp[K][N];
    }
}