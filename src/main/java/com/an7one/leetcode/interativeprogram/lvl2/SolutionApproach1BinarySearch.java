/**
 * https://leetcode.com/problems/leftmost-column-with-at-least-a-one/
 * 
 * Time Complexity:     O(NR * lg(NC))
 * Space Complexity:    O(1)
 */
package com.an7one.leetcode.interativeprogram.lvl2;

import java.util.List;

public class SolutionApproach1BinarySearch {
    public int leftMostColumnWithOne(FakeBinaryMatrix binaryMatrix) {
        final List<Integer> DIMEN = binaryMatrix.dimensions();
        final int NR = DIMEN.get(0);
        final int NC = DIMEN.get(1);

        int min = Integer.MAX_VALUE;
        for (int row = 0; row < NR; ++row) {
            int lo = 0, hi = NC - 1;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (binaryMatrix.get(row, mid) == 1)
                    hi = mid;
                else
                    lo = mid + 1;
            }

            if (binaryMatrix.get(row, lo) == 1)
                min = Math.min(min, lo);
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
