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
public class SolutionApproach0Greedy1 {
    public String reorganizeString(String S) {
        // sanity check
        if (S == null || S.isEmpty())
            return "";

        final int L = S.length();
        final char[] CHS = S.toCharArray();
        final PriorityQueue<Node> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.freq, a.freq));

        final int[] freqs = new int[26];
        for (int i = 0; i < L; ++i) {
            if (++freqs[CHS[i] - 'a'] > (L + 1) / 2)
                return "";
        }

        for (int i = 0; i < 26; ++i) {
            if (freqs[i] != 0)
                maxHeap.offer(new Node(i, freqs[i]));
        }

        Node prev = new Node(-1, 0);
        final StringBuilder builder = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            final Node cur = maxHeap.poll();

            if (prev.freq > 0)
                maxHeap.offer(prev);

            builder.append((char) (cur.ID + 'a'));

            --cur.freq;

            prev = cur;
        }

        return builder.toString();
    }

    private static class Node {
        private final int ID;
        private int freq;

        private Node(final int ID, int freq) {
            this.ID = ID;
            this.freq = freq;
        }
    }
}