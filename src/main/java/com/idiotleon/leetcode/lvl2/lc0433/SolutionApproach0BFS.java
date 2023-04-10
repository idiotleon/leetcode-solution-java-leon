/**
 * https://leetcode.com/problems/minimum-genetic-mutation/
 * 
 * Time Complexity:     O(L * 4) ~ O(L)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/minimum-genetic-mutation/discuss/91484/Java-Solution-using-BFS
 */
package com.idiotleon.leetcode.lvl2.lc0433;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class SolutionApproach0BFS {
    public int minMutation(String start, String end, String[] bank) {
        // sanity check
        if (start.equals(end))
            return 0;

        final int L = start.length();

        final Set<String> DICT = new HashSet<>();
        for (String word : bank)
            DICT.add(word);

        final char[] GENES = { 'A', 'C', 'G', 'T' };

        Deque<String> queue = new ArrayDeque<>();
        queue.offer(start);

        final Set<String> SEEN = new HashSet<>();
        SEEN.add(start);

        int steps = 0;
        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int i = 0; i < SIZE; ++i) {
                String cur = queue.poll();
                if (cur.equals(end))
                    return steps;
                final char[] CHS = cur.toCharArray();
                for (int j = 0; j < L; ++j) {
                    final char HOLD = CHS[j];

                    for (final char GENE : GENES) {
                        CHS[j] = GENE;
                        String next = String.valueOf(CHS);
                        if (!DICT.contains(next) || !SEEN.add(next))
                            continue;

                        queue.offer(next);
                    }

                    CHS[j] = HOLD;
                }
            }

            ++steps;
        }

        return -1;
    }
}
