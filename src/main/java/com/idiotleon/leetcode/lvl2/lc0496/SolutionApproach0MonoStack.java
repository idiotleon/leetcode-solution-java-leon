/**
 * https://leetcode.com/problems/next-greater-element-i/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * to maintain a strictly descreasing stack
 *  1. the contents of the stack are actual values/elements
 *  2. the elements are strickly descreasing
 */
package com.idiotleon.leetcode.lvl2.lc0496;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0MonoStack {
    public int[] nextGreaterElement(int[] sub, int[] nums) {
        // sanity check
        if (sub == null || sub.length == 0 || nums == null || nums.length < sub.length)
            return new int[0];

        final int N_SUB = sub.length;

        // value to index
        Map<Integer, Integer> idxMap = new HashMap<>();
        Deque<Integer> valStack = new ArrayDeque<>();

        for (int num : nums) {
            // once a greater value has been found, let's say, num
            while (!valStack.isEmpty() && valStack.peek() < num) {
                // to pop out all smaller elements existing in the stack,
                // and their next greater values all are num
                idxMap.put(valStack.pop(), num);
            }

            valStack.push(num);
        }

        int[] ans = new int[N_SUB];
        for (int i = 0; i < N_SUB; ++i) {
            ans[i] = idxMap.getOrDefault(sub[i], -1);
        }
        return ans;
    }
}