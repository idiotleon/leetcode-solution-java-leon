/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 
 * Time Complexity:     O(2 * lg(N)) ~ O(lg(N))
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://stackoverflow.com/a/44232847/6061609
 */
package com.an7one.leetcode.lvl3.lc0034;

public class SolutionApproach0BinarySearch1 {
    public int[] searchRange(int[] nums, int target) {
        final int N = nums.length;
        int start = binarySearchLeftmost(nums, target);
        if(start == N || nums[start] != target){
            return new int[]{-1, -1};
        }
        
        return new int[]{start, binarySearchLeftmost(nums, target + 1) - 1};
    }
    
    private int binarySearchLeftmost(int[] nums, int target){
        final int N = nums.length;
        int lo = 0, hi = N - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            
            // this cannot be here
            //if(nums[mid] == target) return mid;
            if(target > nums[mid]) lo = mid + 1;
            else hi = mid - 1;
        }
        
        return lo;
    }
}