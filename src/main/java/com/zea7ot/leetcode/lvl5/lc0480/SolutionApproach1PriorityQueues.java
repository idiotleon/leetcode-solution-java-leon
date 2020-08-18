/**
 * https://leetcode.com/problems/sliding-window-median/
 * 
 * Time Complexity:     O(N * k) + O(N * lg(k)) ~ O(N * k)
 *  addition in priorities queues costs O(lg(k)), while deletion costs O(k)
 * 
 * Space Complexity:    O(N)
 */
package com.zea7ot.leetcode.lvl5.lc0480;

import java.util.PriorityQueue;

public class SolutionApproach1PriorityQueues {
    public double[] medianSlidingWindow(int[] nums, int k) {
        // sanity check
        if (nums == null || nums.length < k || k <= 0)
            return new double[0];

        final int N = nums.length;
        double[] ans = new double[N - k + 1];
        // max heap
        PriorityQueue<Integer> lo = new PriorityQueue<Integer>((a, b) -> Integer.compare(b, a));
        // min heap
        PriorityQueue<Integer> hi = new PriorityQueue<Integer>();

        for (int i = 0; i < N; ++i) {
            if (lo.size() <= hi.size()) {
                hi.add(nums[i]);
                lo.add(hi.poll());
            } else {
                lo.add(nums[i]);
                hi.add(lo.poll());
            }

            if (lo.size() + hi.size() < k)
                continue;
            double median;

            if (lo.size() == hi.size())
                median = ((double) lo.peek() + (double) hi.peek()) / 2.0;
            else
                median = (double) lo.peek();

            int idx = i - k + 1;
            ans[idx] = median;
            if (!lo.remove(nums[idx]))
                hi.remove(nums[idx]);
        }

        return ans;
    }
}