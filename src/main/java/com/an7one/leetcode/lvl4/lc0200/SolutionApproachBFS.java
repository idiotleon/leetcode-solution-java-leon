/**
 * https://leetcode.com/problems/number-of-islands/
 * 
 * TLE
 */
package com.an7one.leetcode.lvl4.lc0200;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionApproachBFS {
    private static int[] DIRS = {0, 1, 0, -1, 0};
    private int NR, NC;
    
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        
        int count = 0;
        NR = grid.length;
        NC = grid[0].length;
        
        for(int row = 0; row < NR; row++){
            for(int col = 0; col < NC; col++){
                if(grid[row][col] == '1'){
                    count++;
                    bfs(grid, row, col);
                }
            }
        }

        return count;
    }
    
    private void bfs(char[][] grid, int row, int col){
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[]{row, col});
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                int[] cur = queue.poll();
                
                grid[cur[0]][cur[1]] = '0';
                
                for(int d = 0; d < 4; d++){
                    int r = cur[0] + DIRS[d], c = cur[1] + DIRS[d + 1];
                    if(r >= 0 && r < NR && c >= 0 && c < NC && grid[r][c] == '1'){
                        queue.add(new int[]{r, c});
                    }
                }
            }
        }
    }
}