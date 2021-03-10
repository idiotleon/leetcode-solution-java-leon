/**
 * https://leetcode.com/problems/minimum-number-of-flips-to-convert-binary-matrix-to-zero-matrix/
 * 
 * Time Complexity:     O(`NR` * `NC` * (2 ^ (`NR` * `NC`)))
 * Space Complexity:    O(2 ^ (`NR` * `NC`))
 * 
 * References:
 *  https://leetcode.com/problems/minimum-number-of-flips-to-convert-binary-matrix-to-zero-matrix/discuss/446342/JavaPython-3-Convert-matrix-to-int%3A-BFS-and-DFS-codes-w-explanation-comments-and-analysis.
 */
package com.an7one.leetcode.lvl4.lc1284.with_bitmask;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class SolutionApproach0BFS {
    private static final int[] DIRS = { 0, 0, -1, 0, 1, 0 };

    public int minFlips(int[][] matrix) {
        final int NR = matrix.length, NC = matrix[0].length;
        int bitMask = 0;
        for (int row = 0; row < NR; ++row) {
            for (int col = 0; col < NC; ++col) {
                bitMask |= matrix[row][col] << (row * NC + col);
            }
        }

        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(bitMask);

        final Set<Integer> SEEN = new HashSet<>();
        SEEN.add(bitMask);

        int steps = 0;

        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int sz = 0; sz < SIZE; ++sz) {
                int cur = queue.poll();
                if (cur == 0)
                    return steps;

                for (int row = 0; row < NR; ++row) {
                    for (int col = 0; col < NC; ++col) {
                        int next = cur;

                        // to flip all 4 surroudings if there are, as well as itself
                        for (int d = 0; d < 5; ++d) {
                            int nextRow = row + DIRS[d], nextCol = col + DIRS[d + 1];
                            if (nextRow < 0 || nextRow >= NR || nextCol < 0 || nextCol >= NC)
                                continue;
                            next ^= 1 << (nextRow * NC + nextCol);
                        }

                        if (!SEEN.add(next))
                            continue;
                        queue.offer(next);
                    }
                }
            }

            ++steps;
        }

        return -1;
    }
}
