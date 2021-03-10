/**
 * https://leetcode.com/problems/rotate-image/
 * 
 * how about ANTI-clockwise this time?
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/rotate-image/discuss/18872/A-common-method-to-rotate-the-image
 */
package com.an7one.leetcode.lvl3.lc0048.followups;

public class SolutionApproach0MatrixManipulation {
    public void rotate(int[][] matrix) {
        // sanity check
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;

        reverseAllColumns(matrix);
        transpose(matrix);
    }

    private void transpose(int[][] matrix) {
        final int NR = matrix.length;

        for (int row = 0; row < NR; ++row)
            for (int col = 0; col < row; ++col) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
    }

    private void reverseAllColumns(int[][] matrix) {
        final int NC = matrix[0].length;
        int lo = 0, hi = NC - 1;
        for (int[] row : matrix)
            while (lo < hi)
                swap(lo++, hi--, row);
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}