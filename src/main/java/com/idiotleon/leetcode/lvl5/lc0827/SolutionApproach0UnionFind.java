package com.idiotleon.leetcode.lvl5.lc0827;

import com.idiotleon.util.Constant;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/making-a-large-island/
 * <p>
 * Time Complexity:     O()
 * Space Complexity:    O()
 * <p>
 * References:
 * https://leetcode.com/problems/making-a-large-island/discuss/127980/Java-Solution-using-Union-Find
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0UnionFind {
    private static final int[] DIRS = {0, -1, 0, 1, 0};

    public int largestIsland(int[][] grid) {
        // sanity check
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        final int NR = grid.length, NC = grid[0].length;

        int[] sizes = new int[NR * NC];
        Arrays.fill(sizes, 1);
        int[] roots = new int[NR * NC];
        for (int i = 0; i < NR * NC; ++i)
            roots[i] = i;

        // to union by sizes
        for (int row = 0; row < NR; ++row) {
            for (int col = 0; col < NC; ++col) {
                if (grid[row][col] == 1) {
                    int id1 = row * NC + col;
                    for (int d = 0; d < 4; ++d) {
                        int r = row + DIRS[d], c = col + DIRS[d + 1];
                        if (r < 0 || r >= NR || c < 0 || c >= NC || grid[r][c] == 0)
                            continue;
                        int id2 = r * NC + c;

                        int root1 = find(id1, roots), root2 = find(id2, roots);
                        if (root1 == root2)
                            continue;
                        if (sizes[root1] > sizes[root2]) {
                            roots[root2] = root1;
                            sizes[root1] += sizes[root2];
                        } else {
                            roots[root1] = root2;
                            sizes[root2] += sizes[root1];
                        }
                    }
                }
            }
        }

        // to get the max island by now
        int max = 0;
        for (int size : sizes)
            max = Math.max(max, size);

        // to attempt to flip once and union to get the max island
        for (int row = 0; row < NR; ++row) {
            for (int col = 0; col < NC; ++col) {
                if (grid[row][col] == 1)
                    continue; // of not interests
                int size = 1;
                Set<Integer> usedRoots = new HashSet<>();
                for (int d = 0; d < 4; ++d) {
                    int r = row + DIRS[d], c = col + DIRS[d + 1];
                    if (r < 0 || r >= NR || c < 0 || c >= NC || grid[r][c] == 0)
                        continue;
                    int id = r * NC + c;
                    int root = find(id, roots);
                    if (usedRoots.contains(root))
                        continue;
                    size += sizes[root];
                    usedRoots.add(root);
                }

                max = Math.max(max, size);
            }
        }

        return max == 0 ? NR * NC : max;
    }

    private int find(int id, int[] roots) {
        if (roots[id] == id)
            return id;

        return roots[id] = find(roots[id], roots);
    }
}