/**
 * https://leetcode.com/problems/minimum-knight-moves/
 */
package com.null7ptr.lc.lvl3.lc1197;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproachMemorizedDFS2 {
    public int minKnightMoves(int x, int y) {
        final int MOD = Math.abs(y) + 1;
        return dfs(x, y, new HashMap<Integer, Integer>(), MOD);
    }
    
    private int dfs(int row, int col, Map<Integer, Integer> cache, final int MOD){
        row = Math.abs(row);
        col = Math.abs(col);
        int index = row * MOD + col;
        if(cache.containsKey(index)){
            return cache.get(index);
        }
        
        int count = 0;
        if(row + col == 0) count = 0;
        else if(row + col == 2) count = 2;
        else{
            count = Math.min(dfs(row - 2, col - 1, cache, MOD), dfs(row - 1, col - 2, cache, MOD)) + 1;
        }
        
        cache.put(index, count);
        return count;
    }
}