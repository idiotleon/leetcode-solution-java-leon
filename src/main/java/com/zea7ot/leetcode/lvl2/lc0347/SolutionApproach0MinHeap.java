/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 * 
 * Time Complexity:     O(N * lg(k))
 * Space Complexity:    O(N)
 */
package com.zea7ot.leetcode.lvl2.lc0347;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SolutionApproach0MinHeap {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        // sanity check
        if (nums == null || nums.length == 0)
            return ans;

        Map<Integer, Integer> freqs = new HashMap<>();
        for (int num : nums)
            freqs.put(num, freqs.getOrDefault(num, 0) + 1);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(freqs.get(a), freqs.get(b)));

        for (int key : freqs.keySet()) {
            minHeap.offer(key);
            if (minHeap.size() > k)
                minHeap.poll();
        }

        int idx = k - 1;
        while (!minHeap.isEmpty())
            ans[idx--] = minHeap.poll();
        return ans;
    }
}