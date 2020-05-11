/**
 * https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
package com.polyg7ot.lc.lvl3.lc0325;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproachPreSum {
    public int maxSubArrayLen(int[] nums, int k) {
        int sum = 0, maxLen = 0;
        Map<Integer, Integer> preSum = new HashMap<Integer, Integer>();
        preSum.put(0, -1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(preSum.containsKey(sum - k)){
                maxLen = Math.max(maxLen, i - preSum.get(sum - k));
            }
            
            if(!preSum.containsKey(sum)) preSum.put(sum, i);
        }
        
        return maxLen;
    }
}