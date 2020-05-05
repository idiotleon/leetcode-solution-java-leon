/**
 * https://leetcode.com/problems/island-perimeter/
 * 
 * Time Complexity: O(MN)
 * Space Complexity: O(1)
 */
package com.polyg7ot.lc.lvl2.lc0463;

public class SolutionApproachGeometry {
    public int islandPerimeter(int[][] grid) {
        // sanity check
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        int ans = 0;
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == 1){
                    ans += 4;
                    if(row > 0 && grid[row - 1][col] == 1) ans -= 2;
                    if(col > 0 && grid[row][col - 1] == 1) ans -= 2; 
                }
            }
        }
        
        return ans;
    }
}