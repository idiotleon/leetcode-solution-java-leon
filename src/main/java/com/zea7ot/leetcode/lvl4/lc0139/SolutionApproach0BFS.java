/**
 * https://leetcode.com/problems/word-break/
 * 
 * Time Complexity:     O(L ^ 2) + O(N * L) / O(N) ~ O(L ^ 2)
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

        final Set<String> WORD_SET = new HashSet<>(wordDict);

        Deque<String> queue = new ArrayDeque<>();
        queue.offer(str);
        final Set<String> SEEN = new HashSet<>();

        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int i = 0; i < SIZE; ++i) {
                String cur = queue.poll();
                final int LEN = cur.length();

                for (int j = 1; j <= LEN; ++j) {
                    if (!WORD_SET.contains(cur.substring(0, j)))
                        continue;

                    if (j == LEN)
                        return true;

                    String sub = cur.substring(j);
                    if (!SEEN.add(sub))
                        continue;
                    queue.offer(sub);
                }
            }
        }

        return false;
    }
}