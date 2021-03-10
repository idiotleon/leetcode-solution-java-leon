/**
 * https://leetcode.com/problems/contiguous-array/
 */
package com.an7one.leetcode.lvl3.lc0525;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproachPreSum {
    public int findMaxLength(int[] nums) {
        // sanity check
        if(nums == null || nums.length == 0) return 0;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                nums[i] = -1;
            }
        }
        
        int max = 0, sum = 0;
        Map<Integer, Integer> preSum = new HashMap<Integer, Integer>();
        preSum.put(0, -1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(preSum.containsKey(sum)){
                max = Math.max(max, i - preSum.get(sum));
            }else{
                preSum.put(sum, i);
            }
        }
        
        return max;
    }
}