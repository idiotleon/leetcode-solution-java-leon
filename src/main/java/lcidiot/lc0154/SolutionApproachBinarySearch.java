/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */
package main.java.lcidiot.lc0154;

class SolutionApproachBinarySearch {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        while(left < right){
            int mid = left + (right - left) / 2;
            
            if(nums[mid] > nums[right]) left = mid + 1;
            else if(nums[mid] < nums[right]) right = mid;
            else right--;
        }
        
        return nums[left];
    }
}