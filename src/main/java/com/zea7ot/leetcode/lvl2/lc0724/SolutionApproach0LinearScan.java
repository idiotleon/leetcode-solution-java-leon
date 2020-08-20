/**
 * https://leetcode.com/problems/find-pivot-index/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl2.lc0724;

public class SolutionApproach0LinearScan {
    public int pivotIndex(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return -1;
        final int N = nums.length;
        if (N == 1)
            return 0;

        int leftSum = 0, rightSum = 0;
        for (int num : nums)
            rightSum += num;

        for (int i = 0; i < N; ++i) {
            if (i != 0)
                leftSum += nums[i - 1];
            rightSum -= nums[i];

            if (leftSum == rightSum)
                return i;
        }

        return -1;
    }
}