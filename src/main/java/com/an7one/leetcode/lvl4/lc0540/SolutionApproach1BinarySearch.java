/**
 * https://leetcode.com/problems/single-element-in-a-sorted-array/
 * 
 * Time Complexity: O(lg(N))
 * Space Complexity: O(1)
 */
package com.an7one.leetcode.lvl4.lc0540;

public class SolutionApproach1BinarySearch {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        while(left < right){
            int mid = left + (right - left) / 2;
            
            if(mid % 2 == 0){
                // mid is even
                if(nums[mid] == nums[mid + 1]){
                    left = mid + 2;
                }else{
                    right = mid;
                }
            }else{
                // mid is odd
                if(nums[mid] == nums[mid - 1]){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }
        }
        
        return nums[left];
    }
}