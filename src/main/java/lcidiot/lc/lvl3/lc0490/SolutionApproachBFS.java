/**
 * https://leetcode.com/problems/the-maze/
 */
package main.java.lcidiot.lc.lvl3.lc0490;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionApproachBFS {
    private static final int[][] DIRS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // sanity check
        if(maze == null || maze.length == 0) return false;
        
        // boundaries
        int nr = maze.length, nc = maze[0].length;

        // BFS
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(start);
        boolean[][] visited = new boolean[nr][nc];
        visited[start[0]][start[1]] = true;
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if(cur[0] == destination[0] && cur[1] == destination[1]){
                return true;
            }
            
            for(int[] dir : DIRS){
                int r = cur[0] + dir[0], c = cur[1] + dir[1];
                
                while(r >= 0 && c >= 0 && r < nr && c < nc && maze[r][c] == 0){
                    r += dir[0];
                    c += dir[1];
                }
                
                if(!visited[r - dir[0]][c - dir[1]]){
                    visited[r - dir[0]][c - dir[1]] = true;
                    queue.add(new int[]{r - dir[0], c - dir[1]});
                }
            }
        }
        
        return false;
    }
}