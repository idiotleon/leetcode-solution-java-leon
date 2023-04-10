/**
 * https://leetcode.com/problems/max-chunks-to-make-sorted-ii/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/max-chunks-to-make-sorted-ii/discuss/135830/c%2B%2B-Using-Stack-with-O(n)-space-and-time-complexity.-With-7-lines.-4ms.-Beats-100
 */
package com.idiotleon.leetcode.lvl4.lc0768;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0MonoStack {
    public int maxChunksToSorted(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        // not necessary
        // final int N = nums.length;

        // a non-decreasing stack
        Deque<Integer> stack = new ArrayDeque<>();

        for (int num : nums) {
            int curMax = stack.isEmpty() ? num : Math.max(stack.peek(), num);

            while (!stack.isEmpty() && stack.peek() > num) {
                stack.pop();
            }

            stack.push(curMax);
        }

        return stack.size();
    }
}