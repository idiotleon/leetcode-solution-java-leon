/**
 * https://leetcode.com/problems/minimum-knight-moves/
 */
package com.idiotleon.leetcode.lvl3.lc1197;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproachMemorizedDFS1 {
    public int minKnightMoves(int x, int y) {
        return dfs(x, y, new HashMap<String, Integer>());
    }
    
    private int dfs(int row, int col, Map<String, Integer> cache){
        row = Math.abs(row);
        col = Math.abs(col);
        
        String key = row + "," + col;
        if(cache.containsKey(key)) return cache.get(key);
        
        if(row + col == 0) return 0;
        if(row + col == 2) return 2;
        
        int min = Math.min(dfs(row - 2, col - 1, cache), 
                         dfs(row - 1, col - 2, cache)) + 1;
        
        cache.put(key, min);
        
        return min;
    }
}