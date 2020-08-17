/**
 * https://leetcode.com/problems/pascals-triangle/
 * 
 * Time Complexity:     O(numRows ^ 2)
 * Space Complexity:    O(numRows ^ 2)
 */
package com.zea7ot.leetcode.lvl2.lc0118;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0DP2Dimen {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> allRows = new ArrayList<List<Integer>>();
        // sanity check
        if (numRows < 0)
            return allRows;

        List<Integer> oneRow = new ArrayList<Integer>();

        for (int row = 0; row < numRows; ++row) {
            oneRow.add(0, 1);
            for (int col = 1; col < oneRow.size() - 1; ++col)
                oneRow.set(col, oneRow.get(col) + oneRow.get(col + 1));

            allRows.add(new ArrayList<Integer>(oneRow));
        }

        return allRows;
    }
}
