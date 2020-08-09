/**
 * https://leetcode.com/problems/super-egg-drop/
 * 
 * Time Complexity:     O(K * N * lg(N))
 * Space Complexity:    O(K * N)
 * 
 * 
 * `broken[i]   = dp(k - 1, i - 1) is increasing with `i`
 * `unbroken[i]`= dp(k,     n - i) is decreasing with `i`
 * 
 * dp[k][n] = 1 + min(max(broken[i], unbroken[i])), 1 <= i <= N
 * to find the smallest `i` such that `broken[i] >= unbroken[i]`,
 *  which minimizes max(broken[i], unbroken[i])
 * 
 * 
 * References:
 *  https://leetcode.com/problems/super-egg-drop/discuss/159055/Java-DP-solution-from-O(KN2)-to-O(KNlogN)
 *  https://www.youtube.com/watch?v=aPY6sps_Q44
 */
package com.zea7ot.lc.lvl4.lc0887;

public class SolutionApproach0DFSMemo {
    public int superEggDrop(int K, int N) {
        int[][] memo = new int[K + 1][N + 1];
        return dfs(K, N, memo);
    }

    private int dfs(int k, int n, int[][] memo) {
        if (n <= 1)
            return n;
        if (k == 1)
            return n;
        if (memo[k][n] > 0)
            return memo[k][n];

        int lo = 1, hi = n, min = n;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int broken = dfs(k - 1, mid - 1, memo);
            int unbroken = dfs(k, n - mid, memo);
            // to the take the worse(worst) case, thus the bigger(max),
            // between `broken` and `unbroken`
            min = Math.min(min, Math.max(broken, unbroken) + 1);

            if (broken == unbroken)
                break;
            else if (broken < unbroken)
                lo = mid + 1;
            else
                hi = mid;
        }

        return memo[k][n] = min;
    }
}