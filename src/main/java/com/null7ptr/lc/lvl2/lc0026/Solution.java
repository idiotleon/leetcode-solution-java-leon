/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
package com.null7ptr.lc.lvl2.lc0026;

public class Solution{
    public int removeDuplicates(int[] nums) {
        // sanity check
        if(nums == null || nums.length == 0) return 0;
        
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != nums[j]){
                nums[++j] = nums[i];
            }
        }
        
        return ++j;
    }
}