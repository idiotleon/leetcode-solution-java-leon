/**
 * https://leetcode.com/problems/the-maze-ii/
 * 
 * to find the next shortest stop from the starting point and then continue to explore from there.
 * 
 * Time Complexity:
 * Space Complexity:
 */
package com.zea7ot.lc.lvl4.lc0505;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SolutionApproachPQ {
    private static final int[] DIRS = {0, -1, 0, 1, 0};
    private int NR, NC;
    
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        // sanity check;
        if(maze == null || maze.length == 0 || maze[0].length == 0) return -1;
        
        // boundaries/sizes of maze
        NR = maze.length;
        NC = maze[0].length;
        
        int[][] visited = new int[NR][NC];
        for(int[] row : visited){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        visited[start[0]][start[1]] = 0;
        
        // min heap, by distance, the 1st element
        PriorityQueue<int[]> processPQ = new PriorityQueue<int[]>((e0, e1) -> Integer.compare(e0[0], e1[0]));
        processPQ.add(new int[]{0, start[0], start[1]});
        
        while(!processPQ.isEmpty()){
            int[] cur = processPQ.poll();
            start[0] = cur[1];
            start[1] = cur[2];
            // to compare by value
            if(Arrays.equals(start, destination)) break;
            shortestDistance(maze, visited, start, processPQ);
        }
        
        int shortestDistance = visited[destination[0]][destination[1]];
        if(shortestDistance == Integer.MAX_VALUE) return -1;
        return shortestDistance;
    }
    
    private void shortestDistance(int[][] maze, 
                    int[][] visited, 
                    int[] start, 
                    PriorityQueue<int[]> processPQ){
        int distance = visited[start[0]][start[1]];
        for(int d = 0; d < 4; d++){
            int steps = 0;
            int row = start[0], col = start[1];
            while(true){
                row += DIRS[d];
                col += DIRS[d + 1];
                if(row >= 0 && row < NR && col >= 0 && col < NC && maze[row][col] == 0){
                    steps++;
                }else{
                    row -= DIRS[d];
                    col -= DIRS[d + 1];
                    break;
                }
            }
            // to skip if it remains at the same/start position
            // to compare by value
            if(row == start[0] && col == start[1]) continue;
            
            // to update with the shortest distance
            if(visited[row][col] > distance + steps){
                visited[row][col] = distance + steps;
                processPQ.add(new int[]{visited[row][col], row, col});
            }
        }
    }
}