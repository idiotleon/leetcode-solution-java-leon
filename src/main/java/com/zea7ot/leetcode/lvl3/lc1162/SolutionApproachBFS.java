/**
 * https://leetcode.com/problems/as-far-from-land-as-possible/
 */
package com.zea7ot.leetcode.lvl3.lc1162;

import java.util.LinkedList;

public class SolutionApproachBFS {
    private static final int[] DIRS = {0, 1, 0, -1, 0};
    
    public int maxDistance(int[][] grid) {
        if(grid == null || grid.length == 0) return -1;
        
        int totalSize = 0;
        LinkedList<int[]> queue = new LinkedList<int[]>();
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[row].length; col++){
                if(grid[row][col] == 1){
                    queue.add(new int[]{row, col});
                }
                
                totalSize++;
            }
        }
        
        // no land or no water
        if(queue.isEmpty() || queue.size() == totalSize) return -1;
        
        int distance = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            
            distance++;
            for(int i = 0; i < size; i++){
                int[] cur = queue.removeFirst();
                
                for(int d = 0; d < 4; d++){
                    int r = cur[0] + DIRS[d], c = cur[1] + DIRS[d + 1];
                    
                    if(r >= 0 && r < grid.length && c >= 0 && c < grid[r].length && grid[r][c] == 0){
                        grid[r][c] = 1;
                        queue.add(new int[]{r, c});
                    }
                }
            }
        }
        
        // to minus the operation of the last (one) round/level
        return distance - 1;
    }
}