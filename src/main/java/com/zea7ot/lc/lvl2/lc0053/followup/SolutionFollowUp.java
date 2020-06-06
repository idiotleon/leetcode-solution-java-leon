/**
 * https://leetcode.com/problems/maximum-subarray/
 * 
 * follow up: 
 *  to return the start index of the maximum subarray
 */
package com.zea7ot.lc.lvl2.lc0053.followup;

public class SolutionFollowUp {
    // to return the start index of the maximum subarray
    public int startingPosOfMaxSubArray(int[] nums) {
        int maxSoFar = nums[0], maxEndingHere = nums[0];
        int start = 0, s = 0;
        
        for(int i = 0; i < nums.length; i++){
            maxEndingHere += nums[i];
            
            if(maxSoFar < maxEndingHere){
                maxSoFar = maxEndingHere;
                start = s;
            }
            
            if(maxEndingHere < 0){
                maxEndingHere = 0;
                s = i + 1;
            }
        }
        
        return start;
    }
}