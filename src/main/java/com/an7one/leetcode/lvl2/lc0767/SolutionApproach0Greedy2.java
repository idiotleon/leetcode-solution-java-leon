/**
 * https://leetcode.com/problems/reorganize-string/
 * 
 * Time Complexity:     O(L) + (L * lg(L)) ~ O(L * lg(L))
 * Space Complexity:    O(L) + O(26) ~ O(max(L, 26))
 */
package com.an7one.leetcode.lvl2.lc0767;

import java.util.PriorityQueue;

public class SolutionApproach0Greedy2 {
    public String reorganizeString(String S) {
        // sanity check
        if (S == null || S.isEmpty())
            return "";

        final int L = S.length();
        final char[] CHS = S.toCharArray();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((a, b) -> Integer.compare(b[1], a[1]));

        int[] freq = new int[26];
        for (int i = 0; i < L; i++)
            // to check whether it is possible to reorganize the string,
            // while building up the frequency map
            if (++freq[CHS[i] - 'a'] > (L + 1) / 2)
                return "";

        for (int i = 0; i < 26; i++)
            if (freq[i] != 0)
                maxHeap.offer(new int[] { i, freq[i] });

        int[] prev = new int[] { -1, 0 };
        StringBuilder builder = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            // to get the most frequent letter
            int[] cur = maxHeap.poll();

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