/**
 * https://leetcode.com/problems/robot-bounded-in-circle/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/robot-bounded-in-circle/discuss/290856/JavaC%2B%2BPython-Let-Chopper-Help-Explain
 */
package com.an7one.leetcode.lvl2.lc1041;

public class SolutionApproach0Math {
    private static final int[][] DIRS = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };

    public boolean isRobotBounded(String instructions) {
        // sanity check
        if (instructions == null || instructions.isEmpty())
            return false;

        int row = 0, col = 0;
        int d = 0;

        for (final char CH : instructions.toCharArray()) {
            switch (CH) {
                case 'G':
                    row += DIRS[d][0];
                    col += DIRS[d][1];
                    break;
                case 'L':
                    d = (d + 1) % 4;
                    break;
                case 'R':
                    d = (d + 3) % 4;
                    break;
            }
        }

        return row == 0 && col == 0 || d > 0;
    }
}
