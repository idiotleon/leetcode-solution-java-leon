package com.idiotleon.leetcode.lvl3.lc0503;

import com.idiotleon.util.Constant;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/next-greater-element-ii/">LC0503</a>
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * <p>
 * to maintain a "non-increasing" stack
 * 1. the contents are indexes, instead of values
 * 2. the values/elements, accessed by those indexes, are non-increasing
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0MonoStack {
    public int[] nextGreaterElements(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        final int N = nums.length;
        final int[] ans = new int[N];
        Arrays.fill(ans, -1);

        final Deque<Integer> stack = new ArrayDeque<>();

        int idx = 0;
        while (idx < 2 * N) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[idx % N]) {
                ans[stack.pop()] = nums[idx % N];
            }

            stack.push(idx % N);
            idx++;
        }

        return ans;
    }
}