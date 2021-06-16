package com.an7one.leetcode.lvl2.lc0053.followups.followup2;

import com.an7one.util.Constant;

/**
 * https://leetcode.com/problems/maximum-subarray/
 * <p>
 * Time Complexity:     O(N * lgN)
 * Space Complexity:    O(lgN)
 * <p>
 * If you have figured out the O(n) solution,
 * try coding another solution using the divide and conquer approach,
 * which is more subtle.
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0DivideAndConquer {
    public int maxSubArray(int[] nums) {
        return maxSubArray(nums, 0, nums.length - 1);
    }

    private int maxSubArray(int[] nums, int left, int right) {
        if (left > right)
            return Integer.MIN_VALUE;

        int mid = left + (right - left) / 2;
        int leftMax = maxSubArray(nums, left, mid - 1);
        int rightMax = maxSubArray(nums, mid + 1, right);

        int sum1 = 0, sum2 = 0;

        for (int i = mid - 1, cur = 0; i >= left; i--) {
            cur += nums[i];
            sum1 = Math.max(sum1, cur);
        }

        for (int i = mid + 1, cur = 0; i <= right; i++) {
            cur += nums[i];
            sum2 = Math.max(sum2, cur);
        }

        return Math.max(sum1 + sum2 + nums[mid], Math.max(leftMax, rightMax));
    }
}