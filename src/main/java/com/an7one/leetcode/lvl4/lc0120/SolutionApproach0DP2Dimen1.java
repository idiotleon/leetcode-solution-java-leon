/**
 * https://leetcode.com/problems/triangle/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(1)
 */
package com.an7one.leetcode.lvl4.lc0120;

import java.util.List;

public class SolutionApproach0DP2Dimen1 {
    // to elaborate the above method
    public int minimumTotal(List<List<Integer>> triangle) {
        // sanity check
        if (triangle == null || triangle.isEmpty() || triangle.get(0).isEmpty())
            return 0;

        final int NR = triangle.size();
        for (int row = NR - 2; row >= 0; --row) {
            for (int col = 0; col <= row; ++col) {
                int self = triangle.get(row).get(col); // to get the [row](i + 1) & [col](j + 1)
                // to get the min value of adjacent values
                int res = Math.min(triangle.get(row + 1).get(col) + self, triangle.get(row + 1).get(col + 1) + self);
                triangle.get(row).set(col, res); // to update [row](i + 1) & [col](j + 1)
            }
        }

        return triangle.get(0).get(0);
    }
}