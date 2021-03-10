/**
 * https://leetcode.com/problems/word-break/
 * 
 * Time Complexity:     O(L ^ 2)
 * Space Complexity:    O(N) + O(L)
 * 
 * References:
 *  https://leetcode.com/problems/word-break/discuss/43790/Java-implementation-using-DP-in-two-ways
 */
package com.an7one.leetcode.lvl4.lc0139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionApproach0DP1Dimen {
    public boolean wordBreak(String s, List<String> wordDict) {
        final Set<String> WORD_SET = new HashSet<>(wordDict);

        final int L = s.length();
        boolean[] dp = new boolean[L + 1];
        dp[0] = true;

        for (int hi = 1; hi <= L; ++hi) {
            for (int lo = 0; lo < hi; ++lo) {
                if (dp[lo] && WORD_SET.contains(s.substring(lo, hi))) {
                    dp[hi] = true;
                    // pruning here
                    break;
                }
            }
        }

        return dp[L];
    }
}
