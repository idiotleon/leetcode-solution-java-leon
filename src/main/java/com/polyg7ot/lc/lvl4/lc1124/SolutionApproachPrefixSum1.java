/**
 * https://leetcode.com/problems/longest-well-performing-interval/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
package com.polyg7ot.lc.lvl4.lc1124;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproachPrefixSum1 {
    public int longestWPI(int[] hours) {
        int ans = 0, score = 0;
        final int L = hours.length;
        
        Map<Integer, Integer> seen = new HashMap<Integer, Integer>();
        for(int i = 0; i < L; i++){
            score += hours[i] > 8 ? 1 : -1;
            if(score > 0) ans = i + 1;
            else{
                seen.putIfAbsent(score, i);
                if(seen.containsKey(score - 1)){
                    ans = Math.max(ans, i - seen.get(score - 1));
                }
            }
        }
        
        return ans;
    }
}