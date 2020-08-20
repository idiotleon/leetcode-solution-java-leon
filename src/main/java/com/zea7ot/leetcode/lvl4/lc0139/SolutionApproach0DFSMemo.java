/**
 * https://leetcode.com/problems/word-break/
 * 
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/word-break/discuss/43819/DFS-with-Path-Memorizing-Java-Solution
 */
package com.zea7ot.leetcode.lvl4.lc0139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionApproach0DFSMemo {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<Integer> visited = new HashSet<Integer>();
        return dfs(visited, 0, s, new HashSet<String>(wordDict));
    }

    private boolean dfs(Set<Integer> visited, int idx, String str, Set<String> wordSet) {
        final int L = str.length();
        if (idx == L)
            return true;

        if (visited.contains(idx))
            return false;

        for (int i = idx + 1; i <= L; ++i) {
            String sub = str.substring(idx, i);
            if (wordSet.contains(sub) && dfs(visited, i, str, wordSet))
                return true;
        }

        visited.add(idx);
        return false;
    }
}