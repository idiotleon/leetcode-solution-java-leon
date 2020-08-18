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
        List<Set<Integer>> nextSets = new ArrayList<>(TOTAL_ALPHABETS);
        for (int i = 0; i < TOTAL_ALPHABETS; ++i)
            nextSets.add(new HashSet<Integer>());

        // indegrees/outdegrees
        int[] counts = new int[TOTAL_ALPHABETS];
        // for alphabetic letters that have not shown up at all
        Arrays.fill(counts, -1);
        // for alphabetic letters that have shown up
        for (String word : words)
            for (char ch : word.toCharArray())
                counts[ch - 'a'] = 0;

        // to build up the graph
        for (int i = 1; i < N; ++i) {
            String prevWord = words[i - 1], curWord = words[i];
            final int LEN_PREV = prevWord.length(), LEN_CUR = curWord.length();
            final int LEN = Math.max(LEN_PREV, LEN_CUR);

            for (int j = 0; j < LEN; ++j) {
                if (j == LEN_PREV)
                    break;
                else if (j == LEN_CUR)
                    return "";
                else {
                    char prevCh = prevWord.charAt(j), curCh = curWord.charAt(j);
                    if (prevCh == curCh)
                        continue;
                    int prevIdx = prevCh - 'a';
                    int curIdx = curCh - 'a';
                    if (!nextSets.get(prevIdx).contains(curIdx)) {
                        nextSets.get(prevIdx).add(curIdx);
                        ++counts[curIdx];
                    }

                    // there is no need to check the following characters,
                    // if there is any difference.
                    break;
                }
            }
        }

        // to topological sort
        Deque<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 0; i < TOTAL_ALPHABETS; ++i) {
            if (counts[i] == 0)
                queue.add(i);
        }

        StringBuilder builder = new StringBuilder();
        while (!queue.isEmpty()) {
            int idx = queue.poll();
            char ch = (char) (idx + 'a');
            builder.append(ch);
            for (int next : nextSets.get(idx)) {
                if (--counts[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // there is any cycle
        for (int num : counts)
            if (num > 0)
                return "";

        return builder.toString();
    }
}