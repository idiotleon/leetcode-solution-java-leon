/**
 * 153. Find Minimum in Rotated Sorted Array
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * 
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand. (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]). Find
 * the minimum element.
 * 
 * You may assume no duplicate exists in the array. 
 * Example 1: 
 * Input:
 * [3,4,5,1,2] 
 * Output: 1 
 * 
 * Example 2:
 * Input: [4,5,6,7,0,1,2] 
 * Output: 0
 */

package com.idiotleon.java.lc0153;

public class SolutionApproachBinarySearch {
    public int findMin(int[] nums) {
        if (nums.length == 0)
            return -1;
        int left = 0, right = nums.length - 1;
        if (nums[right] > nums[left])
            return nums[0];

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1])
                return nums[mid + 1];
            if (nums[mid - 1] > nums[mid])
                return nums[mid];

            if (nums[left] < nums[mid])
                left = mid + 1;
            else
                right = mid;
        }

        return nums[left];
    }
}