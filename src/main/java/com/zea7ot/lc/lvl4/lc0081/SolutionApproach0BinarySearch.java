/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 * 
 * Time Complexity: O(lg(N))
 *  in the worst case: O(N)
 *  e.g.: [1,1,1,1,1,1,5], target = 5
 * Space Complexity: O(1)
 * 
 * References:
 *  https://leetcode.com/problems/search-in-rotated-sorted-array-ii/discuss/28212/When-there-are-duplicates-the-worst-case-is-O(n).-Could-we-do-better/27225
 */
package com.zea7ot.lc.lvl4.lc0081;

public class SolutionApproach0BinarySearch {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return false;
        
        int left = 0, right = nums.length - 1;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            
            if(nums[mid] == target) return true;
            
            if(nums[left] < nums[mid]){  // left half is sorted
                if(nums[mid] > target && nums[left] <= target){
                    right = mid;
                }else left = mid + 1;
            }else if(nums[left] > nums[mid]){    // right half is sorted
                if(nums[mid] < target && nums[right] >= target){
                    left = mid + 1;
                }else right = mid;
            }
            // when nums[left] == nums[mid],
            // basically having no idea about the array,
            // then to exclude nums[left] and repeat the above process
            else left++;
        }
        
        return false;
    }
}