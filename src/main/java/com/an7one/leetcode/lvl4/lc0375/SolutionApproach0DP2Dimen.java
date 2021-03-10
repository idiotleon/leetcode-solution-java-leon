/**
 * https://leetcode.com/problems/guess-number-higher-or-lower-ii/
 * 
 * Time Complexity:     O(n * n * n)
 * Space Complexity:    O(n * n)
 * 
 * `dp[i][j]`, the minimum price/payment/money to guarantee a win in s[i : j]
 * 
 * 
 * Explaination:
 *  One can choose `k` (i<=k<=j) as our guess, and pay price k. 
 *      After the guess, the problem is divided into two subproblems. 
 *      Please be reminded that one does NOT need to pay the money for both subproblems. 
 *      One only needs to pay for the worst case (because the system will tell which side we should go) to guarantee win. 
 *      So dp[i][j] = min (i<=k<=j) { k + max(dp[i][k-1], dp[k+1][j]) }
 * 
 * 
 * References:
 *  https://leetcode.com/problems/guess-number-higher-or-lower-ii/discuss/84787/Java-DP-solution/89432
 *  https://leetcode.com/problems/guess-number-higher-or-lower-ii/discuss/84787/Java-DP-solution
 *  https://youtu.be/FLbqgyJ-70I?t=7394
 *  https://docs.google.com/presentation/d/1F_Qp3kzw7jZkPpb7ll7J6-02285bCA3Z9nmU1e7a2rk/edit#slide=id.g82af7adac0_0_401
 */
package com.an7one.leetcode.lvl4.lc0375;

public class SolutionApproach0DP2Dimen {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 2][n + 2];
        for (int len = 1; len < n; ++len) {
            for (int from = 1, to = from + len; to <= n; ++from, ++to) {
                dp[from][to] = Integer.MAX_VALUE;
                for (int k = from; k <= to; ++k) {
                    dp[from][to] = Math.min(dp[from][to], k + Math.max(dp[from][k - 1], dp[k + 1][to]));
                }
            }
        }
        return dp[1][n];
    }
}