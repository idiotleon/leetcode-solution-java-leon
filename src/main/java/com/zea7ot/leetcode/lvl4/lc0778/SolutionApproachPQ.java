/**
 * https://leetcode.com/problems/swim-in-rising-water/
 */
package com.zea7ot.leetcode.lvl4.lc0778;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SolutionApproachPQ {
    private static final int[] DIRS = {0, 1, 0, -1, 0};
    
    public int swimInWater(int[][] grid) {
        // sanity check
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        final int N = grid.length;
        int[][] time = new int[N][N];
        for(int[] row : time){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        time[0][0] = grid[0][0];
        
        // min heap
        PriorityQueue<int[]> searchPQ = new PriorityQueue<int[]>((e0, e1) -> Integer.compare(e0[0], e1[0]));
        int[] start = new int[]{grid[0][0], 0, 0};
        searchPQ.add(start);
        
        while(!searchPQ.isEmpty()){
            int[] cur = searchPQ.poll();
            
            // if the node has been visited
            if(cur[0] > time[cur[1]][cur[2]]) continue;
            
            for(int d = 0; d < 4; d++){
                // to create the next(array) by value, instead of reference
                int[] next = cur.clone();
                // equivalently
                // int[] next = Arrays.copyOf(cur, cur.length);
                next[1] += DIRS[d];
                next[2] += DIRS[d + 1];
                
                if(next[1] < 0 || next[1] >= N || next[2] < 0 || next[2] >= N) continue;
                next[0] = Math.max(cur[0], grid[next[1]][next[2]]);
                
                if(next[0] < time[next[1]][next[2]]){
                    time[next[1]][next[2]] = next[0];
                    searchPQ.add(next);
                }
            }
        }
        
        if(time[N - 1][N - 1] == Integer.MAX_VALUE) return -1;
        return time[N - 1][N - 1];
    }
}