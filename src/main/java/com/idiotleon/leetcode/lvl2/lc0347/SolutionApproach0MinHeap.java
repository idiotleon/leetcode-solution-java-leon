package com.idiotleon.leetcode.lvl2.lc0347;

import com.idiotleon.util.Constant;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/top-k-frequent-elements/">LC0347</a>
 * <p>
 * Time Complexity:     O(N * lg(`k`))
 * Space Complexity:    O(N)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0MinHeap {
    public int[] topKFrequent(int[] nums, int k) {
        final int[] ans = new int[k];
        // sanity check
        if (nums == null || nums.length == 0) {
            return ans;
        }

        final Map<Integer, Integer> freqs = new HashMap<>();
        for (final int num : nums) {
            freqs.put(num, freqs.getOrDefault(num, 0) + 1);
        }

        final PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(freqs.get(a), freqs.get(b)));

        for (int key : freqs.keySet()) {
            minHeap.offer(key);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int idx = k - 1;
        while (!minHeap.isEmpty()) {
            ans[idx--] = minHeap.poll();
        }
        return ans;
    }
}