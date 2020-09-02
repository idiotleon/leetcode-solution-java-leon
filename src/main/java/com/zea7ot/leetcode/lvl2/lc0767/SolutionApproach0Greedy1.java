/**
 * https://leetcode.com/problems/reorganize-string/
 * 
 * Time Complexity:     O(L) + (L * lg(L)) ~ O(L * lg(L))
 * Space Complexity:    O(L) + O(26) ~ O(max(L, 26))
 */
package com.zea7ot.leetcode.lvl2.lc0767;

import java.util.PriorityQueue;

public class SolutionApproach0Greedy1 {
    public String reorganizeString(String S) {
        // sanity check
        if (S == null || S.isEmpty())
            return "";

        final int L = S.length();
        final char[] CHS = S.toCharArray();
        PriorityQueue<Node> maxHeap = new PriorityQueue<Node>((a, b) -> Integer.compare(b.freq, a.freq));

        int[] freq = new int[26];
        for (int i = 0; i < L; ++i)
            if (++freq[CHS[i] - 'a'] > (L + 1) / 2)
                return "";

        for (int i = 0; i < 26; ++i)
            if (freq[i] != 0)
                maxHeap.offer(new Node(i, freq[i]));

        Node prev = new Node(-1, 0);
        StringBuilder builder = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Node cur = maxHeap.poll();

            if (prev.freq > 0)
                maxHeap.offer(prev);

            builder.append((char) (cur.ID + 'a'));

            --cur.freq;

            prev = cur;
        }

        return builder.toString();
    }

    private class Node {
        private final int ID;
        private int freq;

        private Node(final int ID, int freq) {
            this.ID = ID;
            this.freq = freq;
        }
    }
}