/**
 * https://leetcode.com/problems/number-of-islands/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(NR * NC)
 */
package com.zea7ot.lc.lvl3.lc0200;

public class SolutionApproach0UnionFind {
    private final int[][] DIRS = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int numIslands(char[][] grid) {
        // sanity check
        if (grid == null || grid.length == 0)
            return 0;

        int NR = grid.length, NC = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for (int row = 0; row < NR; row++) {
            for (int col = 0; col < NC; col++) {
                if (grid[row][col] == '1') {
                    grid[row][col] = '0';

                    for (int[] dir : DIRS) {
                        int r = row + dir[0], c = col + dir[1];
                        if (r >= 0 && c >= 0 && r < NR && c < NC && grid[r][c] == '1') {
                            uf.union(row * NC + col, r * NC + c);
                        }
                    }
                }
            }
        }

        return uf.getCount();
    }

    private class UnionFind {
        private int count;
        private int[] parent, rank;

        protected UnionFind(char[][] grid) {
            final int NR = grid.length, NC = grid[0].length;
            parent = new int[NR * NC];
            rank = new int[NR * NC];

            for (int row = 0; row < NR; row++) {
                for (int col = 0; col < NC; col++) {
                    if (grid[row][col] == '1') {
                        parent[row * NC + col] = row * NC + col;
                        ++count;
                    }

                    rank[row * NC + col] = 0;
                }
            }
        }

        // union by rank
        protected void union(int x, int y) {
            int rootx = find(x), rooty = find(y);
            if (rootx != rooty) {
                if (rank[rootx] > rank[rooty]) {
                    parent[rooty] = rootx;
                } else if (rank[rootx] < rank[rooty]) {
                    parent[rootx] = rooty;
                } else {
                    parent[rooty] = rootx;
                    rank[rootx] += 1;
                }

                --count;
            }
        }

        protected int find(int i) {
            // path compression
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }

            return parent[i];
        }

        protected int getCount() {
            return count;
        }
    }
}