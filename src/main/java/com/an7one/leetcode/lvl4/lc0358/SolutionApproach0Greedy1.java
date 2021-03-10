/**
 * https://leetcode.com/problems/rearrange-string-k-distance-apart/
 * 
 * Time Complexity:     O(L * lg(26)) ~ O(L)
 * Space Complexity:    O(L)
 */
package com.an7one.leetcode.lvl4.lc0358;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class SolutionApproach0Greedy1 {
    public String rearrangeString(String s, int k) {
        if (s == null || s.isEmpty())
            return "";
        if (k == 0)
            return s;

        int[] freq = new int[26];
        for (char ch : s.toCharArray())
            ++freq[ch - 'a'];

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        for (int i = 0; i < 26; i++)
            if (freq[i] > 0)
                maxHeap.add(new int[] { i, freq[i] });

        StringBuilder builder = new StringBuilder();
        Deque<int[]> waiting = new ArrayDeque<>();
        while (!maxHeap.isEmpty()) {
            int[] top = maxHeap.poll();
            builder.append((char) (top[0] + 'a'));
            --top[1];
            waiting.add(top);
            if (waiting.size() == k) {
                int[] front = waiting.poll();
                if (front[1] > 0) {
                    maxHeap.add(front);
                }
            }
        }

        return builder.length() == s.length() ? builder.toString() : "";
    }
}