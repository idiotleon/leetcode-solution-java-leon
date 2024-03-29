package com.idiotleon.leetcode.lvl4.lc0031;

import com.idiotleon.util.Constant;

/**
 * @author: Leon
 * https://leetcode.com/problems/next-permutation/
 *
 * Time Complexity:     O(`N`)
 * Space Complexity:    O(1)
 *
 * steps:
 *  1. Find the largest index k such that nums[k] < nums[k + 1]. If no such index exists, just reverse `nums` and done.
 *  2. Find the largest index l > k such that nums[k] < nums[l].
 *  3. Swap nums[k] and nums[l].
 *  4. Reverse the sub-array nums[k + 1:].
 *
 * References:
 *  https://en.wikipedia.org/wiki/Permutation#Generation_in_lexicographic_order
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0Math {
    public void nextPermutation(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return;

        final int N = nums.length;
        int i = N - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            --i;
        }

        if (i >= 0) {
            int j = N - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                --j;
            }

            swap(i, j, nums);
        }

        reverseSince(i + 1, nums);
    }

    private void reverseSince(int lo, int[] nums) {
        final int N = nums.length;
        int hi = N - 1;
        while (lo < hi) {
            swap(lo++, hi--, nums);
        }
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}