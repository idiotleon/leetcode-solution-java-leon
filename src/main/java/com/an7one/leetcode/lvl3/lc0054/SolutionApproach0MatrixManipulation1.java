package com.an7one.leetcode.lvl3.lc0054;

import com.an7one.util.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/spiral-matrix">LC0054</a>
 * <p>
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(NR * NC)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0MatrixManipulation1 {
    public List<Integer> spiralOrder(int[][] matrix) {
        final List<Integer> ans = new ArrayList<>();
        // sanity check
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return ans;

        int rowBegin = 0, rowEnd = matrix.length - 1;
        int colBegin = 0, colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int col = colBegin; col <= colEnd; ++col) {
                ans.add(matrix[rowBegin][col]);
            }
            ++rowBegin;

            for (int row = rowBegin; row <= rowEnd; ++row) {
                ans.add(matrix[row][colEnd]);
            }
            --colEnd;

            if (rowBegin <= rowEnd) {
                for (int col = colEnd; col >= colBegin; --col) {
                    ans.add(matrix[rowEnd][col]);
                }
            }
            --rowEnd;

            if (colBegin <= colEnd) {
                for (int row = rowEnd; row >= rowBegin; --row) {
                    ans.add(matrix[row][colBegin]);
                }
            }
            colBegin++;
        }

        return ans;
    }
}