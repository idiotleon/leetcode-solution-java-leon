/**
 * https://leetcode.com/problems/rotate-image/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/rotate-image/discuss/18879/AC-Java-in-place-solution-with-explanation-Easy-to-understand.
 */
package com.idiotleon.leetcode.lvl3.lc0048;

public class SolutionApproach0MatrixManipulation1 {
    public void rotate(int[][] matrix) {
        // sanity check
        if (matrix == null || matrix.length == 0)
            return;

        final int NR = matrix.length, NC = matrix[0].length;

        for (int row = 0; row < NR; ++row) {
            for (int col = row; col < NC; ++col) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }

        for (int row = 0; row < NR; ++row) {
            for (int col = 0; col < NC / 2; ++col) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[row][NC - 1 - col];
                matrix[row][NC - 1 - col] = temp;
            }
        }
    }
}