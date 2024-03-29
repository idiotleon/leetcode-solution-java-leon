package com.idiotleon.leetcode.lvl2.lc0496;

import com.idiotleon.util.Constant;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/next-greater-element-i/">LC0496</a>
 * <p>
 * Space Complexity:    O(N)
 * Time Complexity:     O(N)
 * <p>
 * to maintain a strictly increasing stack
 * 1. the contents are actual elements/values, NOT indexes
 * 2. the elements/values are put in a strictly increasing order
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0MonoStack1 {
    public int[] nextGreaterElement(int[] sub, int[] nums) {
        // sanity check
        if (sub == null || sub.length == 0 || nums == null || nums.length < sub.length) {
            return new int[0];
        }

        final int N_SUB = sub.length;
        final int[] ans = new int[N_SUB];
        final int N_NUM = nums.length;

        final Deque<Integer> valStack = new ArrayDeque<>();
        // value to index
        final Map<Integer, Integer> idxMap = new HashMap<>();

        // from end to start
        for (int i = N_NUM - 1; i >= 0; --i) {
            // if a greater (than the top of the stack) value has been found ***from end to
            // start***
            // all previous smaller values should be popped out,
            // after which the top of the stack keeps the best till now candidate as the
            // "next greater" value.
            while (!valStack.isEmpty() && valStack.peek() <= nums[i]) {
                valStack.pop();
            }

            if (valStack.isEmpty()) {
                idxMap.put(nums[i], -1);
            } else {
                idxMap.put(nums[i], valStack.peek());
            }

            valStack.push(nums[i]);
        }

        for (int i = 0; i < N_SUB; ++i) {
            ans[i] = idxMap.get(sub[i]);
        }

        return ans;
    }
}