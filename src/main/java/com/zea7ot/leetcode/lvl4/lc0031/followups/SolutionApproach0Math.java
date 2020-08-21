/**
 * https://leetcode.com/problems/next-permutation/
 * 
 * what is the previous permutation?
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl4.lc0031.followups;

public class SolutionApproach0Math {
    public void previousPermutation(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return;

        final int N = nums.length;
        int i = N - 2;
        while (i >= 0 && nums[i] <= nums[i + 1])
            --i;

        if (i >= 0) {
            int j = N - 1;
            while (j >= 0 && nums[j] > nums[i])
                --j;

            swap(i, j, nums);
        }

        reverseSince(i + 1, nums);
    }

    private void reverseSince(int start, int[] nums) {
        final int N = nums.length;
        int end = N - 1;
        while (start < end)
            swap(start++, end--, nums);
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}