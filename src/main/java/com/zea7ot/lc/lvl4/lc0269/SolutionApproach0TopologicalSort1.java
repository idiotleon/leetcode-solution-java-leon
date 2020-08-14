/**
 * https://leetcode.com/problems/alien-dictionary/
 * 
 * Time Complexity:     O(V + E) ~ O(26 + N * L) ~ O(N * L)
 * Space Complexity:    O(V + E) ~ O(26 + N * L) ~ O(N * L)
 */
package com.zea7ot.lc.lvl4.lc0269;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionApproach0TopologicalSort1 {
    private static final int TOTAL_ALPHABETS = 26;

    public String alienOrder(String[] words) {
        // sanity check
        if (words == null || words.length == 0)
            return "";

        StringBuilder builder = new StringBuilder();
        List<Set<Integer>> nextSets = new ArrayList<Set<Integer>>();
        for (int i = 0; i < TOTAL_ALPHABETS; ++i)
            nextSets.add(new HashSet<Integer>());

        int[] counts = new int[TOTAL_ALPHABETS];
        Arrays.fill(counts, -1);

        final int N = words.length;

        // to build up the graph
        for (int i = 0; i < N; ++i) {
            // to initialize letters/chars that have appeared only
            for (char ch : words[i].toCharArray()) {
                if (counts[ch - 'a'] == -1)
                    counts[ch - 'a'] = 0;
            }

            if (i == 0)
                continue;
            String prevWord = words[i - 1], curWord = words[i];
            final int LEN_PREV = prevWord.length(), LEN_CUR = curWord.length(), LEN = Math.max(LEN_PREV, LEN_CUR);
            for (int j = 0; j < LEN; ++j) {
                if (j == LEN_PREV)
                    break;
                else if (j == LEN_CUR)
                    return "";
                else {
                    if (prevWord.charAt(j) == curWord.charAt(j))
                        continue;
                    int prevIdx = prevWord.charAt(j) - 'a';
                    int curIdx = curWord.charAt(j) - 'a';

                    if (!nextSets.get(prevIdx).contains(curIdx)) {
                        nextSets.get(prevIdx).add(curIdx);
                        ++counts[curIdx];
                    }

                    // once any difference of the two chars is hit,
                    // there is no need to compare the rest
                    break;
                }
            }
        }

        // to topological sort
        Deque<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 0; i < TOTAL_ALPHABETS; i++) {
            if (counts[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int idx = queue.poll();

            for (int next : nextSets.get(idx)) {
                if (--counts[next] == 0) {
                    queue.add(next);
                }
            }

            builder.append((char) (idx + 'a'));
        }

        for (int i = 0; i < TOTAL_ALPHABETS; ++i) {
            if (counts[i] > 0) {
                return "";
            }
        }

        return builder.toString();
    }
}