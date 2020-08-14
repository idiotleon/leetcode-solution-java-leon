/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 * 
 * Time Complexity:     O(N * lg(k))
 * Space Complexity:    O(k)
 */
package com.zea7ot.lc.lvl2.lc0215;

import java.util.PriorityQueue;

public class SolutionApproach1MinHeap {
    public int findKthLargest(int[] nums, int k) {
        // to keep a min Heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a, b) -> Integer.compare(a, b));

        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.poll();
    }
}