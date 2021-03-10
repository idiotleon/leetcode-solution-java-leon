/*
 * image: connected pixel: all surrounding R G B 
 * [ [1, 1, 1], [1, 1, 1],
 *   [1, 2, 0], [1, 2, 0] ]
 * 
 * Time Complexity: O(NR * NC) Space Complexity: O(NR * NC)
 */
package com.an7one.bycompany.others.matrix.most_connected_pixels;

import java.util.HashSet;
import java.util.Set;

public class SolutionApproach0DFS {
    private static final int[] DIRS = { 0, -1, 0, 1, 0 };

    private int most;
    private int count;

    // to output the most connected pixels number
    protected int getMostConnectedPixels(Pixel[][] image) {
        // sanity check
        if (image == null || image.length == 0 || image[0].length == 0)
            return 0;

        this.most = 1;

        final int NR = image.length, NC = image[0].length;
        // dfs
        for (int row = 0; row < NR; ++row) {
            for (int col = 0; col < NC; ++col) {
                this.count = 0;
                dfs(row, col, new HashSet<Integer>(), image[row][col].AVERAGE, image);
            }
        }

        // to return the answer
        return most;
    }

    private void dfs(int row, int col, Set<Integer> seen, final double AVERAGE, Pixel[][] image) {
        final int NR = image.length, NC = image[0].length;
        if (row < 0 || row >= NR || col < 0 || col >= NC || seen.contains(hash(row, col, NC))
                || image[row][col].AVERAGE != AVERAGE)
            return;

        seen.add(hash(row, col, NC));
        most = Math.max(most, ++count);

        // to further DFS
        for (int d = 0; d < 4; ++d) {
            int r = row + DIRS[d], c = col + DIRS[d + 1];
            dfs(r, c, seen, image[row][col].AVERAGE, image);
        }
    }

    private int hash(int row, int col, final int NC) {
        return row * NC + col;
    }
}