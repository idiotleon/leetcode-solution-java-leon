/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * 
 * Time Complexity:     O(lg(N))
 * Space Complexity:    O(1)
 */
package com.zea7ot.lc.lvl3.lc0153;

public class SolutionApproach1BinarySearch {
    public int findMin(int[] nums) {
        // sanity check
        if(nums == null || nums.length == 0) return -1;
        
        final int N = nums.length;
        if(N == 1) return nums[0];
        int lo = 0, hi = N - 1;
        
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            
            if(mid < N - 1 && nums[mid] > nums[mid + 1]) return nums[mid + 1];
            if(mid > 1 && nums[mid - 1] > nums[mid]) return nums[mid];
            
            if(nums[lo] < nums[mid]) lo = mid + 1;
            else hi = mid - 1;
        }
        
        return nums[0];
    }
}