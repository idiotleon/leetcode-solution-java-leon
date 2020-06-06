/**
 * https://leetcode.com/problems/rotate-array/
 * 
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
package com.zea7ot.lc.lvl1.lc0189;

public class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    
    private void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}