package com.an7one.leetcode.lvl4.lc0907;

import com.an7one.util.Constant;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/sum-of-subarray-minimums/">LC0907</a>
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * <p>
 * dp[i + 1]: sum of minimum of subarrays which ends with nums[i]
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/sum-of-subarray-minimums/discuss/170769/Java-O(n)-monotone-stack-with-DP">LC Discussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DP1DimenWithMonoStack {
    private static final int MOD = (int) 1e9 + 7;

    public int sumSubarrayMins(int[] nums) {
        final int N = nums.length;
        int sum = 0;

        final int[] dp = new int[N + 1];

        final Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);

        for (int i = 0; i < N; ++i) {
            while (stack.peek() != -1 && nums[i] <= nums[stack.peek()]) {
                stack.pop();
            }

            dp[i + 1] = (dp[stack.peek() + 1] + (i - stack.peek()) * nums[i]) % MOD;
            stack.push(i);
            
            sum += dp[i + 1];
            sum %= MOD;
        }

        return sum;
    }
}