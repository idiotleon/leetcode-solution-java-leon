/**
 * @author: Leon
 * https://leetcode.com/problems/letter-tile-possibilities/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
package com.an7one.leetcode.lvl3.lc1079;

import java.util.HashSet;
import java.util.Set;

public class SolutionApproach1BacktrackNaively {
    public int numTilePossibilities(String tiles) {
        Set<String> res = new HashSet<String>();
        // sanity check;
        if(tiles == null || tiles.isEmpty()) return 0;
        
        char[] chs = tiles.toCharArray();
        final int L = chs.length;
        boolean[] visited = new boolean[L];
        
        for(int l = 1; l <= L; l++){
            backtrack(chs, visited, new StringBuilder(), l, res);
        }
        
        return res.size();
    }
    
    private void backtrack(char[] chs, 
                           boolean[] visited,
                           StringBuilder builder, 
                           final int LEN, 
                           Set<String> res){
        final int L = chs.length;
        
        if(builder.length() == LEN){
            res.add(builder.toString());
            return;
        }
        
        for(int i = 0; i < L; i++){
            if(visited[i]) continue;
            visited[i] = true;
            builder.append(chs[i]);
            backtrack(chs, visited, builder, LEN, res);
            visited[i] = false;
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}