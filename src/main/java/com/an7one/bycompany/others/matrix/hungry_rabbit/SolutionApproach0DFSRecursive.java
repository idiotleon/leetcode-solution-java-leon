/**
 * There is a rabbit that starts in the middle of an n x m matrix, n > 0, m > 0.
 * Each element of a matrix is an integer representing points gained for being on the spot. 
 * If there are multiple possible "middles" then choose the one which has the highest point value to start on. 
 * 
 * On each iteration, the rabbit can move up, left, right, or down. 
 * The rabbit will always move to the next spot with the highest point value 
 * and will "consume" those points (set the point value in that position to 0). 
 * The rabbit spots when all positions around it are 0s. 
 * 
 * Calculate how many points the rabbit will score for a given m x n matrix.
 * 
 * Example 1: 
 *  [[5, 7, 8, 6, 3],
 *   [0, 0, 7, 0, 4],
 *   [4, 6, 3, 4, 9],
 *   [3, 1, 0, 5, 8]]
 * 
 * Expected: 27
 */
package com.an7one.bycompany.others.matrix.hungry_rabbit;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0DFSRecursive {
    private static final int[] DIRS = { 0, -1, 0, 1, 0 };

    public int greedilyEatCarrots(int[][] matrix) {
        // sanity check
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        final int[] MOST = { 0 };

        int[] start = getStart(matrix);

        greedySearch(start, 0, MOST, matrix);

        return MOST[0];
    }

    private void greedySearch(int[] curPos, int cur, final int[] MOST, int[][] matrix) {

        int row = curPos[0], col = curPos[1];
        cur += matrix[row][col];
        matrix[row][col] = -matrix[row][col];
        MOST[0] = Math.max(MOST[0], cur);

        List<int[]> nextPos = getSurroundingMaxes(row, col, matrix);
        for (int[] next : nextPos) {
            if (matrix[next[0]][next[1]] > 0) {
                greedySearch(next, cur, MOST, matrix);
            }
        }
    }

    private List<int[]> getSurroundingMaxes(int row, int col, int[][] matrix) {
        final int NR = matrix.length, NC = matrix[0].length;

        List<int[]> res = new ArrayList<>();

        int max = Integer.MIN_VALUE;

        for (int d = 0; d < 4; ++d) {
            int nr = row + DIRS[d], nc = col + DIRS[d + 1];
            if (nr < 0 || nr >= NR || nc < 0 || nc >= NC || matrix[nr][nc] <= 0)
                continue;

            if (matrix[nr][nc] > max) {
                res.clear();
                res.add(new int[] { nr, nc });
                max = matrix[nr][nc];
            } else if (matrix[nr][nc] == max) {
                res.add(new int[] { nr, nc });
            }
        }

        return res;
    }

    private int[] getStart(int[][] matrix) {
        final int NR = matrix.length, NC = matrix[0].length;

        int[] rows = null;
        if (NR % 2 == 0) {
            rows = new int[] { NR / 2 - 1, NR / 2 };
        } else {
            rows = new int[] { NR / 2 };
        }

        int[] cols = null;
        if (NC % 2 == 0) {
            cols = new int[] { NC / 2 - 1, NC / 2 };
        } else {
            cols = new int[] { NC / 2 };
        }

        int r = rows[0], c = cols[0];
        for (int row : rows) {
            for (int col : cols) {
                if (matrix[row][col] > matrix[r][c]) {
                    r = row;
                    c = col;
                }
            }
        }

        return new int[] { r, c };
    }
}
