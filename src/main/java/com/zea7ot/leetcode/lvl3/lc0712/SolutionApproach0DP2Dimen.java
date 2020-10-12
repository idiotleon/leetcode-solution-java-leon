/**
 * https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/
 * 
 * Time Complexity:     O(L1 * L2)
 * Space Complexity:    O(L1 * L2)
 * 
 *  `dp[i][j]`, the minimum deletion for `str1.substring(0, i)`, i-th char exclusive, 
 *  and `str2.substring(0, j)`, j-th char exclusive
 * 
 * References:
 *  https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/discuss/108811/JavaDP(With-Explanation)/300816
 *  https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/discuss/642422/for-those-who-have-no-clue-%3A-step-by-step
 */
package com.zea7ot.leetcode.lvl3.lc0712;

public class SolutionApproach0DP2Dimen {
    public int minimumDeleteSum(String s1, String s2) {
        final int L1 = s1.length(), L2 = s2.length();

        int[][] dp = new int[L1 + 1][L2 + 1];
        for (int i = 1; i <= L1; ++i) {
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
        }
        for (int j = 1; j <= L2; ++j) {
            dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);
        }

        for (int i = 1; i <= L1; ++i) {
            for (int j = 1; j <= L2; ++j) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + s1.charAt(i - 1), dp[i][j - 1] + s2.charAt(j - 1));
                }
            }
        }

        return dp[L1][L2];
    }
}