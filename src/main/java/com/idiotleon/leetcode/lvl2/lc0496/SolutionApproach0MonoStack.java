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
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * <p>
 * to maintain a strictly decreasing stack
 * 1. the contents of the stack are actual values/elements
 * 2. the elements are strictly decreasing
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0MonoStack {
    public int[] nextGreaterElement(int[] sub, int[] nums) {
        // sanity check
        if (sub == null || sub.length == 0 || nums == null || nums.length < sub.length) {
            return new int[0];
        }

        final int N_SUB = sub.length;

        final Map<Integer, Integer> valToLarger = new HashMap<>();
        final Deque<Integer> valStack = new ArrayDeque<>();

        for (int num : nums) {
            // once a greater value has been found, let's say, num
            while (!valStack.isEmpty() && valStack.peek() < num) {
                // to pop out all smaller elements existing in the stack,
                // and their next greater values all are num
                valToLarger.put(valStack.pop(), num);
            }

            valStack.push(num);
        }

        final int[] ans = new int[N_SUB];
        for (int i = 0; i < N_SUB; ++i) {
            ans[i] = valToLarger.getOrDefault(sub[i], -1);
        }
        return ans;
    }
}