package com.idiotleon.leetcode.interativeprogram.lvl2;

import com.idiotleon.util.Constant;

import java.util.List;

/**
 * https://leetcode.com/problems/leftmost-column-with-at-least-a-one/
 * <p>
 * Time Complexity:     O(`NR` + `NC`) ~ O(max(`NR`, `NC`))
 * Space Complexity:    O(1)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
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
