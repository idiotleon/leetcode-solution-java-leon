/**
 * https://leetcode.com/problems/coloring-a-border/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(NR * NC)
 * 
 * References:
 *  https://leetcode.com/problems/coloring-a-border/discuss/283262/JavaPython-3-BFS-and-DFS-codes
 */
package com.idiotleon.leetcode.lvl3.lc1034;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SolutionApproach0BFS {
    private static final int[] DIRS = {0, -1, 0, 1, 0};
    private int NR, NC;
    
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        // sanity check
        if(grid == null || grid.length == 0 || grid[0].length == 0) return grid;
        
        NR = grid.length;
        NC = grid[0].length;
        final int COLOR = grid[r0][c0];
        
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{r0, c0});
        Set<Integer> seen = new HashSet<Integer>();
        seen.add(hash(r0, c0));
        
        while(!queue.isEmpty()){
            int[] top = queue.poll();
            int row = top[0], col = top[1];
            if(row == 0 || row == NR - 1 || col == 0 || col == NC - 1) grid[row][col] = color;
            for(int d = 0; d < 4; d++){
                int r = row + DIRS[d], c = col + DIRS[d + 1];
                if(r < 0 || r >= NR || c < 0 || c >= NC || seen.contains(hash(r, c))) continue;
                if(grid[r][c] == COLOR){ // neighbors of the same color
                    seen.add(hash(r, c));
                    queue.offer(new int[]{r, c});
                }else grid[row][col] = color; // neighbors of different colors
            }
        }
        
        return grid;
    }
    
    private int hash(int row, int col){
        return row * NC + col;
    }
}