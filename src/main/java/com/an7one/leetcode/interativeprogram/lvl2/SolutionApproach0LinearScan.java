/**
 * https://leetcode.com/problems/leftmost-column-with-at-least-a-one/
 * 
 * Time Copmlexity:     O(NR + NC) ~ O(max(NR, NC))
 * Space Complexity:    O(1)
 */
package com.an7one.leetcode.interativeprogram.lvl2;

import java.util.List;

public class SolutionApproach0LinearScan {
    public int leftMostColumnWithOne(FakeBinaryMatrix binaryMatrix) {
        final List<Integer> DIMEN = binaryMatrix.dimensions();
        final int NR = DIMEN.get(0);
        final int NC = DIMEN.get(1);

        int row = 0, col = NC - 1;
        while (row < NR && col >= 0) {
            if (binaryMatrix.get(row, col) == 1) {
                --col;
            } else {
                ++row;
            }
        }

        return col == NC - 1 ? -1 : col + 1;
    }
}
