/**
 * https://leetcode.com/problems/robot-room-cleaner/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/robot-room-cleaner/discuss/153530/DFS-Logical-Thinking
 */
package com.zea7ot.leetcode.lvl4.lc0489;

import java.util.HashSet;
import java.util.Set;

public class SolutionApproach0Backtrack {
    private static final int[] DIRS = { 0, -1, 0, 1, 0 };

    public void cleanRoom(FakeRobot robot) {
        Set<String> visited = new HashSet<String>();
        backtrack(0, 0, 0, visited, robot);
    }

    private void backtrack(int row, int col, int dir, Set<String> visited, FakeRobot robot) {
        robot.clean();
        visited.add(hash(row, col));

        for (int d = 0; d < 4; d++) {
            int newDir = (dir + d) % 4;
            int r = row + DIRS[newDir], c = col + DIRS[newDir + 1];
            if (!visited.contains(hash(r, c)) && robot.move()) {
                backtrack(r, c, newDir, visited, robot);
            }

            // to change the direction
            robot.turnRight();
        }

        // to resume/backtrack to the previous state, including BOTH:
        // 1. position
        // 2. direction
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }

    private String hash(int row, int col) {
        return row + "," + col;
    }
}