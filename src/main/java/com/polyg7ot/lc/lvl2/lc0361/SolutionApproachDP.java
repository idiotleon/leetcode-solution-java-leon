/**
 * https://leetcode.com/problems/bomb-enemy/
 * 
 * Time Complexity: O(M * N * 2) ~ O(M * N)
 * Space Complexity: O(M * N * 2) ~ O(M * N)
 */
package com.polyg7ot.lc.lvl2.lc0361;

public class SolutionApproachDP {
    private static final char WALL = 'W';
    private static final char ENEMY = 'E';
    private static final char EMPTY = '0';

    private int NR, NC;
        
    public int maxKilledEnemies(char[][] grid) {
        // sanity check
        if(grid == null || grid.length == 0) return 0;
        
        // dimensions of the grid
        NR = grid.length;
        NC = grid[0].length;
        
        int maxEnemies = 0;
        
        // the position where max enemies killed happens
        // not required to return
        int[] posMaxEnemies = new int[2];
        
        int[][][] dp = new int[NR][NC][2];
        // to scan from top-left to bottom-right
        // only to consider left-col and top-row
        for(int row = 0; row < NR; row++){
            for(int col = 0; col < NC; col++){
                int[] count = new int[2];
                if(grid[row][col] == WALL){
                    count[0] = 0;
                    count[0] = 0;
                }else if(grid[row][col] == EMPTY){
                    // to update the value based on the top row
                    if(row == 0) count[0] = 0;
                    else count[0] = dp[row - 1][col][0];
                    
                    // to update the value based on the left column
                    if(col == 0) count[1] = 0;
                    else count[1] = dp[row][col - 1][1];
                }else if(grid[row][col] == ENEMY){
                    // to update the value based on the top row
                    if(row == 0) count[0] = 1;
                    else count[0] = dp[row - 1][col][0] + 1;
                    
                    // to update the column based on the left column
                    if(col == 0) count[1] = 1;
                    else count[1] = dp[row][col - 1][1] + 1;
                }
                
                dp[row][col] = count;
            }
        }
        
        // to scan from bottom-right to top-left
        // only to consider right-column and down-row
        for(int row = NR - 1; row >= 0; row--){
            for(int col = NC - 1; col >= 0; col--){
                if(grid[row][col] == WALL) continue;
                
                if(row < NR - 1){
                    // to update the value based on the down row
                    dp[row][col][0] = Math.max(dp[row][col][0], dp[row + 1][col][0]);
                }
                
                if(col < NC - 1){
                    // to update the value based on the right column
                    dp[row][col][1] = Math.max(dp[row][col][1], dp[row][col + 1][1]);
                }
                
                if(grid[row][col] == EMPTY){
                    int enemies = dp[row][col][0] + dp[row][col][1];
                    if(enemies > maxEnemies){
                        maxEnemies = enemies;
                        posMaxEnemies[0] = row;
                        posMaxEnemies[1] = col;
                    }
                }
            }
        }
        
        return maxEnemies;
    }
}