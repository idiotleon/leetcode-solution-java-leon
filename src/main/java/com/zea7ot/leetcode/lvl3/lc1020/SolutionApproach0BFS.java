/**
 * https://leetcode.com/problems/number-of-enclaves/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(NR * NC)
 * 
 * References:
 *  https://leetcode.com/problems/number-of-enclaves/discuss/266168/Easy-Java-DFS-6ms-solution
 *  https://leetcode.com/problems/number-of-enclaves/discuss/265555/C%2B%2B-with-picture-DFS-and-BFS
 */
package com.zea7ot.leetcode.lvl3.lc1020;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionApproach0BFS {
    private final static int[] DIRS = {0, -1, 0, 1, 0};
    
    public int numEnclaves(int[][] grid) {
        final int NR = grid.length, NC = grid[0].length;
        for(int row = 0; row < NR; row++){
            for(int col = 0; col < NC; col++){
                if(row == 0 || row == NR - 1 || col == 0 || col == NC - 1){
                    fill(row, col, grid);
                }
            }
        }
        
        int count = 0;
        for(int row = 0; row < NR; row++){
            for(int col = 0; col < NC; col++){
                if(grid[row][col] == 1){
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private void fill(int row, int col, int[][] grid){
        final int NR = grid.length, NC = grid[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{row, col});
        grid[row][col] = 0;
        while(!queue.isEmpty()){
            for(int d = 0; d < 4; d++){
                int r = row + DIRS[d], c = col + DIRS[d + 1];
                if(r < 0 || r >= NR || c < 0 || c >= NC || grid[r][c] == 0) continue;
                queue.offer(new int[]{r, c});
                grid[r][c] = 0;
            }
        }
    }
}