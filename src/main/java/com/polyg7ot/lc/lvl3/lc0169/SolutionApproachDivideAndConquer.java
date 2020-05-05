/**
 * https://leetcode.com/problems/majority-element/
 */
package com.polyg7ot.lc.lvl3.lc0169;

public class SolutionApproachDivideAndConquer {
    public int majorityElement(int[] nums) {
        return majorityElement(nums, 0, nums.length - 1);
    }
    
    private int majorityElement(int[] nums, int lower, int upper){
        if(lower == upper) return nums[lower];
        
        int mid = lower + (upper - lower) / 2;
        int left = majorityElement(nums, lower, mid);
        int right = majorityElement(nums, mid + 1, upper);
        
        if(left == right) return left;
        
        int leftCount = countInRange(nums, left, lower, upper);
        int rightCount = countInRange(nums, right, lower, upper);
        
        return leftCount > rightCount ? left : right;
    }
    
    private int countInRange(int[] nums, int num, int lower, int upper){
        int count = 0;
        for(int i = lower; i <= upper; i++){
            if(nums[i] == num){
                count++;
            }
        }
        
        return count;
    }
}