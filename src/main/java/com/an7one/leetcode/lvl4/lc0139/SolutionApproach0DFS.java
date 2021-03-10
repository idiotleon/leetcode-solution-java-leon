/**
 * https://leetcode.com/problems/word-break/
 * 
 * Time Complexity:     O(L ^ 2)
 * Space Complexity:    O(L)
 * 
 * References:
 *  https://leetcode.com/problems/word-break/discuss/43819/DFS-with-Path-Memorizing-Java-Solution
 */
package com.an7one.leetcode.lvl4.lc0139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionApproach0DFS {
    public boolean wordBreak(String s, List<String> wordDict) {
        // sanity check
        if (s == null || s.isEmpty())
            return false;

        final Set<Integer> SEEN = new HashSet<>();
        final Set<String> WORD_SET = new HashSet<>(wordDict);
        return dfs(0, s, SEEN, WORD_SET);
    }

    private boolean dfs(int idx, String str, final Set<Integer> SEEN, final Set<String> WORD_SET) {
        final int LEN = str.length();

        if (idx == LEN)
            return true;

        if (SEEN.contains(idx))
            return false;

        for (int i = idx + 1; i <= LEN; ++i) {
            String sub = str.substring(idx, i);

            if (!WORD_SET.contains(sub))
                continue;
                
            if (dfs(i, str, SEEN, WORD_SET))
                return true;
        }

        SEEN.add(idx);
        return false;
    }
}