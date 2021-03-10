/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 
 * Time Complexity:     O(2 * lg(N)) ~ O(lg(N))
 * Space Complexity:    O(1)
 */
package com.an7one.leetcode.lvl3.lc0034;

public class SolutionApproach1BinarySearch {
    public int[] searchRange(int[] nums, int target) {
        int[] range = {-1, -1};
        if(nums == null || nums.length == 0) return range;
        
        int leftIdx = search(nums, target, true);
        if(leftIdx == nums.length || nums[leftIdx] != target) return range;
        
        range[0] = leftIdx;
        range[1] = search(nums, target, false) - 1;
        
        return range;
    }
    
    private int search(int[] nums, int target, boolean left){
        int lo = 0, hi = nums.length;
        
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] > target || (left && nums[mid] == target))
                hi = mid;
            else lo = mid + 1;
        }
        
        return lo;
    }
}