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
import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0DFS {
    private static final int[] DIRS = { 0, 0, -1, 0, 1, 0 };

    public int minFlips(int[][] matrix) {
        final int NR = matrix.length, NC = matrix[0].length;
        int bitMask = 0;
        for (int row = 0; row < NR; ++row) {
            for (int col = 0; col < NC; ++col) {
                bitMask |= matrix[row][col] << (row * NC + col);
            }
        }

        Deque<State> stack = new ArrayDeque<>();
        stack.push(new State(bitMask, 0));

        final Map<Integer, Integer> SEEN = new HashMap<>();
        SEEN.put(bitMask, 0);

        while (!stack.isEmpty()) {
            State top = stack.pop();
            int cur = top.bitMask;
            int steps = top.steps;

            for (int row = 0; row < NR; ++row) {
                for (int col = 0; col < NC; ++col) {
                    int next = cur;

                    for (int d = 0; d < 5; ++d) {
                        int nextRow = row + DIRS[d], nextCol = col + DIRS[d + 1];
                        if (nextRow < 0 || nextRow >= NR || nextCol < 0 || nextCol >= NC)
                            continue;
                        next ^= 1 << (nextRow * NC + nextCol);
                    }

                    if (SEEN.getOrDefault(next, Integer.MAX_VALUE) > 1 + steps) {
                        SEEN.put(next, 1 + steps);
                        stack.push(new State(next, 1 + steps));
                    }
                }

            }
        }

        return SEEN.getOrDefault(0, -1);
    }

    private class State {
        private int bitMask;
        private int steps;

        private State(int bitMask, int steps) {
            this.bitMask = bitMask;
            this.steps = steps;
        }
    }
}
