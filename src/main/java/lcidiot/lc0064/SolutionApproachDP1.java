/**
 * https://leetcode.com/problems/minimum-path-sum/
 * 
 * Time Complexity: O(M * N)
 * Space Complexity: O(M * N)
 */
package main.java.lcidiot.lc0064;

public class SolutionApproachDP1 {
    public int minPathSum2(int[][] grid) {
        // sanity check
        if(grid == null || grid.length == 0) return 0;
        
        int nr = grid.length, nc = grid[0].length;

        // to initialize the first row
        for(int col = 1; col < nc; col++){
            grid[0][col] += grid[0][col - 1];
        }
        
        // to initialize the first column
        for(int row = 1; row < nr; row++){
            grid[row][0] += grid[row - 1][0];
        }
        
        // to deal with the rest
        for(int row = 1; row < nr; row++){
            for(int col = 1; col < nc; col++){
                grid[row][col] += Math.min(grid[row][col - 1], grid[row - 1][col]);
            }
        }
            
        return grid[nr - 1][nc - 1];
    }
}