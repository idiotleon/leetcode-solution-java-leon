/**
 * https://leetcode.com/problems/find-peak-element/
 * 
 * Time Complexity:     O(lg(N))
 * Space Complexity:    O(lg(N))
 */
package com.zea7ot.lc.lvl3.lc0162;

public class SolutionApproach0BinarySearch {
    public int findPeakElement(int[] nums) {
        // sanity check
        if(nums == null || nums.length < 2) return 0;
        
        int lo = 0, hi = nums.length - 1;
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            
            if(nums[mid] > nums[mid + 1]) hi = mid;
            else lo = mid + 1;
        }
        
        return lo;
    }
}