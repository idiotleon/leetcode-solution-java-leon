package com.idiotleon.leetcode.lvl2.lc0767;

import com.idiotleon.util.Constant;

import java.util.PriorityQueue;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/reorganize-string/">LC0767</a>
 * <p>
 * Time Complexity:     O(L) + (L * lg(L)) ~ O(L * lg(L))
 * Space Complexity:    O(L) + O(26) ~ O(max(L, 26))
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0Greedy2 {
    public String reorganizeString(String S) {
        // sanity check
        if (S == null || S.isEmpty())
            return "";

        final int L = S.length();
        final char[] CHS = S.toCharArray();
        final PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));

        final int[] freqs = new int[26];
        for (int i = 0; i < L; ++i) {
            // to check whether it is possible to reorganize the string,
            // while building up the frequency map
            if (++freqs[CHS[i] - 'a'] > (L + 1) / 2)
                return "";
        }

        for (int i = 0; i < 26; i++) {
            if (freqs[i] != 0)
                maxHeap.offer(new int[]{i, freqs[i]});
        }

        int[] prev = new int[]{-1, 0};
        final StringBuilder builder = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            // to get the most frequent letter
            final int[] cur = maxHeap.poll();

            // to add the previous letter back to PQ,
            // in order not to interfere against the "cur" poll
            if (prev[1] > 0)
                maxHeap.offer(prev);

            // to construct the string
            builder.append((char) (cur[0] + 'a'));

            // to decrease the frequency of "cur" letter by 1
            --cur[1];

            // to set "cur" letter as the "prev" one
            prev = cur;
        }

        return builder.toString();
    }
}