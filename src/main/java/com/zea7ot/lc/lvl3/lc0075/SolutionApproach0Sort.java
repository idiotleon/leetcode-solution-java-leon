/**
 * https://leetcode.com/problems/sort-colors/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
package com.zea7ot.lc.lvl3.lc0075;

public class SolutionApproach0Sort {
    public void sortColors(int[] nums) {
        // sanity check
        if(nums == null || nums.length < 2) return;
        
        final int N = nums.length;
        int left = 0, right = N - 1;
        
        // slightly pruning
        while(left < N && nums[left] == 0) left++;
        while(right >= 0 && nums[right] == 2) right--;
        
        int cur = left;
        while(cur <= right){
            if(nums[cur] == 0) swap(nums, cur++, left++);
            /**
             * 1. Conditions of if{...}if{...}if{...} is apparently different 
             *  from if{...}else if{...}else{...}.
             * 2. After swapping "cur" and "right", cur does not increment.
             *  Otherwise, [...0,2,...] is slipped through.
             */
            else if(nums[cur] == 2) swap(nums, cur, right--);
            else cur++;
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}