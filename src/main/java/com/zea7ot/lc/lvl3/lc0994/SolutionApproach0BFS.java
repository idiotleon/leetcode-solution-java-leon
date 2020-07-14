/**
 * https://leetcode.com/problems/rotting-oranges/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(max(NR, NC))
 */
package com.zea7ot.lc.lvl3.lc0994;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionApproach0BFS {
    private static final int[][] DIRS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    
    public int orangesRotting(int[][] grid) {
        // sanity check
        if(grid == null || grid.length == 0) return -1;
        final int NR = grid.length, NC = grid[0].length;
        int freshCount = 0;
        
        Queue<int[]> queue = new LinkedList<int[]>();
        for(int row = 0; row < NR; row++){
            for(int col = 0; col < NC; col++){
                if(grid[row][col] == 2){
                    queue.add(new int[]{row, col});
                }else if(grid[row][col] == 1){
                    freshCount++;
                }
            }
        }
        
        // there is no resh oranges at all
        if(freshCount == 0) return 0;
        // all are fresh oranges
        if(freshCount == NR * NC) return -1;
        
        int count = 0;
        while(!queue.isEmpty()){
            count++;
            
            final int SIZE = queue.size();
            for(int i = 0; i < SIZE; i++){
                int[] cur = queue.poll();

                for(int[] dir : DIRS){
                    int r = cur[0] + dir[0], c = cur[1] + dir[1];
                    if(r < 0 || c < 0 || r >= NR || c >= NC || grid[r][c] != 1) continue;

                    --freshCount;
                    grid[r][c] = 2;
                    queue.add(new int[]{r, c});
                    if(freshCount == 0) return count;
                }
            }
        }
        
        return -1;
    }
}