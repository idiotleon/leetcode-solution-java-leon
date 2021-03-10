/**
 * https://leetcode.com/problems/majority-element/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(lg(N))
 * 
 * the description of the problem guarantees that there always will be a majority element
 */
package com.an7one.leetcode.lvl3.lc0169;

public class SolutionApproach1DivideAndConquer {
    public int majorityElement(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;
        return majorityElement(0, N - 1, nums);
    }

    private int majorityElement(int lower, int upper, int[] nums) {
        if (lower == upper)
            return nums[lower];

        int mid = lower + (upper - lower) / 2;
        int left = majorityElement(lower, mid, nums);
        int right = majorityElement(mid + 1, upper, nums);

        if (left == right)
            return left;

        int leftCount = countInRange(left, lower, upper, nums);
        int rightCount = countInRange(right, lower, upper, nums);

        return leftCount > rightCount ? left : right;
    }

    private int countInRange(int target, int lower, int upper, int[] nums) {
        int count = 0;
        for (int i = lower; i <= upper; ++i) {
            if (nums[i] == target) {
                ++count;
            }
        }

        return count;
    }
}