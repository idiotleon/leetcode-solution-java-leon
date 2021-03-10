/**
 * https://leetcode.com/problems/distinct-echo-substrings/
 * 
 * Time Complexity:     O(L ^ 3)
 * Space Complexity:    O(L ^ 2) + O(L) ~ O(L ^ 2)
 * 
 * `dp[i][j]`, the longest suffix length of strings `text[0, i]` and `text[0, j]`.
 *  `dp[i][j] = 1 + dp[i - 1][j - 1] if dp[i] == dp[j] else dp[i][j] = 0`.
 * 
 * if `dp[i][j] >= j - i`, the suffix `text[i + 1, j]` of `text[0, j]` is also a suffix of `text[0, i]`,
 *  which means `text[i - (j - i) + 1, i] == text[i + 1, j]`
 * 
 * References:
 *  https://leetcode.com/problems/distinct-echo-substrings/discuss/478515/Simple-JAVA-DP-solution/680798
 *  https://leetcode.com/problems/distinct-echo-substrings/discuss/478515/Simple-JAVA-DP-solution
 *  https://leetcode.com/problems/distinct-echo-substrings/discuss/478515/Simple-JAVA-DP-solution/627050
 */
package com.an7one.leetcode.lvl4.lc1316;

import java.util.HashSet;
import java.util.Set;

public class SolutionApproach1DP2Dimen {
    public int distinctEchoSubstrings(String text) {
        // sanity check
        if (text == null || text.isEmpty())
            return 0;

        final int L = text.length();
        final char[] CHS = text.toCharArray();
        int[][] dp = new int[L][L];
        Set<String> set = new HashSet<>();

        for (int i = 0; i < L - 1; ++i) {
            for (int j = i + 1; j < L; ++j) {
                if (CHS[i] == CHS[j]) {
                    if (i == 0)
                        dp[i][j] = 1;
                    else
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                }

                if (dp[i][j] >= j - i)
                    set.add(text.substring(i - (j - i) + 1, j + 1));
            }
        }

        return set.size();
    }
}
