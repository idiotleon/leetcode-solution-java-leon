/**
 * https://leetcode.com/problems/unique-paths-iii/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(NR * NC)
 * 
 * References:
 *  https://leetcode.com/problems/unique-paths-iii/discuss/289954/Java-Solution-DFS-With-backtracking
 */
package com.an7one.leetcode.lvl4.lc0980;

public class SolutionApproach0Backtrack {
    private static final int[] DIRS = {0, -1, 0, 1, 0};
    public int uniquePathsIII(int[][] grid) {
        // sanity check
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        final int NR = grid.length, NC = grid[0].length;
        int startRow = 0, startCol = 0, empty = 0;
        for(int row = 0; row < NR; row++){
            for(int col = 0; col < NC; col++){
                if(grid[row][col] == 0) ++empty;
                else if(grid[row][col] == 1){
                    startRow = row;
                    startCol = col;
                }
            }
        }
        return backtrack(startRow, startCol, -1, empty, grid);
    }
    
    private int backtrack(int row, int col, int count, int need, int[][] grid){
        final int NR = grid.length, NC = grid[0].length;
        if(row < 0 || row >= NR || col < 0 || col >= NC || grid[row][col] == -1) return 0;
        if(grid[row][col] == 2){
            if(count == need) return 1;
            else return 0;
        }
        
        grid[row][col] = -1;
        int total = 0;
        for(int d = 0; d < 4; d++){
            int r = row + DIRS[d], c = col + DIRS[d + 1];
            total += backtrack(r, c, count + 1, need, grid);
        }
        grid[row][col] = 0;
        return total;
    }
}