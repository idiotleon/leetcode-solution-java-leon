/**
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 * 
 * Time Complexity:     O(NR * NC) + O(NR * NC * lg(NR * NC))
 * Space Complexity:    O(NR * NC)
 * 
 * a bottom-up approach
 * 
 * 
 * References:
 *  https://www.youtube.com/watch?v=yKr4iyQnBpY
 */
package com.zea7ot.leetcode.lvl4.lc0329;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SolutionApproach1DP2Dimen {
    private static final int[] DIRS = { 0, 1, 0, -1, 0 };

    public int longestIncreasingPath(int[][] matrix) {
        // sanity check
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        // boundaries of int[][] matrix
        final int NR = matrix.length, NC = matrix[0].length;

        int[][] dp = new int[NR][NC];
        for (int[] row : dp)
            Arrays.fill(row, 1);

        List<int[]> cells = new ArrayList<int[]>();
        for (int row = 0; row < NR; ++row)
            for (int col = 0; col < NC; ++col)
                cells.add(new int[] { matrix[row][col], row, col });

        Collections.sort(cells, (a, b) -> Integer.compare(b[0], a[0]));

        int ans = 0;
        for (int[] cell : cells) {
            int row = cell[1], col = cell[2];

            for (int d = 0; d < 4; ++d) {
                int r = row + DIRS[d], c = col + DIRS[d + 1];
                if (r < 0 || r >= NR || c < 0 || c >= NC || matrix[r][c] <= matrix[row][col])
                    continue;
                dp[row][col] = Math.max(dp[row][col], 1 + dp[r][c]);
            }

            ans = Math.max(ans, dp[row][col]);
        }

        return ans;
    }
}