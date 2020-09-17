/**
 * https://leetcode.com/problems/check-if-it-is-a-straight-line/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 */
package com.zea7ot.leetcode.lvl2.lc1232;

public class SolutionApproach0Math {
    public boolean checkStraightLine(int[][] coordinates) {
        int x0 = coordinates[0][0];
        int y0 = coordinates[0][1];
        int x1 = coordinates[1][0];
        int y1 = coordinates[1][1];

        int dx = x1 - x0;
        int dy = y1 - y0;

        for (int[] coordinate : coordinates) {
            int x = coordinate[0], y = coordinate[1];
            if (dx * (y - y1) != dy * (x - x1)) {
                return false;
            }
        }

        return true;
    }
}