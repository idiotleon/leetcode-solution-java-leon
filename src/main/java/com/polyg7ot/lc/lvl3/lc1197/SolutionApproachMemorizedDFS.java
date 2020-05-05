/**
 * https://leetcode.com/problems/minimum-knight-moves/
 */
package com.polyg7ot.lc.lvl3.lc1197;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproachMemorizedDFS {
    public int minKnightMoves(int x, int y) {
        final int MOD = Math.abs(y) + 1;
        return dfs(x, y, new HashMap<Integer, Integer>(), MOD);
    }
    
    private int dfs(int row, int col, Map<Integer, Integer> cache, int MOD){
        row = Math.abs(row);
        col = Math.abs(col);
        
        int key = row * MOD + col;
        if(cache.containsKey(key)) return cache.get(key);
        
        if(row + col == 0) return 0;
        if(row + col == 2) return 2;
        
        int min = Math.min(dfs(row - 2, col - 1, cache, MOD), 
                         dfs(row - 1, col - 2, cache, MOD)) + 1;
        
        cache.put(key, min);
        
        return min;
    }
}