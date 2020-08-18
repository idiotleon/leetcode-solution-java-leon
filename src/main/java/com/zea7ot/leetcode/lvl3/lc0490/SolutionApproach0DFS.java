/**
 * https://leetcode.com/problems/the-maze/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    ?O(NR * NC)
 * 
 * References:
 *  https://leetcode.com/problems/the-maze/discuss/97067/Simple-Java-DFS-with-comments
 */
package com.zea7ot.leetcode.lvl3.lc0490;

import java.util.Arrays;

public class SolutionApproach0DFS {
    private static final int[][] DIRS = {{-1, 0},{1, 0}, {0, -1}, {0, 1}};
    private int NR, NC;
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // sanity check
        if(maze == null || maze.length == 0) return false;
        
        this.NR = maze.length;
        this.NC = maze[0].length;
        boolean[][] visited = new boolean[NR][NC];
        
        return dfs(maze, start, destination, visited);
    }
    
    private boolean dfs(int[][] maze, 
                        int[] pos,
                        int[] destination, 
                        boolean[][] visited){
        int row = pos[0], col = pos[1];
        if(visited[row][col]) return false;
        if(Arrays.equals(pos, destination)) return true;
        
        visited[row][col] = true;
        for(final int[] DIR : DIRS){
            int r = row, c = col;
            while(isValid(maze, r + DIR[0], c + DIR[1])){
                r += DIR[0];
                c += DIR[1];
            }
            
            if(dfs(maze, new int[]{r, c}, destination, visited)) 
                return true;
        }
        
        return false;
    }
    
    private boolean isValid(int[][] maze, int row, int col){
        return row >= 0 && row < NR && col >= 0 && col < NC && maze[row][col] == 0;
    }
}