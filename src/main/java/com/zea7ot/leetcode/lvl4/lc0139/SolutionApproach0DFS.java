/**
 * https://leetcode.com/problems/word-break/
 * 
 * Time Complexity:     O(L ^ 2)
 * Space Complexity:    O(L)
 * 
 * References:
 *  https://leetcode.com/problems/word-break/discuss/43819/DFS-with-Path-Memorizing-Java-Solution
 */
package com.zea7ot.leetcode.lvl4.lc0139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionApproach0DFS {
    public boolean wordBreak(String s, List<String> wordDict) {
        // sanity check
        if (s == null || s.isEmpty())
            return false;

        Set<Integer> visited = new HashSet<>();
        final Set<String> WORD_SET = new HashSet<>(wordDict);
        return dfs(0, s, visited, WORD_SET);
    }

    private boolean dfs(int idx, String str, Set<Integer> visited, final Set<String> WORD_SET) {
        final int LEN = str.length();

        if (idx == LEN)
            return true;

        if (visited.contains(idx))
            return false;

        for (int i = idx + 1; i <= LEN; ++i) {
            String sub = str.substring(idx, i);

            if (!WORD_SET.contains(sub))
                continue;
            if (dfs(i, str, visited, WORD_SET))
                return true;
        }

        visited.add(idx);
        return false;
    }
}