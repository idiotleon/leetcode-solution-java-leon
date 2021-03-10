/**
 * https://leetcode.com/problems/word-break/
 * 
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(N)
 * 
 * `dp[i]` represents whether s[0...i] can be formed by words in the `wordDict`
 * 
 * References:
 *  https://leetcode.com/problems/word-break/discuss/44054/Java-DP-solution
 */
package com.an7one.leetcode.lvl4.lc0139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionApproach0DP1Dimen2 {
    public boolean wordBreak(String str, List<String> wordDict) {
        // sanity check
        if (str == null || str.isEmpty())
            return false;

        final int L = str.length();
        final Set<String> WORD_SET = new HashSet<String>(wordDict);
        // dp[i] represents whether s[0...i] can be formed by dict
        boolean[] dp = new boolean[L];

        for (int hi = 0; hi < L; ++hi)
            for (int lo = 0; lo <= hi; ++lo) {
                String sub = str.substring(lo, hi + 1);

                if (WORD_SET.contains(sub) && (lo == 0 || dp[lo - 1])) {
                    dp[hi] = true;
                    break;
                }
            }

        return dp[L - 1];
    }
}