/**
 * https://leetcode.com/problems/minimum-path-sum/
 * 
 * Time Complexity: O(M * N)
 * Space Complexity: O(N), width of grid
 */
package com.zea7ot.lc.lvl2.lc0064;

public class SolutionApproachDP {
    public int minPathSum(int[][] grid) {
        // sanity check
        if(grid == null || grid.length == 0) return 0;

        final int WIDTH = grid[0].length;
        int[] dp = new int[WIDTH];
        for(int i = 1; i < WIDTH; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        
        for(int[] row : grid){
            for(int i = 0; i < WIDTH; i++){
                if(i == 0) dp[i] += row[i];
                else dp[i] = row[i] + Math.min(dp[i - 1], dp[i]);
            }
        }
        
        return dp[WIDTH - 1];
    }
}