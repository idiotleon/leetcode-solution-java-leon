/**
 * https://leetcode.com/problems/constrained-subsequence-maxSum/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(`k`)
 * 
 * References:
 *  https://leetcode.com/problems/constrained-subsequence-maxSum/discuss/597751/JavaC++Python-O(N)-Decreasing-Deque/675105
 *  https://leetcode.com/problems/constrained-subsequence-maxSum/discuss/597751/JavaC%2B%2BPython-O(N)-Decreasing-Deque
 */
package com.idiotleon.leetcode.lvl4.lc1425;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0MonoDeque {
    public int constrainedSubsetSum(int[] nums, int k) {
        // sanity check
        if (nums == null || nums.length == 0 || k <= 0)
            return 0;

        final int N = nums.length;
        int[] sums = new int[N];
        int maxSum = nums[0];

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < N; ++i) {
            sums[i] = nums[i];
            if (!deque.isEmpty()) {
                sums[i] += sums[deque.peek()];
            }
            maxSum = Math.max(maxSum, sums[i]);

            while (!deque.isEmpty() && deque.peekFirst() < (i - k + 1)) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && sums[deque.peekLast()] <= sums[i]) {
                deque.pollLast();
            }

            if (sums[i] > 0) {
                deque.offer(i);
            }
        }

        return maxSum;
    }
}