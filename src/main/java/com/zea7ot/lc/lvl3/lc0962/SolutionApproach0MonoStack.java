/**
 * https://leetcode.com/problems/maximum-width-ramp/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/maximum-width-ramp/discuss/208348/JavaC%2B%2BPython-O(N)-Using-Stack
 */
package com.zea7ot.lc.lvl3.lc0962;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0MonoStack {
    public int maxWidthRamp(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int widest = 0;

        for (int i = 0; i < N; ++i) {
            if (stack.isEmpty() || nums[stack.peek()] > nums[i])
                stack.push(i);
        }

        for (int i = N - 1; i > widest; --i) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i])
                widest = Math.max(widest, i - stack.pop());
        }

        return widest;
    }
}