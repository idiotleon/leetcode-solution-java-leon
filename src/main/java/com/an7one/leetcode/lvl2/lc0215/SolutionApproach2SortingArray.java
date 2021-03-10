/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(1)
 */
package com.an7one.leetcode.lvl2.lc0215;

import java.util.Arrays;

public class SolutionApproach2SortingArray {
    public int findKthLargest(int[] nums, int k) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;
        Arrays.sort(nums);
        return nums[N - k];
    }
}