/*
 * image: connected pixel: all surrounding R G B 
 * [ [1, 1, 1], [1, 1, 1],
 *   [1, 2, 0], [1, 2, 0] ]
 * 
 * Time Complexity: O(NR * NC) Space Complexity: O(NR * NC)
 */
package com.zea7ot.by_companies.others.matrix.most_connected_pixels;

import java.util.HashSet;
import java.util.Set;

public class SolutionApproach0DFS1 {
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
                dfs(row, col, new HashSet<Integer>(), image);
            }
        }

        // to return the answer
        return most;
    }

    private void dfs(int row, int col, Set<Integer> seen, Pixel[][] image) {
        final int NR = image.length, NC = image[0].length;

        // to further DFS
        for (int d = 0; d < 4; ++d) {
            int r = row + DIRS[d], c = col + DIRS[d + 1];
            if (r < 0 || r >= NR || c < 0 || c >= NC || seen.contains(hash(r, c, NC))
                    || image[r][c].AVERAGE != image[row][col].AVERAGE)
                continue;
            seen.add(hash(r, c, NC));
            most = Math.max(most, ++count);
            dfs(r, c, seen, image);
        }
    }

    private int hash(int row, int col, final int NC) {
        return row * NC + col;
    }
}