/**
 * https://leetcode.com/problems/spiral-matrix
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(NR * NC)
 */
package com.zea7ot.leetcode.lvl3.lc0054;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0LinearScan {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<Integer>();
        // sanity check
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return ans;

        final int NR = matrix.length, NC = matrix[0].length;

        int top = 0, bottom = NR - 1;
        int left = 0, right = NC - 1;

        while (true) {
            for (int col = left; col <= right; ++col) {
                ans.add(matrix[top][col]);
            }
            ++top;
            if (left > right || top > bottom)
                break;

            for (int row = top; row <= bottom; ++row) {
                ans.add(matrix[row][right]);
            }
            --right;
            if (left > right || top > bottom)
                break;

            for (int col = right; col >= left; --col) {
                ans.add(matrix[bottom][col]);
            }
            --bottom;
            if (left > right || top > bottom)
                break;

            for (int row = bottom; row >= top; --row) {
                ans.add(matrix[row][left]);
            }
            ++left;
            if (left > right || top > bottom)
                break;
        }

        return ans;
    }

    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();

        if (matrix.length == 0)
            return res;

        int rowBegin = 0, rowEnd = matrix.length - 1;
        int colBegin = 0, colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int j = colBegin; j <= colEnd; j++) {
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;

            for (int j = rowBegin; j <= rowEnd; j++) {
                res.add(matrix[j][colEnd]);
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                for (int j = colEnd; j >= colBegin; j--) {
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                for (int j = rowEnd; j >= rowBegin; j--) {
                    res.add(matrix[j][colBegin]);
                }
            }
            colBegin++;
        }

        return res;
    }
}