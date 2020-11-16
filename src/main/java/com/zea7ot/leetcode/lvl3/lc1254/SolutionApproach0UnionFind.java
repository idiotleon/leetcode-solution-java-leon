/**
 * https://leetcode.com/problems/number-of-closed-islands/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/number-of-closed-islands/discuss/426294/JavaPython-3-DFS-BFS-and-Union-Find-codes-w-brief-explanation-and-analysis.
 */
package com.zea7ot.leetcode.lvl3.lc1254;

public class SolutionApproach0UnionFind {
    private static final int[] DIRS = { 0, -1, 0, 1, 0 };
    private int[] roots;
    private int NR, NC;

    public int closedIsland(int[][] grid) {
        // sanity check
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        NR = grid.length;
        NC = grid[0].length;

        roots = new int[NR * NC];
        for (int row = 0; row < NR; ++row) {
            for (int col = 0; col < NC; ++col) {
                roots[hash(row, col)] = hash(row, col);
            }
        }

        for (int row = 1; row < NR - 1; row++) {
            for (int col = 1; col < NC - 1; col++) {
                if (grid[row][col] == 0) {
                    for (int d = 0; d < 4; d++) {
                        int r = row + DIRS[d], c = col + DIRS[d + 1];
                        if (grid[r][c] == 0) {
                            union(hash(row, col), hash(r, c));
                        }
                    }
                }
            }
        }

        int count = 0;
        for (int row = 1; row < NR - 1; row++) {
            for (int col = 1; col < NC - 1; col++) {
                if (grid[row][col] == 0 && roots[hash(row, col)] == hash(row, col)) {
                    count++;
                }
            }
        }

        return count;
    }

    private int find(int x) {
        while (x != roots[x])
            x = roots[x];
        return x;
    }

    private void union(int x, int y) {
        int rootX = find(x), rootY = find(y);
        if (rootX == rootY)
            return;
        if (isBoundary(rootY))
            roots[rootX] = rootY;
        else
            roots[rootY] = rootX;
    }

    private boolean isBoundary(int id) {
        int row = id / NC, col = id % NC;
        return row == 0 || col == 0 || row == NR - 1 || col == NC - 1;
    }

    private int hash(int row, int col) {
        return row * NC + col;
    }
}