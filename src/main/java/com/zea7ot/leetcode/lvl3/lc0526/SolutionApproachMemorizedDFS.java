/**
 * https://leetcode.com/problems/beautiful-arrangement/
 * 
 * #BitMap
 */
package com.zea7ot.leetcode.lvl3.lc0526;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproachMemorizedDFS {
    public int countArrangement(int N) {
        return countArrangement(N, 0, 0, new HashMap<Integer, Integer>());
    }
    
    private int countArrangement(int N, 
                                 int index, 
                                 int visited, 
                                 Map<Integer, Integer> cache){
        if(index == N) return 1;
        if(cache.containsKey(visited)) return cache.get(visited);
        
        int result = 0;
        for(int i = 1; i <= N; i++){
            int bit = 1 << (i - 1);
            if(((index + 1) % i) != 0 && i % (index + 1) != 0) continue;
            if((visited & bit) == 0){
                result += countArrangement(N, index + 1, visited | bit, cache);
            }
        }
        
        cache.put(visited, result);
        return result;
    }
}