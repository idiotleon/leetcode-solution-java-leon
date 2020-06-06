/**
 * https://leetcode.com/problems/binary-subarrays-with-sum/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
package com.zea7ot.lc.lvl4.lc0930;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproachPreSum1 {
    public int numSubarraysWithSum(int[] nums, int S) {
        Map<Integer, Integer> preSum = new HashMap<Integer, Integer>();
        preSum.put(0, 1);
        int sum = 0, ans = 0;
        
        for(int num : nums){
            sum += num;
            
            if(sum >= S){
                ans += preSum.getOrDefault(sum - S, 0);
            }
            
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        
        return ans;
    }
}