/**
 * https://leetcode.com/problems/range-sum-query-2d-immutable/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(1)
 * 
 * without extra space
 * 
 * References:
 *  https://leetcode.com/problems/range-sum-query-2d-immutable/discuss/75358/Clean-and-easy-to-understand-java-solution/78549
 *  https://leetcode.com/problems/range-sum-query-2d-immutable/discuss/75358/Clean-and-easy-to-understand-java-solution/289557
 */
package com.zea7ot.leetcode.lvl3.lc0304;

public class SolutionApproach0PrefixSums1 {
    private int[][] matrix;

    public SolutionApproach0PrefixSums1(int[][] matrix) {
        this.matrix = matrix;
        if (matrix.length == 0)
            return;
        final int NR = matrix.length, NC = matrix[0].length;
        for (int row = 0; row < NR; ++row) {
            for (int col = 0; col < NC; ++col) {
                matrix[row][col] += (col > 0 ? matrix[row][col - 1] : 0) + (row > 0 ? matrix[row - 1][col] : 0)
                        - (row > 0 && col > 0 ? matrix[row - 1][col - 1] : 0);
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return matrix[row2][col2] - (col1 > 0 ? matrix[row2][col1 - 1] : 0) - (row1 > 0 ? matrix[row1 - 1][col2] : 0)
                + (col1 > 0 && row1 > 0 ? matrix[row1 - 1][col1 - 1] : 0);
    }
}