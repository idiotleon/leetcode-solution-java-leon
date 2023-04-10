/**
 * https://leetcode.com/problems/rotate-image/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/rotate-image/discuss/18872/A-common-method-to-rotate-the-image
 */
package com.idiotleon.leetcode.lvl3.lc0048;

public class SolutionApproach0MatrixManipulation {
    public void rotate(int[][] matrix) {
        // sanity check
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;

        // the orders of the two lines below matter
        reverseRows(matrix);
        transpose(matrix);
    }

    private void transpose(int[][] matrix) {
        final int NR = matrix.length, NC = matrix[0].length;

        for (int row = 0; row < NR; ++row)
            for (int col = row + 1; col < NC; ++col) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
    }

    private void reverseRows(int[][] matrix) {
        final int NR = matrix.length;
        int lo = 0, hi = NR - 1;
        while (lo < hi) {
            int[] temp = matrix[lo];
            matrix[lo] = matrix[hi];
            matrix[hi] = temp;

            ++lo;
            --hi;
        }
    }
}