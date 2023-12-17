package com.idiotleon.leetcode.lvl3.lc0503;

import com.idiotleon.util.Constant;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/next-greater-element-ii/">LC0503</a>
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0MonoStack1 {
    public int[] nextGreaterElements(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0) return new int[0];

        final int L = nums.length;
        final int[] ans = new int[L];

        final Deque<Integer> idxStack = new ArrayDeque<>();
        int idx = 0;

        while (idx < 2 * L) {
            while (!idxStack.isEmpty() && nums[idxStack.peek()] < nums[idx % L]) {
                ans[idxStack.pop()] = nums[idx % L];
            }

            if (idx < L) {
                idxStack.add(idx);
                ans[idx] = nums[idx];
            }

            idx++;
        }

        while (!idxStack.isEmpty()) {
            ans[idxStack.pop()] = -1;
        }

        return ans;
    }
}