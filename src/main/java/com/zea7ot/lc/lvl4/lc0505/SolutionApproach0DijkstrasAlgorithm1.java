/**
 * https://leetcode.com/problems/the-maze-ii/
 * 
 * to find the next shortest stop from the starting point and then continue to explore from there.
 * 
 * Time Complexity:     O(V + Elg(V)) ~ 
 * Space Complexity:    O(Elg(V)) ~ 
 */
package com.zea7ot.lc.lvl4.lc0505;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SolutionApproach0DijkstrasAlgorithm1 {
    private static final int[] DIRS = {0, -1, 0, 1, 0};
    private int NR, NC;
    
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        // sanity check
        if(maze == null || maze.length == 0 || maze[0].length == 0) return -1;
        
        // boundaries/sizes of the maze
        this.NR = maze.length;
        this.NC = maze[0].length;
        
        int[][] distances = new int[NR][NC];
        for(int[] row : distances){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        distances[start[0]][start[1]] = 0;
        
        // min heap, by distance, the 1st element
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        minHeap.add(new int[]{0, start[0], start[1]});
        
        while(!minHeap.isEmpty()){
            int[] top = minHeap.poll();
            start[0] = top[1];
            start[1] = top[2];
            // to compare by value
            if(Arrays.equals(start, destination)) break;
            shortestDistance(maze, distances, start, minHeap);
        }
        
        int shortestDistance = distances[destination[0]][destination[1]];
        return shortestDistance == Integer.MAX_VALUE ? -1 : shortestDistance;
    }
    
    private void shortestDistance(int[][] maze, 
                                  int[][] distances, 
                                  int[] start, 
                                  PriorityQueue<int[]> minHeap){
        int distance = distances[start[0]][start[1]];
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
            if(distances[row][col] > distance + steps){
                distances[row][col] = distance + steps;
                minHeap.add(new int[]{distances[row][col], row, col});
            }
        }
    }
}