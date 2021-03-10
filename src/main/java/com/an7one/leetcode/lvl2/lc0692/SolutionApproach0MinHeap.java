/**
 * https://leetcode.com/problems/top-k-frequent-words/
 * 
 * Time Complexity:     O(N * lg(k))
 * Space Complexity:    O(k)
 */
package com.an7one.leetcode.lvl2.lc0692;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class SolutionApproach0MinHeap {
    public List<String> topKFrequent(String[] words, int k) {
        LinkedList<String> ans = new LinkedList<String>();
        // sanity checkÎÎ
        if (words == null || words.length == 0)
            return ans;

        Map<String, Integer> freq = new HashMap<String, Integer>();
        for (String word : words)
            freq.put(word, freq.getOrDefault(word, 0) + 1);

        // a minHeap is needed, instead of a maxHeap, to keep large elements in the
        // bottom
        PriorityQueue<String> minHeap = new PriorityQueue<String>(
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
            ans.addFirst(minHeap.poll());
        }

        return ans;
    }
}