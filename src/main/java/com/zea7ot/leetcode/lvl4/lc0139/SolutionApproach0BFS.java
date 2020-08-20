/**
 * https://leetcode.com/problems/word-break/
 * 
 * Time Complexity:     O(L ^ 2) + O(N) ~ O(L ^ 2)
 * Space Complexity:    O(N)
 */
package com.zea7ot.leetcode.lvl4.lc0139;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionApproach0BFS {
    public boolean wordBreak(String str, List<String> wordDict) {
        // sanity check
        if (str == null || str.isEmpty())
            return false;

        final Set<String> WORD_SET = new HashSet<String>(wordDict);
        Set<String> visited = new HashSet<String>();

        Deque<String> queue = new ArrayDeque<String>();
        queue.offer(str);

        while (!queue.isEmpty()) {
            String cur = queue.poll();
            final int LEN = cur.length();
            for (int i = 1; i <= LEN; ++i) {
                if (!WORD_SET.contains(cur.substring(0, i)))
                    continue;
                if (i == LEN)
                    return true;

                String sub = cur.substring(i);
                if (!visited.add(sub))
                    continue;
                queue.offer(sub);
            }
        }

        return false;
    }
}