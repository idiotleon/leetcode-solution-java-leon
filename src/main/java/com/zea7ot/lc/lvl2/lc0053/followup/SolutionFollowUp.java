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
        // sanity check
        if(nums == null || nums.length == 0) return 0;

        final int N = nums.length;
        int maxSoFar = nums[0], maxEndingHere = nums[0];
        int start = 0, prevStart = 0;
        
        for(int i = 0; i < N; i++){
            maxEndingHere += nums[i];
            
            if(maxSoFar < maxEndingHere){
                maxSoFar = maxEndingHere;
                start = prevStart;
            }
            
            if(maxEndingHere < 0){
                maxEndingHere = 0;
                prevStart = i + 1;
            }
        }
        
        return start;
    }
}