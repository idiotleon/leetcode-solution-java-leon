/**
 * https://leetcode.com/problems/letter-tile-possibilities/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/letter-tile-possibilities/discuss/308333/Simple-Java-solution-of-backtracking-no-need-for-extra-space/438975
 *  https://leetcode.com/problems/letter-tile-possibilities/discuss/308333/Simple-Java-solution-of-backtracking-no-need-for-extra-space
 */
package com.idiotleon.leetcode.lvl3.lc1079;

import java.util.Arrays;

public class SolutionApproach0Backtrack2 {
    public int numTilePossibilities(String tiles) {
        // sanity check
        if(tiles == null || tiles.isEmpty()) return 0;
        char[] chs = tiles.toCharArray();
        Arrays.sort(chs);
        boolean[] visited = new boolean[chs.length];
        return backtrack(chs, visited);
    }
    
    private int backtrack(char[] chs, boolean[] visited){
        int count = 0;
        
        for(int i = 0; i < chs.length; i++){
            if(visited[i]) continue;
            if(i - 1 >= 0 && chs[i - 1] == chs[i] && !visited[i - 1]) continue;
            count++;
            
            visited[i] = true;
            count += backtrack(chs, visited);
            visited[i] = false;
        }
        
        return count;
    }
}