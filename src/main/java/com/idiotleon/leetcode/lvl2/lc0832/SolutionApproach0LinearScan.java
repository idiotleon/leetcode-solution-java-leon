/**
 * @author: Leon
 * https://leetcode.com/problems/flipping-an-image/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(1)
 */
package com.idiotleon.leetcode.lvl2.lc0832;

public class SolutionApproach0LinearScan {
    public int[][] flipAndInvertImage(int[][] matrix) {
        // sanity check
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return matrix;

        reverseRows(matrix);
        flip(matrix);

        return matrix;
    }

    private void flip(int[][] matrix) {
        final int NR = matrix.length, NC = matrix[0].length;

        for (int row = 0; row < NR; ++row)
            for (int col = 0; col < NC; ++col)
                if (matrix[row][col] == 1)
                    matrix[row][col] = 0;
                else
                    matrix[row][col] = 1;
    }

    private void reverseRows(int[][] matrix) {
        for (int[] row : matrix) {
            final int NC = row.length;
            int lo = 0, hi = NC - 1;
            while (lo < hi)
                swap(lo++, hi--, row);
        }
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}