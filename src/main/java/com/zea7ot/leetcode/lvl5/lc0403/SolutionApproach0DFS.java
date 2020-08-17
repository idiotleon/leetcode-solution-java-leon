/**
 * https://leetcode.com/problems/frog-jump/
 * 
 * Time Complexity: O(N * stones[L - 1])
 * Space Complexity: O(N)
 */
package com.zea7ot.leetcode.lvl5.lc0403;

import java.util.HashSet;
import java.util.Set;

public class SolutionApproach0DFS {
    public boolean canCross(int[] stones) {
        // sanity check
        if(stones == null || stones.length == 0) return false;
        
        final int L = stones.length;
        
        if(L == 1) return true;
        if(stones[1] != 1) return false;
        if(L == 2) return true;
        
        int last = stones[L - 1];
        Set<Integer> cache = new HashSet<Integer>();
        for(int i = 0; i < L; i++){
            if(i > 3 && stones[i] > stones[i - 1] * 2)  // the two stones are too far away
                return false;
            
            cache.add(stones[i]);
        }
        
        return canCross(stones, last, 1, 1, cache);
    }
    
    private boolean canCross(int[] stones, 
                             int last, 
                             int pos, 
                             int jump, 
                             Set<Integer> cache){
        if(pos + jump - 1 == last || pos + jump == last || pos + jump + 1 == last) return true;
        
        if(cache.contains(pos + jump + 1)){
            if(canCross(stones, last, pos + jump + 1, jump + 1, cache)) 
                return true;
        }
        
        if(cache.contains(pos + jump)){
            if(canCross(stones, last, pos + jump, jump, cache))
                return true;
        }
        
        if(jump > 1 && cache.contains(pos + jump - 1)){
            if(canCross(stones, last, pos + jump -1, jump - 1, cache))
                return true;
        }
        
        return false;
    }
}