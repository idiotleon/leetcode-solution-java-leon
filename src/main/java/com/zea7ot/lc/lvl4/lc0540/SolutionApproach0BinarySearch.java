/**
 * https://leetcode.com/problems/single-element-in-a-sorted-array/
 * 
 * Time Complexity: O(lg(N))
 * Space Complexity: O(1)
 */
package com.zea7ot.lc.lvl4.lc0540;

public class SolutionApproach0BinarySearch {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == nums[mid ^ 1]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        
        return nums[left];
    }
}