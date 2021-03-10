/**
 * https://leetcode.com/problems/next-greater-element-ii/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * to maintain a "non-increasing" stack
 *  1. the contents are indexes, instead of values
 *  2. the values/elements, accessed by those indexes, are non-increasing
 */
package com.an7one.leetcode.lvl3.lc0503;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SolutionApproach0MonoStack {
    public int[] nextGreaterElements(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return new int[0];

        final int N = nums.length;
        int[] ans = new int[N];
        Arrays.fill(ans, -1);

        Deque<Integer> stack = new ArrayDeque<>();

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