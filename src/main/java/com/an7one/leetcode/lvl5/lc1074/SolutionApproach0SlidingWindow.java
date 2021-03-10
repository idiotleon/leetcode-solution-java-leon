/**
 * https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/
 *
 * Time Complexity:     O(`NR` * (`NC` ^ 2))
 * Space Complexity:    O(`NC`)
 *
 * References:
 *  https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/discuss/303750/JavaC%2B%2BPython-Find-the-Subarray-with-Target-Sum
 */
package com.an7one.leetcode.lvl5.lc1074;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0SlidingWindow {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        final int NR = matrix.length, NC = matrix[0].length;

        int[][] prefixSums = new int[NR][NC];
        for (int row = 0; row < NR; ++row) {
            for (int col = 0; col < NC; ++col) {
                prefixSums[row][col] += matrix[row][col];
                if (col > 0)
                    prefixSums[row][col] += prefixSums[row][col - 1];
            }
        }

        Map<Integer, Integer> freqs = new HashMap<>();
        int count = 0;

        for (int loCol = 0; loCol < NC; ++loCol) {
            for (int hiCol = loCol; hiCol < NC; ++hiCol) {
                freqs.clear();

                freqs.put(0, 1);

                int sum = 0;
                for (int row = 0; row < NR; ++row) {
                    sum += prefixSums[row][hiCol] - (loCol > 0 ? prefixSums[row][loCol - 1] : 0);
                    count += freqs.getOrDefault(sum - target, 0);
                    freqs.put(sum, 1 + freqs.getOrDefault(sum, 0));
                }
            }
        }

        return count;
    }
}
