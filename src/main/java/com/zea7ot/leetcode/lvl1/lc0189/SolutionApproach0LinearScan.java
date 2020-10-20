/**
 * https://leetcode.com/problems/rotate-array/
 * 
 * Time Complexity:     O(`N`)
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl1.lc0189;

public class SolutionApproach0LinearScan {
    public void rotate(int[] nums, int k) {
        final int N = nums.length;

        k %= N;
        reverse(0, N, nums);
        reverse(0, k, nums);
        reverse(k, N, nums);
    }

    private void reverse(int lo, int hi, int[] nums) {
        --hi;
        while (lo < hi) {
            int temp = nums[lo];
            nums[lo] = nums[hi];
            nums[hi] = temp;
            ++lo;
            --hi;
        }
    }
}