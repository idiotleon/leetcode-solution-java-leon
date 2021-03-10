/**
 * https://leetcode.com/problems/count-unique-characters-of-all-substrings-of-a-given-string/
 * 
 * Time Complexiyt:     O(L) + O(26) ~ O(L)
 * Space Complexity:    O(L) / O(1) + O(26 * 2) ~ O(L) / O(1)
 * 
 * References:
 *  https://leetcode.com/problems/count-unique-characters-of-all-substrings-of-a-given-string/discuss/128952/C%2B%2BJavaPython-One-pass-O(N)
 */
package com.an7one.leetcode.lvl5.lc0828;

import java.util.Arrays;

public class SolutionApproach0DP0Dimen1 {
    private static final int MOD = (int) 1e9 + 7;

    public int uniqueLetterString(String s) {
        // sanity check
        if (s == null || s.isEmpty())
            return 0;

        final int L = s.length();
        final char[] CHS = s.toCharArray();

        int[][] dp = new int[26][2];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        int count = 0;

        for (int i = 0; i < L; ++i) {
            int idx = CHS[i] - 'A';
            count = (count + (i - dp[idx][1]) * (dp[idx][1] - dp[idx][0]) % MOD) % MOD;
            dp[idx] = new int[] { dp[idx][1], i };
        }

        for (int i = 0; i < 26; ++i) {
            count = (count + (L - dp[i][1]) * (dp[i][1] - dp[i][0]) % MOD) % MOD;
        }

        return count;
    }
}
