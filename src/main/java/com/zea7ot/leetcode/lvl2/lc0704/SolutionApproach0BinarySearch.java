/**
 * @author: Leon
 * 
 * https://leetcode.com/problems/binary-search/
 * 
 * Time Complexity: O(lg(N))
 * Space Complexity: O(1)
 */
package com.zea7ot.leetcode.lvl2.lc0704;

public class SolutionApproach0BinarySearch {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        final int L = nums.length;
        int lo = 0, hi = L - 1;
        
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) hi = mid - 1;
            else lo = mid + 1;
        }
        
        return -1;
    }
}