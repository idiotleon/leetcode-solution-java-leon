package com.idiotleon.leetcode.lvl4.lc0456;

import com.idiotleon.util.Constant;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/132-pattern/">LC0456</a>
 * <p>
 * Time Complexity:     O(N), one pass
 * Space Complexity:    O(N)
 * <p>
 * to maintain a strictly decreasing stack:
 * 1. the elements are values, instead of indexes
 * 2. the order of the elements is strictly decreasing,
 * meaning that nce any bigger value is pushed into the stack, all smaller values are poped out,
 * meaning that only smaller values can be pushed into the stack directly, without popping out any element
 * <p>
 * key step 1:
 * elements recently popped out is guaranteed to be smaller than the elements in the stack,
 * so the elements popped out become the candidates for s3,
 * and the elements in the stack become the candidates for s2.
 * key step 2:
 * after key step 1 is satisfied, meaning there are candidates for both s2 and s3,
 * once s1 can be found, it is the time to return true
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0MonoStack {
    public boolean find132pattern(int[] nums) {
        final int N = nums.length;
        int s3 = Integer.MIN_VALUE;
        final Deque<Integer> stack = new ArrayDeque<>();
        for (int i = N - 1; i >= 0; --i) {
            // key step 2
            if (nums[i] < s3) {
                return true;
            } else {
                while (!stack.isEmpty() && nums[i] > stack.peek()) {
                    // key step 1
                    s3 = stack.pop();
                }
            }

            stack.push(nums[i]);
        }

        return false;
    }
}