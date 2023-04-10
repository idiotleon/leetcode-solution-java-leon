/**
 * https://leetcode.com/problems/missing-element-in-sorted-array/
 * 
 * Time Complexity: O(lg(N))
 * Space Complexity: O(1)
 * 
 * References:
 *  https://leetcode.com/problems/missing-element-in-sorted-array/discuss/348481/Java-Concise-Binary-Search/453024
 */
package com.idiotleon.leetcode.lvl3.lc1060;

public class SolutionApproach0BinarySearch {
    public int missingElement(int[] nums, int k) {
        // sanity check
        if(nums == null || nums.length == 0) return k;
        
        final int L = nums.length;
        int left = 0, right = L;
        int target = nums[0] + k;
        
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] <= target + mid - 1){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        
        return target + left - 1;
    }
}