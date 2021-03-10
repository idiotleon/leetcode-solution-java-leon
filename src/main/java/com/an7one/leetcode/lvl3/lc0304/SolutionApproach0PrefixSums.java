/**
 * https://leetcode.com/problems/range-sum-query-2d-immutable/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(NR * NC)
 * 
 * References:
 *  https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/Immutable2DSumRangeQuery.java
 *  https://www.youtube.com/watch?v=PwDqpOMwg6U
 *  https://leetcode.com/problems/range-sum-query-2d-immutable/discuss/75358/Clean-and-easy-to-understand-java-solution/289557
 *  https://leetcode.com/problems/range-sum-query-2d-immutable/discuss/572648/JavaC%2B%2B-Prefix-sum-with-Picture-explain-Clean-code
 */
package com.an7one.leetcode.lvl3.lc0304;

public class SolutionApproach0PrefixSums {
    // padded prefix sums
    private int[][] prefixSums;

    public SolutionApproach0PrefixSums(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return;
        final int NR = matrix.length, NC = matrix[0].length;
        this.prefixSums = new int[NR + 1][NC + 1];
        for (int row = 1; row <= NR; ++row) {
            for (int col = 1; col <= NC; ++col) {
                prefixSums[row][col] = prefixSums[row - 1][col] + prefixSums[row][col - 1]
                        - prefixSums[row - 1][col - 1] + matrix[row - 1][col - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        ++row1;
        ++col1;
        ++row2;
        ++col2;

        return prefixSums[row2][col2] - prefixSums[row2][col1 - 1] - prefixSums[row1 - 1][col2]
                + prefixSums[row1 - 1][col1 - 1];
    }
}