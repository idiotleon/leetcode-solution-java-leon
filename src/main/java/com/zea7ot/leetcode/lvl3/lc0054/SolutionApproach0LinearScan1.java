/**
 * https://leetcode.com/problems/spiral-matrix
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(NR * NC)
 */
package com.zea7ot.leetcode.lvl3.lc0054;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0LinearScan1 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<Integer>();
        // sanity check
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return ans;

        int rowBegin = 0, rowEnd = matrix.length - 1;
        int colBegin = 0, colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int j = colBegin; j <= colEnd; j++) {
                ans.add(matrix[rowBegin][j]);
            }
            rowBegin++;

            for (int j = rowBegin; j <= rowEnd; j++) {
                ans.add(matrix[j][colEnd]);
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                for (int j = colEnd; j >= colBegin; j--) {
                    ans.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                for (int j = rowEnd; j >= rowBegin; j--) {
                    ans.add(matrix[j][colBegin]);
                }
            }
            colBegin++;
        }

        return ans;
    }
}