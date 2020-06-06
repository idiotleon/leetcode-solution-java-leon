/**
 * https://leetcode.com/problems/bomb-enemy/
 * 
 * Time Complexity:     O(M * N * 4) ~ O(M * N)
 * Space Complexity:    O(M * N)
 * 
 * https://leetcode.com/problems/bomb-enemy/discuss/83383/Simple-DP-solution-in-Java/87624
 */
package com.polyg7ot.lc.lvl2.lc0361;

public class SolutionApproach0Scan {
    // not used
    // private static final char WALL = 'W';
    private static final char ENEMY = 'E';
    private static final char EMPTY = '0';

    private int NR, NC;
    
    private int max, count;
        
    public int maxKilledEnemies(char[][] grid) {
        // sanity check
        if(grid == null || grid.length == 0) return 0;
        
        // dimensions of the grid
        NR = grid.length;
        NC = grid[0].length;
        
        this.max = 0;
        this.count = 0;
        int[][] dp = new int[NR][NC];
        
        // to scan from top to down
        for(int row = 0; row < NR; row++){
            // to reset the counter
            count = 0;
            // to scan from left to right, from top to down
            for(int col = 0; col < NC; col++){
                calculate(grid, dp, row, col);
            }
            
            // to reset the counter
            count = 0;
            // to scan from right to right, from top to down
            for(int col = NC - 1; col >= 0; col--){
                calculate(grid, dp, row, col);
            }
        }
        
        // to scan from down to top
        for(int col = 0; col < NC; col++){
            // to reset the counter
            count = 0;
            // to scan from top to down, from left to right
            for(int row = 0; row < NR; row++){
                calculate(grid, dp, row, col);
            }
            
            // to reset the counter
            count = 0;
            // to scan from down to top, from left to right
            for(int row = NR - 1; row >= 0; row--){
                calculate(grid, dp, row, col);
            }
        }
        
        return max;
    }
    
    private void calculate(char[][] grid, int[][] dp, int row, int col){
        if(grid[row][col] == EMPTY){
            dp[row][col] += count;
            max = Math.max(max, dp[row][col]);
        }else if(grid[row][col] == ENEMY){
            count++;
        }else{
            count = 0;
        }
    }
}