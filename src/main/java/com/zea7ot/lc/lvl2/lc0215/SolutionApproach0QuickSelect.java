/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 * 
 * Time Complexity:     O(N), O(N ^ 2) in the worst case
 * Space Complexity:    O(lg(N))
 * 
 * to Quick Select with random pivots
 */
package com.zea7ot.lc.lvl2.lc0215;

import java.util.Random;

public class SolutionApproach0QuickSelect {
    public int findKthLargest(int[] nums, int k) {
        final int N = nums.length;
        return quickSelect(0, N - 1, k - 1, nums);
    }

    private int quickSelect(int lo, int hi, int k, int[] nums) {
        if (lo <= hi) {
            int pivot = partition(lo, hi, nums);
            if (pivot == k)
                return nums[k];
            if (pivot > k)
                return quickSelect(lo, pivot - 1, k, nums);
            return quickSelect(pivot + 1, hi, k, nums);
        }

        return Integer.MIN_VALUE;
    }

    private int partition(int lo, int hi, int[] nums) {
        int pivot = lo + new Random().nextInt(hi - lo + 1);
        swap(hi, pivot, nums);
        for (int j = lo; j < hi; j++) {
            if (nums[j] > nums[hi]) {
                swap(j, lo, nums);
                ++lo;
            }
        }
        swap(lo, hi, nums);
        return lo;
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}