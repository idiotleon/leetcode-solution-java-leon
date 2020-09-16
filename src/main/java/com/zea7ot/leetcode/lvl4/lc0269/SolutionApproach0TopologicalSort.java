/**
 * @author: Leon
 * https://leetcode.com/problems/alien-dictionary/
 * 
 * Time Complexity:     O(N * L)
 * Space Complexity:    O(N * L)
 */
package com.zea7ot.leetcode.lvl4.lc0269;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionApproach0TopologicalSort {
    private static final int TOTAL_ALPHABETS = 26;

    public String alienOrder(String[] words) {
        // sanity check
        if (words == null || words.length == 0)
            return "";

        final int N = words.length;

        // to prepare for the topological sort
        List<Set<Integer>> graph = new ArrayList<>(TOTAL_ALPHABETS);
        for (int i = 0; i < TOTAL_ALPHABETS; ++i) {
            graph.add(new HashSet<>());
        }

        // indegrees/outdegrees
        final int[] FREQS = new int[TOTAL_ALPHABETS];
        // for alphabetic letters that have not shown up at all
        Arrays.fill(FREQS, -1);
        // for alphabetic letters that have shown up
        for (String word : words) {
            for (char ch : word.toCharArray())
                FREQS[ch - 'a'] = 0;
        }

        // to build up the graph
        for (int i = 1; i < N; ++i) {
            final String WORD_PREV = words[i - 1];
            final String WORD_CUR = words[i];
            final int LEN_PREV = WORD_PREV.length();
            final int LEN_CUR = WORD_CUR.length();
            final int LEN = Math.max(LEN_PREV, LEN_CUR);

            for (int j = 0; j < LEN; ++j) {
                if (j == LEN_PREV)
                    break;
                else if (j == LEN_CUR)
                    return "";
                else {
                    final char CH_PREV = WORD_PREV.charAt(j);
                    final char CH_CUR = WORD_CUR.charAt(j);
                    if (CH_PREV == CH_CUR)
                        continue;
                    final int IDX_PREV = CH_PREV - 'a';
                    final int IDX_CUR = CH_CUR - 'a';

                    if (graph.get(IDX_PREV).add(IDX_CUR)) {
                        ++FREQS[IDX_CUR];
                    }

                    // there is no need to check the following characters,
                    // if there is any difference.
                    break;
                }
            }
        }

        // to topological sort
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < TOTAL_ALPHABETS; ++i) {
            if (FREQS[i] == 0)
                queue.offer(i);
        }

        StringBuilder builder = new StringBuilder();
        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int i = 0; i < SIZE; ++i) {
                int cur = queue.poll();
                final char CH = (char) (cur + 'a');
                builder.append(CH);
                for (int next : graph.get(cur)) {
                    if (--FREQS[next] == 0)
                        queue.offer(next);
                }
            }
        }

        // there is any cycle
        for (int freq : FREQS) {
            if (freq > 0)
                return "";
        }

        return builder.toString();
    }
}