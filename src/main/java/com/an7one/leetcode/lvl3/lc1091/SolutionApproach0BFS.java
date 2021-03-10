/**
 * https://leetcode.com/problems/shortest-path-in-binary-matrix/
 * 
 * Time Complexity:     O(N * N)
 * 
 * Space Complexity:    O(8) ~ O(1)
 *  O(8), consumed by the queue
 */
package com.an7one.leetcode.lvl3.lc1091;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionApproach0BFS {
    private static final int[][] DIRS = {{1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}};
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        // sanity check
        if(grid == null 
           || grid.length == 0 
           || grid[0].length == 0)
            return -1; 
        
        final int N = grid.length;
        // sanity check
        if(grid[0][0] == 1 || grid[N - 1][N - 1] == 1) return -1;
        
        Queue<int[]> queue = new LinkedList<int[]>();
        int count = 0;
        queue.add(new int[]{0, 0});
        
        while(!queue.isEmpty()){
            final int SIZE = queue.size();
            count++;
            
            for(int i = 0; i < SIZE; i++){
                int[] cur = queue.poll();
                
                int row = cur[0], col = cur[1];
                if(row == N - 1 && col == N - 1) return count;
                
                grid[row][col] = 1;
                for(int[] DIR : DIRS){
                    int r = row + DIR[0], c = col + DIR[1];
                    if(r < 0 || r >= N || c < 0 || c >= N || grid[r][c] == 1) continue;
                    grid[r][c] = 1;
                    queue.add(new int[]{r, c});
                }
            }
        }
        
        return -1;
    }
}