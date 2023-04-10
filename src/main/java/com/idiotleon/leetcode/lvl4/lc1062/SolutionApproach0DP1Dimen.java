/**
 * https://leetcode.com/problems/longest-repeating-substring/
 * 
 * Time Complexity:     O(L ^ 2)
 * Space Complexity:    O(L)
 * 
 * References:
 *  https://leetcode.com/problems/longest-repeating-substring/discuss/318629/DP-solution-O(n2)-time-O(n)-space
 */
package com.idiotleon.leetcode.lvl4.lc1062;

public class SolutionApproach0DP1Dimen {
    public int longestRepeatingSubstring(String str) {
        final int L = str.length();
        final char[] CHS = str.toCharArray();

        int longest = 0;
        int[] dp = new int[L + 1];
        for (int hi = 1; hi <= L; ++hi) {
            for (int lo = hi - 1; lo > 0; --lo) {
                if (CHS[hi - 1] == CHS[lo - 1]) {
                    dp[lo] = dp[lo - 1] + 1;
                } else {
                    dp[lo] = 0;
                }

                longest = Math.max(longest, dp[lo]);
            }
        }

        return longest;
    }
}
