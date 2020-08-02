/**
 * https://leetcode.com/problems/triangle/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(1)
 */
package com.zea7ot.lc.lvl4.lc0120;

import java.util.List;

public class SolutionApproach0DP2Dimen {
    public int minimumTotal(List<List<Integer>> triangle) {
        // sanity check
        if (triangle == null || triangle.isEmpty())
            return 0;

        final int NR = triangle.size();
        for (int row = NR - 2; row >= 0; --row) {
            for (int col = 0; col <= row; ++col) {
                triangle.get(row).set(col, triangle.get(row).get(col)
                        + Math.min(triangle.get(row + 1).get(col), triangle.get(row + 1).get(col + 1)));
            }
        }

        return triangle.get(0).get(0);
    }
}