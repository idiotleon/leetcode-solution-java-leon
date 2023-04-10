/**
 * https://leetcode.com/problems/robot-room-cleaner/
 * 
 * 
 * References:
 *  https://leetcode.com/problems/robot-room-cleaner/discuss/139057/Very-easy-to-understand-Java-solution
 *  https://leetcode.com/problems/robot-room-cleaner/discuss/139057/Very-easy-to-understand-Java-solution/164917
 *  https://leetcode.com/problems/robot-room-cleaner/discuss/139057/Very-easy-to-understand-Java-solution/180844
 */
package com.idiotleon.leetcode.lvl4.lc0489;

import java.util.HashSet;
import java.util.Set;

public class SolutionApproach0Backtrack1 {
    // directions/orders/sequence matter,
    // in a way in which a robot can only turn 90 degrees, either CONSISTENTLY left
    // or right, at one time
    private static final int[][] DIRS = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public void cleanRoom(FakeRobot robot) {
        int[] start = { 0, 0 };
        Set<String> visited = new HashSet<String>();
        backtrack(start, 0, visited, robot);
    }

    /**
     * 
     * @param pos     the current position
     * @param dir     the current direction, for later backtrack purpose
     * @param visited
     * @param robot
     */
    private void backtrack(int[] pos, int dir, Set<String> visited, FakeRobot robot) {
        String position = pos[0] + "," + pos[1];
        if (visited.contains(position))
            return;
        visited.add(position);
        robot.clean();
        for (int d = 0; d < 4; d++) {
            int newDir = (dir + d) % 4;
            if (!robot.move()) {
                robot.turnRight();
                continue;
            }

            int[] newPos = { pos[0] + DIRS[newDir][0], pos[1] + DIRS[newDir][1] };
            backtrack(newPos, newDir, visited, robot);
            robot.turnRight();
            robot.turnRight();
            robot.move();
            robot.turnLeft();
            // no need to retrieve the FULL previous state
            // robot.turnLeft();
        }
    }
}