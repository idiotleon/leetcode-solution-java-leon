/**
 * https://leetcode.com/problems/path-with-maximum-gold/
 * 
 * Time Complexity:     O(4 * (3 ^ k))
 *  k, number of cells with gold
 * 
 * Space Complexity:    O(k)
 *  k, consumed by the call stacks
 * 
 * References:
 *  https://leetcode.com/problems/path-with-maximum-gold/discuss/398388/JavaC%2B%2BPython-DFS-Backtracking-Clean-code-O(4*3k)
 */
package com.zea7ot.leetcode.lvl3.lc1219;

public class SolutionApproach0Backtrack {
    private static final int[] DIRS = {0, -1, 0, 1, 0};
    
    public int getMaximumGold(int[][] grid) {
        // sanity check
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        final int NR = grid.length, NC = grid[0].length;
        
        int maxGold = 0;
        for(int row = 0; row < NR; row++){
            for(int col = 0; col < NC; col++){
                maxGold = Math.max(maxGold, findMaxGold(row, col, grid));
            }
        }
        
        return maxGold;
    }
    
    private int findMaxGold(int row, int col, int[][] grid){
        final int NR = grid.length, NC = grid[0].length;
        if(row < 0 || row >= NR || col < 0 || col >= NC || grid[row][col] == 0) return 0;
        int origin = grid[row][col];
        grid[row][col] = 0;
        int maxGold = 0;
        for(int d = 0; d < 4; d++){
            int r = row + DIRS[d], c = col + DIRS[d + 1];
            maxGold = Math.max(maxGold, findMaxGold(r, c, grid));
        }
        grid[row][col] = origin;
        return maxGold + origin;
    }
}