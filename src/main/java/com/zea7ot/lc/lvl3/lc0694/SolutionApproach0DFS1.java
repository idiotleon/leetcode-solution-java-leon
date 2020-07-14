/**
 * https://leetcode.com/problems/number-of-distinct-islands/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(NR * NC)
 */
package com.zea7ot.lc.lvl3.lc0694;

import java.util.HashSet;
import java.util.Set;

public class SolutionApproach0DFS1 {
    private final int[][] DIRS = new int[][]{{0, 1}, {-1, 0},{0, -1},{1, 0}};
    
    public int numDistinctIslands(int[][] grid) {
        // sanity check
        if(grid == null || grid.length == 0) return 0;

        final int NR = grid.length, NC = grid[0].length;
        Set<String> set = new HashSet<>();
        int ans = 0;
        
        for(int row = 0; row < NR; row++){
            for(int col = 0; col < NC; col++){
                if(grid[row][col] == 1){
                    StringBuilder builder = new StringBuilder();
                    dfs(grid, row, col, 0, 0, builder);
                    String signature = builder.toString();
                    if(set.contains(signature)) continue;
                    ans++;
                    set.add(signature);
                }
            }
        }
        
        return ans;
    }
    
    private void dfs(int[][] grid, 
                        int row, 
                        int col, 
                        int xpos, 
                        int ypos, 
                        StringBuilder builder){
        final int NR = grid.length, NC = grid[0].length;
        grid[row][col] = 0;
        builder.append(xpos + "," + ypos);
        for(int[] dir : DIRS){
            int r = row + dir[0], c = col + dir[1];
            if(r < 0 || c < 0 || r >= NR || c >= NC || grid[r][c] == 0) continue;
            dfs(grid, r, c, xpos + dir[0], ypos + dir[1], builder);
        }
    }
}