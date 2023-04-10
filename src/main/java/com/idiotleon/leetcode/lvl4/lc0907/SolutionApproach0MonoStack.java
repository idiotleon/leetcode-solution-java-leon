package com.idiotleon.leetcode.lvl4.lc0907;

import com.idiotleon.util.Constant;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/sum-of-subarray-minimums/">LC0907</a>
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/sum-of-subarray-minimums/discuss/170750/C%2B%2BJavaPython-Stack-Solution">LC Discussion</a>
 * <a href="https://leetcode.com/problems/sum-of-subarray-minimums/discuss/170750/C++JavaPython-Stack-Solution/337512">LC Discussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0MonoStack {
    private static final int MOD = (int) 1e9 + 7;

    public int sumSubarrayMins(int[] nums) {
        final int N = nums.length;
        int ans = 0, j = 0, k = 0;

        final Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i <= N; ++i) {
            while (!stack.isEmpty() && nums[stack.peek()] > (i == N ? 0 : nums[i])) {
                // only to pop out elements when nums[stack.peek()] > nums[i],
                // nums[k] <= nums[j], nums[j] > nums[i]
                j = stack.pop();
                // nums[k] is the previous less or equal number
                // nums[i] is the next less number
                k = stack.isEmpty() ? -1 : stack.peek();
                ans = (ans + nums[j] * (i - j) * (j - k)) % MOD;
            }

            stack.push(i);
        }

        return ans;
    }
}