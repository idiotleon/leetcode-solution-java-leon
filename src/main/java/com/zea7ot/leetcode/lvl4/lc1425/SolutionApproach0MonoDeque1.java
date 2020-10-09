/**
 * https://leetcode.com/problems/constrained-subsequence-sum/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(`k`)
 * 
 * References:
 *  https://leetcode.com/problems/constrained-subsequence-sum/discuss/597751/JavaC%2B%2BPython-O(N)-Decreasing-Deque
 */
package com.zea7ot.leetcode.lvl4.lc1425;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0MonoDeque1 {
    public int constrainedSubsetSum(int[] nums, int k) {
        // sanity check
        if (nums == null || nums.length == 0 || k <= 0)
            return 0;

        final int N = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();

        int maxSum = nums[0];
        for (int i = 0; i < N; ++i) {
            nums[i] += deque.isEmpty() ? 0 : deque.peekFirst();
            maxSum = Math.max(maxSum, nums[i]);

            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.removeLast();
            }

            if (nums[i] > 0)
                deque.add(nums[i]);

            if (i >= k && !deque.isEmpty() && deque.peekFirst() == nums[i - k]) {
                deque.removeFirst();
            }
        }

        return maxSum;
    }
}