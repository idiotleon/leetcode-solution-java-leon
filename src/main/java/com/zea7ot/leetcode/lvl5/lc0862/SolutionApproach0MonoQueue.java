/**
 * https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/discuss/143726/C%2B%2BJavaPython-O(N)-Using-Deque
 */
package com.zea7ot.leetcode.lvl5.lc0862;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0MonoQueue {
    public int shortestSubarray(int[] nums, int K) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;
        int[] prefixSums = new int[N + 1];
        for (int i = 0; i < N; ++i) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }

        Deque<Integer> deque = new ArrayDeque<Integer>();
        int shortest = Integer.MAX_VALUE;

        for (int i = 0; i < N + 1; ++i) {
            while (!deque.isEmpty() && prefixSums[i] - prefixSums[deque.peekFirst()] >= K)
                shortest = Math.min(shortest, i - deque.pollFirst());

            // to discard all prefix sums that are larger than or equal to the current
            // prefix sum
            while (!deque.isEmpty() && prefixSums[i] <= prefixSums[deque.peekLast()])
                deque.pollLast();

            deque.offerLast(i);
        }

        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }
}