package com.an7one.leetcode.lvl2.lc0692;

import com.an7one.util.Constant;

import java.util.*;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/top-k-frequent-words/">LC0695</a>
 * <p>
 * Time Complexity:     O(N * lg(`k`))
 * Space Complexity:    O(`k`)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0MinHeap {
    public List<String> topKFrequent(String[] words, int k) {
        final List<String> ans = new ArrayList<>(k);
        // sanity checkÎÎ
        if (words == null || words.length == 0)
            return ans;

        final Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        // a minHeap is needed, instead of a maxHeap, to keep large elements in the
        // bottom
        final PriorityQueue<String> minHeap = new PriorityQueue<>(
                (str1, str2) -> freq.get(str1) == freq.get(str2) ? str2.compareTo(str1)
                        : Integer.compare(freq.get(str1), freq.get(str2)));

        for (String str : freq.keySet()) {
            minHeap.add(str);
            if (minHeap.size() > k)
                minHeap.poll();
        }

        while (!minHeap.isEmpty()) {
            // do not forget to reverse the list,
            // otherwise the Top k elements are sorted from low frequency to high frequency
            ans.add(minHeap.poll());
        }
        Collections.reverse(ans);

        return ans;
    }
}