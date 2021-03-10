/**
 * https://leetcode.com/problems/spiral-matrix-iii/
 * 
 * Time Complexity:     O(max(R, C) ^ 2)
 * Space Complexity:    O(R * C)
 * 
 * References:
 *  https://leetcode.com/problems/spiral-matrix-iii/discuss/158977/Java-15-lines-concise-solution-with-comments
 *  https://leetcode.com/problems/spiral-matrix-iii/discuss/158970/C%2B%2BJavaPython-112233-Steps
 */
package com.an7one.leetcode.lvl2.lc0885;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Math1 {
    private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        List<int[]> ans = new ArrayList<>();
        int len = 0, dir = 0;
        ans.add(new int[] { r0, c0 });

        while (ans.size() < R * C) {
            if (dir == 0 || dir == 2)
                ++len;

            for (int i = 0; i < len; ++i) {
                r0 += DIRS[dir][0];
                c0 += DIRS[dir][1];

                if (r0 >= 0 && r0 < R && c0 >= 0 && c0 < C)
                    ans.add(new int[] { r0, c0 });
            }

            // to turn to the next direction
            dir = (dir + 1) % 4;
        }

        return ans.toArray(new int[R * C][2]);
    }
}