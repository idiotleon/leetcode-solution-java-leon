/**
 * https://leetcode.com/problems/letter-tile-possibilities/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
package com.an7one.leetcode.lvl3.lc1079;

import java.util.Arrays;

public class SolutionApproach0Backtrack1 {
    private int count;
    
    public int numTilePossibilities(String tiles) {
        this.count = 0;
        // sanity check
        if(tiles == null || tiles.isEmpty()) return count;
        
        char[] chs = tiles.toCharArray();
        Arrays.sort(chs);
        boolean[] visited = new boolean[chs.length];
        backtrack(chs, visited, 0);
        
        return count;
    }
    
    private void backtrack(char[] chs, boolean[] visited, final int LEN){
        if(LEN == chs.length) return;
        
        for(int i = 0; i < chs.length; i++){
            if(visited[i]) continue;
            if(i - 1 >= 0 && chs[i - 1] == chs[i] && !visited[i - 1]) continue;
            count++;
            
            visited[i] = true;
            backtrack(chs, visited, LEN + 1);
            visited[i] = false;
        }
    }
}