/**
 * https://leetcode.com/problems/frog-jump/
 * 
 * Time Complexity: O(N ^ 3)
 * Space Complexity: O(N)
 */
package com.null7ptr.lc.lvl5.lv0403;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SolutionApproachHashMap {
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        
        final int L = stones.length;
        
        for(int i = 0; i < L; i++){
            map.put(stones[i], new HashSet<Integer>());
        }
        
        map.get(0).add(0);
        
        for(int i = 0; i < L; i++){
            for(int k : map.get(stones[i])){
                for(int step = k - 1; step <= k + 1; step++){
                    if(step > 0 && map.containsKey(stones[i] + step)){
                        map.get(stones[i] + step).add(step);
                    }
                }
            }
        }
        
        return map.get(stones[L - 1]).size() > 0;
    }
}