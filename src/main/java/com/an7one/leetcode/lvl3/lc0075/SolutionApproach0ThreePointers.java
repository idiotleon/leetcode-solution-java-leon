/**
 * https://leetcode.com/problems/sort-colors/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
package com.an7one.leetcode.lvl3.lc0075;

public class SolutionApproach0ThreePointers {
    public void sortColors(int[] nums) {
        // sanity check
        if (nums == null || nums.length < 2)
            return;

        final int N = nums.length;
        int lo = 0, hi = N - 1;

        // slightly pruning
        while (lo < N && nums[lo] == 0)
            ++lo;
        while (hi >= 0 && nums[hi] == 2)
            --hi;

        int idx = lo;
        while (idx <= hi) {
            if (nums[idx] == 0)
                swap(idx++, lo++, nums);
            /**
             * 1. Conditions of if{...}if{...}if{...} is apparently different from
             * if{...}else if{...}else{...}. 2. After swapping "idx" and "hi", idx does not
             * increment. Otherwise, [...0,2,...] is slipped through.
             */
            else if (nums[idx] == 2)
                swap(idx, hi--, nums);
            else
                ++idx;
        }
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}