/**
 * https://leetcode.com/problems/number-of-corner-rectangles/
 * 
 * Time Complexity:     O((NR ^ 2) * NC)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/number-of-corner-rectangles/discuss/110196/short-JAVA-AC-solution-(O(m2-*-n))-with-explanation./111894
 *  https://leetcode.com/problems/number-of-corner-rectangles/discuss/110196/short-JAVA-AC-solution-(O(m2-*-n))-with-explanation.
 *  https://leetcode.com/problems/number-of-corner-rectangles/discuss/110200/Summary-of-three-solutions-based-on-three-different-ideas
 */
package com.an7one.leetcode.lvl3.lc0750;

public class SolutionApproach0Geometry1 {
    public int countCornerRectangles(int[][] grid) {
        final int NR = grid.length, NC = grid[0].length;
        int ans = 0;

        for (int row1 = 0; row1 < NR - 1; ++row1) {
            for (int row2 = row1 + 1; row2 < NR; ++row2) {
                int counter = 0;
                for (int col = 0; col < NC; ++col) {
                    if (grid[row1][col] + grid[row2][col] == 2)
                        ans += counter++;
                }
            }
        }

        return ans;
    }
}