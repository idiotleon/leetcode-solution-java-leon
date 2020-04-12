/**
 * https://leetcode.com/problems/rotting-oranges/
 */
package main.java.lcidiot.lc0994;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionApproachBFS {
    private static final int[][] DIRS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private int nr, nc;
    
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return -1;
        nr = grid.length;
        nc = grid[0].length;
        int freshCount = 0;
        
        Queue<int[]> queue = new LinkedList<int[]>();
        for(int row = 0; row < nr; row++){
            for(int col = 0; col < nc; col++){
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
        if(freshCount == nr * nc) return -1;
        
        int count = 0;
        while(!queue.isEmpty()){
            count++;
            
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] cur = queue.poll();

                for(int[] dir : DIRS){
                    int r = cur[0] + dir[0], c = cur[1] + dir[1];
                    if(r < 0 || c < 0 || r >= nr || c >= nc) continue;

                    if(grid[r][c] == 1){
                        freshCount--;
                        grid[r][c] = 2;
                        queue.add(new int[]{r, c});
                        if(freshCount == 0) return count;
                    }
                }
            }
        }
        
        return -1;
    }
}