/**
 * https://leetcode.com/problems/number-of-distinct-islands/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(NR * NC)
 */
package com.zea7ot.leetcode.lvl3.lc0694;

import java.util.HashSet;
import java.util.Set;

public class SolutionApproach0DFS {
    private final int[][] DIRS = new int[][]{{0, 1}, {-1, 0},{0, -1},{1, 0}};
    private final char[] MOVES = new char[]{'u', 'l', 'd', 'r'};
    private final char START = 'a';
    private final char END = 'z';
    
    public int numDistinctIslands(int[][] grid) {
        // sanity check
        if(grid == null || grid.length == 0) return 0;

        final int NR = grid.length, NC = grid[0].length;
        Set<String> set = new HashSet<>();
        
        for(int row = 0; row < NR; row++){
            for(int col = 0; col < NC; col++){
                if(grid[row][col] == 1){
                    StringBuilder builder = new StringBuilder();
                    dfs(grid, row, col, builder, START);
                    String signature = builder.toString();
                    set.add(signature);
                }
            }
        }
        
        return set.size();
    }
    
    private void dfs(int[][] grid, 
                     int row, 
                     int col, 
                     StringBuilder builder, 
                     char move){
        final int NR = grid.length, NC = grid[0].length;
        
        grid[row][col] = 0;
        builder.append(move);
        for(int d = 0; d < 4; d++){
            int r = row + DIRS[d][0], c = col + DIRS[d][1];
            if(r < 0 || c < 0 || r >= NR || c >= NC || grid[r][c] == 0) continue;
            dfs(grid, r, c, builder, MOVES[d]);
        }
        builder.append(END);
    }
}