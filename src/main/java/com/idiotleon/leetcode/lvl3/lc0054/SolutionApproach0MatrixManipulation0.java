package com.idiotleon.leetcode.lvl3.lc0054;

import com.idiotleon.util.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/spiral-matrix">LC0054</a>
 * <p>
 * Time Complexity:     O(`NR` * `NC`)
 * Space Complexity:    O(`NR` * `NC`)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0MatrixManipulation0 {
    public List<Integer> spiralOrder(int[][] matrix) {
        final List<Integer> ans = new ArrayList<>();
        // sanity check
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }

        final int NR = matrix.length, NC = matrix[0].length;

        int top = 0, bottom = NR - 1;
        int left = 0, right = NC - 1;

        while (true) {
            for (int col = left; col <= right; ++col) {
                ans.add(matrix[top][col]);
            }
            ++top;
            if (left > right || top > bottom) break;

            for (int row = top; row <= bottom; ++row) {
                ans.add(matrix[row][right]);
            }
            --right;
            if (left > right || top > bottom) break;

            for (int col = right; col >= left; --col) {
                ans.add(matrix[bottom][col]);
            }
            --bottom;
            if (left > right || top > bottom) break;

            for (int row = bottom; row >= top; --row) {
                ans.add(matrix[row][left]);
            }
            ++left;
            if (left > right || top > bottom) break;
        }

        return ans;
    }
}