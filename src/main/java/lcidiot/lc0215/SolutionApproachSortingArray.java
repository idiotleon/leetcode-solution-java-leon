/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
package main.java.lcidiot.lc0215;

import java.util.Arrays;

class SolutionApproachSortingArray {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}