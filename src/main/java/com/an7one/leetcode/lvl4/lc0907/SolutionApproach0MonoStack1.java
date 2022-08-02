package com.an7one.leetcode.lvl4.lc0907;

import com.an7one.util.Constant;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/sum-of-subarray-minimums/">LC0907</a>
 * <p>
 * Time Complexity: O(N)
 * Space Complexity: O(2 * N) ~ O(N)
 * <p>
 * to maintain 2 strictly increasing stacks, to fill left and right integer array up
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/sum-of-subarray-minimums/discuss/178876/stack-solution-with-very-detailed-explanation-step-by-step">LC Discussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0MonoStack1 {
    private static final int MOD = (int) 1e9 + 7;

    public int sumSubarrayMins(int[] nums) {
        final int L = nums.length;
        int ans = 0;
        // to contain left/previous smaller element at index i
        final int[] left = new int[L];
        // to contain right/next smaller element at index i
        final int[] right = new int[L];

        final Deque<int[]> stack1 = new ArrayDeque<>(), stack2 = new ArrayDeque<>();
        for (int i = 0; i < L; ++i) {
            int count = 1;
            while (!stack1.isEmpty() && stack1.peek()[0] > nums[i]) {
                count += stack1.pop()[1];
            }
            stack1.push(new int[]{nums[i], count});
            left[i] = count;
        }

        for (int i = L - 1; i >= 0; --i) {
            int count = 1;
            while (!stack2.isEmpty() && stack2.peek()[0] >= nums[i]) {
                count += stack2.pop()[1];
            }

            stack2.push(new int[]{nums[i], count});
            right[i] = count;
        }

        for (int i = 0; i < L; ++i) {
            ans = (ans + nums[i] * left[i] * right[i]) % MOD;
        }

        return ans;
    }
}