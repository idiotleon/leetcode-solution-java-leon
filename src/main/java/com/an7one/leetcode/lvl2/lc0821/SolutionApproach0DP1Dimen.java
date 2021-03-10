/**
 * https://leetcode.com/problems/shortest-distance-to-a-character/
 *
 * Time Complexity:     O(`L`)
 * Space Complexity:    O(`L`) / O(1)
 *
 * 3 passes
 *
 * References:
 *  https://leetcode.com/problems/shortest-distance-to-a-character/discuss/125788/C%2B%2BJavaPython-2-Pass-with-Explanation
 */
package com.an7one.leetcode.lvl2.lc0821;

public class SolutionApproach0DP1Dimen {
    public int[] shortestToChar(String str, final char CH) {
        final int L = str.length();
        final char[] CHS = str.toCharArray();

        int[] dp = new int[L];
        for (int i = 0; i < L; ++i) {
            dp[i] = CHS[i] == CH ? 0 : L;
        }

        for (int i = 1; i < L; ++i) {
            dp[i] = Math.min(dp[i], 1 + dp[i - 1]);
        }

        for (int i = L - 2; i >= 0; --i) {
            dp[i] = Math.min(dp[i], 1 + dp[i + 1]);
        }

        return dp;
    }
}
