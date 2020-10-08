/**
 * https://leetcode.com/problems/sum-of-subarray-minimums/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * dp[i + 1]: sum of minimum of subarrays which ends with nums[i]
 * 
 * References:
 *  https://leetcode.com/problems/sum-of-subarray-minimums/discuss/170769/Java-O(n)-monotone-stack-with-DP
 */
package com.zea7ot.leetcode.lvl4.lc0907;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0DP1DimenWithMonoStack {
    private static final int MOD = (int) 1e9 + 7;

    public int sumSubarrayMins(int[] nums) {
        final int N = nums.length;
        int sum = 0;

        int[] dp = new int[N + 1];

        Deque<Integer> stack = new ArrayDeque<>();
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