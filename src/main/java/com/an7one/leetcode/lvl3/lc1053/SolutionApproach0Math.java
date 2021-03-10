/**
 * https://leetcode.com/problems/previous-permutation-with-one-swap/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
package com.an7one.leetcode.lvl3.lc1053;

public class SolutionApproach0Math {
    public int[] prevPermOpt1(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return new int[0];

        final int N = nums.length;

        int i = N - 2;
        while (i >= 0 && nums[i] <= nums[i + 1])
            --i;

        if (i < 0)
            return nums;

        int j = N - 1;
        while (j >= 0 && (nums[j] >= nums[i] || nums[j] == nums[j - 1]))
            --j;

        swap(i, j, nums);

        return nums;
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}