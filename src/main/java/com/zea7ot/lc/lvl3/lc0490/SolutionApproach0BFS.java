/**
 * https://leetcode.com/problems/the-maze/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    ?O(NR * NC)
 */
package com.zea7ot.lc.lvl3.lc0490;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SolutionApproach0BFS {
    private static final int[][] DIRS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // sanity check
        if(maze == null || maze.length == 0) return false;
        
        // boundaries
        final int NR = maze.length, NC = maze[0].length;

        // BFS
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(start);
        boolean[][] visited = new boolean[NR][NC];
        visited[start[0]][start[1]] = true;
        
        while(!queue.isEmpty()){
            int[] top = queue.poll();
            if(Arrays.equals(top, destination)) return true;
    
            for(final int[] DIR : DIRS){
                int r = top[0], c = top[1];
                
                while(isValid(maze, r + DIR[0], c + DIR[1])){
                    r += DIR[0];
                    c += DIR[1];
                }
                
                if(visited[r][c]) continue;
                visited[r][c] = true;
                queue.add(new int[]{r, c});
            }
        }
        
        return false;
    }

    private boolean isValid(int[][] maze, int row, int col){
        return row >= 0 && row < maze.length && col >= 0 && col < maze[0].length && maze[row][col] == 0;
    }
}