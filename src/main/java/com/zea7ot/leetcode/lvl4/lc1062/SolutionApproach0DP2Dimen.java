/**
 * https://leetcode.com/problems/longest-repeating-substring/
 * 
 * Time Complexity:     O(L ^ 2)
 * Space Complexity:    O(L ^ 2)
 * 
 * `dp[i][j]`, number of repeated chars for substrings ending at `i` and `j`
 * 
 * References:
 *  https://leetcode.com/problems/longest-repeating-substring/discuss/303884/easy-to-understand-N2-solution
 */
package com.zea7ot.leetcode.lvl4.lc1062;

public class SolutionApproach0DP2Dimen {
    public int longestRepeatingSubstring(String S) {
        // sanity check
        if (S == null || S.isEmpty())
            return 0;

        final int L = S.length();
        final char[] CHS = S.toCharArray();
        int[][] dp = new int[L + 1][L + 1];

        int longest = 0;
        for (int lo = 1; lo <= L; ++lo) {
            for (int hi = lo + 1; hi <= L; ++hi) {
                if (CHS[lo - 1] == CHS[hi - 1]) {
                    dp[lo][hi] = dp[lo - 1][hi - 1] + 1;
                    longest = Math.max(longest, dp[lo][hi]);
                }
            }
        }

        return longest;
    }
}