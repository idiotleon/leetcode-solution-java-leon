/**
 * https://leetcode.com/problems/daily-temperatures/
 * 
 * Time Complexity:     O(`N`)
 * Space Complexity:    O(`N`)
 * 
 * to maintain a "non-increasing" stack
 * 1. the elements of the stack are indexes, instead of values
 * 2. the values in the given array, accessed by those indexes, are in non-increasing order
 */
package com.zea7ot.leetcode.lvl3.lc0739;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0MonoStack {
    public int[] dailyTemperatures(int[] T) {
        // sanity check
        if (T == null || T.length == 0)
            return new int[0];
        final int N = T.length;

        int[] ans = new int[N];
        Deque<Integer> stack = new ArrayDeque<>();

        int idx = 0;
        while (idx < N) {
            while (!stack.isEmpty() && T[stack.peek()] < T[idx]) {
                int prevIdx = stack.pop();
                ans[prevIdx] = idx - prevIdx;
            }

            stack.push(idx);
            ++idx;
        }

        // by values, this can be omitted
        while (!stack.isEmpty()) {
            ans[stack.pop()] = 0;
        }

        return ans;
    }
}