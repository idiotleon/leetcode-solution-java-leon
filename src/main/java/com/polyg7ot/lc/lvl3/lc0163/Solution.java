/**
 * https://leetcode.com/problems/missing-ranges/
 */
package com.polyg7ot.lc.lvl3.lc0163;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<String>();
        if(nums == null || nums.length == 0){
            result.add(getRange(lower, upper));
            return result;
        }
        
        // 1st step: to find the range between "lower" and the first element in the array
        if(nums[0] > lower)
            result.add(getRange(lower, nums[0] - 1));
        
        // 2nd step: to find ranges between adjacent elements in the array
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i + 1] != nums[i] && nums[i + 1] > nums[i] + 1){
                result.add(getRange(nums[i] + 1, nums[i + 1] - 1));
            }
        }
        
        // 3rd step: to find the range between "upper" and last element in the array
        if(nums[nums.length - 1] < upper){
            result.add(getRange(nums[nums.length - 1] + 1, upper));
        }
        
        return result;
    }
    
    private String getRange(int lower, int upper){
        return (lower == upper) ? String.valueOf(lower) : String.format("%d->%d", lower, upper);
    }
}