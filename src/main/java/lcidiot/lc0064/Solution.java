/**
 * https://leetcode.com/problems/minimum-path-sum/
 */

package main.java.lcidiot.lc0064;

class Solution {
    /**
     * O(n * n)
     */
    public int minPathSum(int[][] grid) {
        int nr = grid.length, nc = grid[0].length;
        // to initialize the first row
        for(int col = 1; col < nc; col++)
            grid[0][col] += grid[0][col - 1];
        
        // to initialize the first column
        for(int row = 1; row < nr; row++)
            grid[row][0] += grid[row - 1][0];
        
        // to deal with the rest
        for(int row = 1; row < nr; row++)
            for(int col = 1; col < nc; col++)
                grid[row][col] += Math.min(grid[row][col - 1], grid[row - 1][col]);
            
        return grid[nr - 1][nc - 1];
    }

    /**
     * O(n)
     */
    public int minPathSum2(int[][] grid) {
        int width = grid[0].length;
        
        int[] dp = new int[width];
        for(int i = 1; i < width; i++)
            dp[i] = Integer.MAX_VALUE;
        
        for(int[] row : grid)
            for(int i = 0; i < width; i++)
                if(i == 0) dp[i] += row[i];
                else dp[i] = row[i] + Math.min(dp[i - 1], dp[i]);
        
        return dp[width - 1];
    }
}