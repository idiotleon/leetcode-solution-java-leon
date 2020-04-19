/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * 
 * Time Complexity: O(lg(N))
 * Space Complexity: O(1)
 */
package main.java.lcidiot.lc0033;

public class SolutionApproachBinarySearch {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            
            if(nums[mid] == target) return mid;
            if(nums[left] <= nums[mid]){
                if(target >= nums[left] && target < nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else if(nums[mid] < nums[right]){
                if(target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        
        return -1;
    }
}