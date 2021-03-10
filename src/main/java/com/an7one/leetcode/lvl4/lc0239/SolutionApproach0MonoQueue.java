/**
 * https://leetcode.com/problems/sliding-window-maximum/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * the `deque` is used to save indexes, instead of actual values
 * 
 * References:
 *  http://zxi.mytechroad.com/blog/heap/leetcode-239-sliding-window-maximum/
 */
package com.an7one.leetcode.lvl4.lc0239;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0MonoQueue {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // sanity check
        if (nums == null || nums.length < k || k <= 0)
            return new int[0];

        final int N = nums.length;
        int[] ans = new int[N - k + 1];
        int idx = 0;

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < N; ++i) {
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.removeFirst();
            }

            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.removeLast();
            }

            deque.addLast(i);

            if (i >= k - 1) {
                ans[idx++] = nums[deque.peekFirst()];
            }
        }

        return ans;
    }
}