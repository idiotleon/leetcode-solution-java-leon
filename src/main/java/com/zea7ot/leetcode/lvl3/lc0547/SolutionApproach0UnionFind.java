/**
 * https://leetcode.com/problems/friend-circles/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
package com.zea7ot.leetcode.lvl3.lc0547;

import java.util.Arrays;

public class SolutionApproach0UnionFind {
    public int findCircleNum(int[][] matrix) {
        // sanity check
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        final int N = matrix.length;
        int[] roots = new int[N];
        Arrays.fill(roots, -1);

        for (int row = 0; row < N; ++row)
            for (int col = 0; col < N; ++col)
                if (matrix[row][col] == 1 && row != col)
                    union(row, col, roots);

        int count = 0;
        for (int i = 0; i < N; ++i)
            if (roots[i] == -1)
                ++count;

        return count;
    }

    private void union(int x, int y, int[] roots) {
        int rootX = find(roots, x);
        int rootY = find(roots, y);
        if (rootX != rootY)
            roots[rootY] = rootX;
    }

    private int find(int[] roots, int i) {
        if (roots[i] == -1)
            return i;
        return find(roots, roots[i]);
    }
}