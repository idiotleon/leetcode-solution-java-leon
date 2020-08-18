/**
 * https://leetcode.com/problems/split-array-into-consecutive-subsequences/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/split-array-into-consecutive-subsequences/discuss/106514/Python-Easy-Understand-Greedy/503317
 *  https://leetcode.com/problems/split-array-into-consecutive-subsequences/discuss/106514/Python-Easy-Understand-Greedy
 */
package com.zea7ot.leetcode.lvl3.lc0659;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0Greedy1 {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> left = new HashMap<Integer, Integer>();
        Map<Integer, Integer> end = new HashMap<Integer, Integer>();
        
        for(int num : nums){
            left.put(num, left.getOrDefault(num, 0) + 1);
        }
        
        for(int num : nums){
            if(left.get(num) <= 0) continue;
            
            left.put(num, left.get(num) - 1);
            
            if(end.containsKey(num - 1) && end.get(num - 1) > 0){
                end.put(num - 1, end.get(num - 1) - 1);
                end.put(num, end.getOrDefault(num, 0) + 1);
            } else if(left.containsKey(num + 1) && left.containsKey(num + 2) && left.get(num + 1) > 0 && left.get(num + 2) > 0){
                left.put(num + 1, left.get(num + 1) - 1);
                left.put(num + 2, left.get(num + 2) - 1);
                end.put(num + 2, end.getOrDefault(num + 2, 0) + 1);
            }else return false;
        } 
        
        return true;
    }
}