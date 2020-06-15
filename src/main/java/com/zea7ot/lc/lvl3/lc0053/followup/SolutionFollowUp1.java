/**
 * https://leetcode.com/problems/maximum-subarray/
 * 
 * follow up: 
 *  to return the length of the maximum subarray
 */
package com.zea7ot.lc.lvl3.lc0053.followup;

public class SolutionFollowUp1 {
    // to return the length of the maximum subarray
    public int lengthOfMaxSubArray(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE, maxEndingHere = 0;
        int start = 0, prevStart = 0, end = 0;
            
        for(int i = 0; i < nums.length; i++){
            maxEndingHere += nums[i];
                
            if(maxSoFar < maxEndingHere){
                maxSoFar = maxEndingHere;
                // to get the start from the previous round
                start = prevStart;
                // this is the end of the current round
                end = i;
            }
                
            if(maxEndingHere < 0){
                maxEndingHere = 0;
                // this is the start of the next round
                prevStart = i + 1;
            }
        }
            
        return (end - start + 1);
    }
}