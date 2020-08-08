/**
 * https://leetcode.com/problems/sliding-window-maximum/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  http://zxi.mytechroad.com/blog/heap/leetcode-239-sliding-window-maximum/
 */
package com.zea7ot.lc.lvl4.lc0239;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0MonoQueue {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // sanity check
        if (nums == null || nums.length == 0 || k <= 0)
            return new int[0];

        final int N = nums.length;
        int[] ans = new int[N - k + 1];
        int idx = 0;

        Deque<Integer> idxDeque = new ArrayDeque<Integer>();

        for (int i = 0; i < N; i++) {
            while (!idxDeque.isEmpty() && idxDeque.peekFirst() < i - k + 1)
                idxDeque.removeFirst();

            while (!idxDeque.isEmpty() && nums[idxDeque.peekLast()] < nums[i])
                idxDeque.removeLast();

            idxDeque.addLast(i);

            if (i >= k - 1) 
                ans[idx++] = nums[idxDeque.peekFirst()];
        }

        return ans;
    }
}