/**
 * https://leetcode.com/problems/island-perimeter/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(1)
 */
package com.an7one.leetcode.lvl2.lc0463;

public class SolutionApproach0Geometry {
    public int islandPerimeter(int[][] grid) {
        // sanity check
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        final int NR = grid.length, NC = grid[0].length;

        int perimeter = 0;
        for (int row = 0; row < NR; ++row) {
            for (int col = 0; col < NC; ++col) {
                if (grid[row][col] == 1) {
                    perimeter += 4;
                    if (col > 0 && grid[row][col - 1] == 1)
                        perimeter -= 2;
                    if (row > 0 && grid[row - 1][col] == 1)
                        perimeter -= 2;
                }
            }
        }

        return perimeter;
    }
}