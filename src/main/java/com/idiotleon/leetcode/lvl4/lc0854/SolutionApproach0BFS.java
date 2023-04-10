/**
 * https://leetcode.com/problems/k-similar-strings/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/k-similar-strings/discuss/151500/Logical-Thinking-with-Clear-Java-Code
 */
package com.idiotleon.leetcode.lvl4.lc0854;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionApproach0BFS {
    public int kSimilarity(String A, String B) {
        Deque<String> queue = new ArrayDeque<>();
        queue.offer(A);

        final Set<String> SEEN = new HashSet<>();
        SEEN.add(A);

        int k = 0;
        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int sz = 0; sz < SIZE; ++sz) {
                String cur = queue.poll();
                if (cur.equals(B))
                    return k;

                for (String neighbour : getNeighbours(cur, B)) {
                    if (!SEEN.add(neighbour))
                        continue;
                    queue.offer(neighbour);
                }
            }

            ++k;
        }

        return -1;
    }

    private List<String> getNeighbours(String str, String B) {
        List<String> neighbours = new ArrayList<>();

        final int LEN_S = str.length();
        final char[] CHS_S = str.toCharArray();
        final char[] CHS_B = B.toCharArray();

        int lo = 0;
        while (lo < LEN_S && CHS_S[lo] == CHS_B[lo]) {
            ++lo;
        }

        for (int hi = lo + 1; hi < LEN_S; ++hi) {
            if (CHS_S[hi] == CHS_B[lo]) {
                swap(lo, hi, CHS_S);
                neighbours.add(new String(CHS_S));
                swap(lo, hi, CHS_S);
            }
        }

        return neighbours;
    }

    private void swap(int lo, int hi, final char[] CHS) {
        char temp = CHS[lo];
        CHS[lo] = CHS[hi];
        CHS[hi] = temp;
    }
}
