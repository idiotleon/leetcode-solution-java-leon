/**
 * https://leetcode.com/problems/shortest-path-in-binary-matrix/
 * 
 * Time Complexity:     O(N * N)
 * 
 * Space Complexity:    O(N * N) + O(8)
 *  O(N * N), consumed by visited(int[][])
 *  O(8), consumed by the queue
 */
package com.idiotleon.leetcode.lvl3.lc1091;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionApproach0BFS1 {
    private static final int[][] DIRS = {{1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}};
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid == null 
           || grid.length == 0 
           || grid[0].length == 0)
            return -1; 
        
        final int N = grid.length;
        if(grid[0][0] == 1 || grid[N - 1][N - 1] == 1) return -1;
        boolean[][] visited = new boolean[N][N];
        visited[0][0] = true;
        
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
                
                visited[row][col] = true;
                for(int[] DIR : DIRS){
                    int r = row + DIR[0], c = col + DIR[1];
                    if(r < 0 || r >= N || c < 0 || c >= N || visited[r][c] || grid[r][c] == 1) continue;
                    visited[r][c] = true;
                    queue.add(new int[]{r, c});
                }
            }
        }
        
        return -1;
    }
}