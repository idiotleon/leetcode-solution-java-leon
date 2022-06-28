package com.an7one.leetcode.lvl3.lc0200;

import com.an7one.util.Constant;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/number-of-islands/">LC0200</a>
 * <p>
 * Time Complexity:     O(`NR` * `NC`)
 * Space Complexity:    O(`NR` * `NC`)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0UnionFind {
    private final int[] DIRS = {0, -1, 0, 1, 0};

    private static final char WATER = '0';
    private static final char LAND = '1';

    public int numIslands(char[][] grid) {
        // sanity check, not required
        // if (grid == null || grid.length == 0)
        // return 0;

        final int NR = grid.length, NC = grid[0].length;

        UnionFind uf = new UnionFind(grid);
        for (int row = 0; row < NR; ++row) {
            for (int col = 0; col < NC; ++col) {
                if (grid[row][col] == LAND) {
                    grid[row][col] = WATER;

                    for (int d = 0; d < 4; ++d) {
                        int nextRow = row + DIRS[d], nextCol = col + DIRS[d + 1];
                        if (nextRow < 0 || nextCol < 0 || nextRow >= NR || nextCol >= NC
                                || grid[nextRow][nextCol] == WATER)
                            continue;

                        uf.union(row * NC + col, nextRow * NC + nextCol);
                    }
                }
            }
        }

        return uf.getIslandsCount();
    }

    private static class UnionFind {
        private int isolated;
        private final int[] ROOTS, RANKS;

        protected UnionFind(char[][] grid) {
            final int NR = grid.length, NC = grid[0].length;
            this.ROOTS = new int[NR * NC];
            this.RANKS = new int[NR * NC];

            for (int row = 0; row < NR; row++) {
                for (int col = 0; col < NC; col++) {
                    if (grid[row][col] == LAND) {
                        ROOTS[row * NC + col] = row * NC + col;
                        ++isolated;
                    }

                    RANKS[row * NC + col] = 1;
                }
            }
        }

        // union by ranks
        protected void union(int x, int y) {
            int rootx = find(x), rooty = find(y);
            if (rootx != rooty) {
                if (RANKS[rootx] > RANKS[rooty]) {
                    ROOTS[rooty] = rootx;
                } else if (RANKS[rootx] < RANKS[rooty]) {
                    ROOTS[rootx] = rooty;
                } else {
                    ROOTS[rooty] = rootx;
                    RANKS[rootx] += 1;
                }

                --isolated;
            }
        }

        protected int find(int i) {
            // path compression
            if (ROOTS[i] != i) {
                ROOTS[i] = find(ROOTS[i]);
            }

            return ROOTS[i];
        }

        protected int getIslandsCount() {
            return isolated;
        }
    }
}