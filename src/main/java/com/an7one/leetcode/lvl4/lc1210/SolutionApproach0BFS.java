/**
 * https://leetcode.com/problems/minimum-moves-to-reach-target-with-rotations/
 * 
 * Time Complexity:     O(`N` ^ 2)
 * Space Complexity:    O(`N` ^ 2)
 * 
 * References:
 *  https://leetcode.com/problems/minimum-moves-to-reach-target-with-rotations/discuss/393511/JavaPython-3-25-and-17-liner-clean-BFS-codes-w-brief-explanation-and-analysis.
 */
package com.an7one.leetcode.lvl4.lc1210;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class SolutionApproach0BFS {
    private static final int EMPTY = 0;

    // not used
    // private static final int BLOCKED = 1;

    public int minimumMoves(int[][] grid) {
        final int N = grid.length;

        State start = new State(0, 0, Facing.RIGHT);
        State target = new State(N - 1, N - 2, Facing.RIGHT);

        Deque<State> queue = new ArrayDeque<>();
        queue.offer(start);

        final Set<String> SEEN = new HashSet<>();

        int steps = 0;

        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int sz = 0; sz < SIZE; ++sz) {
                State cur = queue.poll();
                if (cur.equals(target))
                    return steps;

                if (!SEEN.add(cur.toHash()))
                    continue;

                int row = cur.row;
                int col = cur.col;
                Facing dir = cur.dir;

                if (dir == Facing.RIGHT) {
                    if (row + 1 < N && grid[row + 1][col] == EMPTY && grid[row + 1][col + 1] == EMPTY) {
                        queue.offer(new State(row, col, Facing.DOWN));
                        queue.offer(new State(row + 1, col, Facing.RIGHT));
                    }

                    if (col + 2 < N && grid[row][col + 2] == EMPTY) {
                        queue.offer(new State(row, col + 1, Facing.RIGHT));
                    }
                }

                if (dir == Facing.DOWN) {
                    if (col + 1 < N && grid[row][col + 1] == EMPTY && grid[row + 1][col + 1] == EMPTY) {
                        queue.offer(new State(row, col, Facing.RIGHT));
                        queue.offer(new State(row, col + 1, Facing.DOWN));
                    }

                    if (row + 2 < N && grid[row + 2][col] == EMPTY) {
                        queue.offer(new State(row + 1, col, Facing.DOWN));
                    }
                }
            }

            ++steps;
        }

        return -1;
    }

    private class State {
        private int row;
        private int col;
        private Facing dir;

        private State(int row, int col, Facing dir) {
            this.row = row;
            this.col = col;
            this.dir = dir;
        }

        private String toHash() {
            return "" + row + "#" + col + "#" + dir;
        }

        @Override
        public boolean equals(Object obj) {
            try {
                State that = (State) obj;

                return this.row == that.row && this.col == that.col && this.dir == that.dir;
            } catch (Exception ex) {
                return false;
            }
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }
    }

    private enum Facing {
        DOWN, RIGHT
    }
}
