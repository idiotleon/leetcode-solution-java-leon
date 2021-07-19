package com.an7one.leetcode.lvl3.lc0073;

import com.an7one.util.Constant;

/**
 * https://leetcode.com/problems/set-matrix-zeroes/
 * <p>
 * Time Complexity:     O(`NR` * `NC`)
 * Space Complexity:    O(1)
 * <p>
 * Reference:
 * https://leetcode.com/problems/set-matrix-zeroes/discuss/26014/Any-shorter-O(1)-space-solution
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0MatrixManipulation {
    public void setZeroes(int[][] matrix) {
        final int NR = matrix.length, NC = matrix[0].length;
        boolean firstRow = false, firstCol = false;

        for (int row = 0; row < NR; row++) {
            for (int col = 0; col < NC; col++) {
                if (matrix[row][col] == 0) {
                    if (row == 0) firstRow = true;
                    if (col == 0) firstCol = true;
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                }
            }
        }

        for (int row = 1; row < NR; row++) {
            for (int col = 1; col < NC; col++) {
                if (matrix[row][0] == 0 || matrix[0][col] == 0)
                    matrix[row][col] = 0;
            }
        }

        if (firstRow)
            for (int col = 0; col < NC; col++) {
                matrix[0][col] = 0;
            }

        if (firstCol)
            for (int row = 0; row < NR; row++) {
                matrix[row][0] = 0;
            }
    }
}