/**
 * https://leetcode.com/problems/the-maze-iii/
 * 
 * Time Complexity:     O(V + Elg(V)) ~ 
 * Space Compelxity:    O(Elg(V)) ~ 
 * 
 * References:
 *  https://leetcode.com/problems/the-maze-iii/discuss/97831/Shortclean-and-straight-forward-BFS-solution-with-PriorityQueue
 */
package com.zea7ot.leetcode.lvl5.lc0499;

import java.util.PriorityQueue;

public class SolutionApproach0DijkstrasSPF1 {
    private static final int[][] DIRS = { { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, 0 } };
    // to strictly align with DIRS(int[][])
    private static final char[] MOVES = { 'd', 'l', 'r', 'u' };

    private static final String IMPOSSIBLE = "impossible";

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        final int NR = maze.length, NC = maze[0].length;
        boolean[][] visited = new boolean[NR][NC];

        PriorityQueue<Position> minHeap = new PriorityQueue<Position>();
        minHeap.offer(new Position(ball[0], ball[1], 0, ""));

        while (!minHeap.isEmpty()) {
            Position cur = minHeap.poll();

            if (cur.row == hole[0] && cur.col == hole[1])
                return cur.moves;

            if (visited[cur.row][cur.col])
                continue;
            visited[cur.row][cur.col] = true;

            for (int d = 0; d < 4; ++d) {
                Position next = moveForward(maze, cur, d, hole);
                minHeap.offer(new Position(next.row, next.col, next.distance, next.moves + MOVES[d]));
            }
        }

        return IMPOSSIBLE;
    }

    /**
     * to move from the currently given position, and move in the currently given
     * direction, until hitting a wall
     * 
     * @param maze
     * @param cur
     * @param direction
     * @param hole
     * @return the last position/coordinate of the ball right before hitting the
     *         wall
     */
    private Position moveForward(int[][] maze, Position cur, int direction, int[] hole) {
        int row = cur.row, col = cur.col;
        int distance = cur.distance;
        while (isValid(row, col, maze)) {
            row += DIRS[direction][0];
            col += DIRS[direction][1];
            ++distance;
            if (row == hole[0] && col == hole[1])
                return new Position(row, col, distance, cur.moves);
        }

        // to move one step back from the wall
        row -= DIRS[direction][0];
        col -= DIRS[direction][1];
        --distance;
        return new Position(row, col, distance, cur.moves);
    }

    private boolean isValid(int row, int col, int[][] maze) {
        final int NR = maze.length, NC = maze[0].length;
        return row >= 0 && row < NR && col >= 0 && col < NC && maze[row][col] == 0;
    }

    private class Position implements Comparable<Position> {
        protected int row;
        protected int col;
        protected int distance;
        protected String moves;

        protected Position(int row, int col, int distance, String moves) {
            this.row = row;
            this.col = col;
            this.distance = distance;
            this.moves = moves;
        }

        // @Override
        public int compareTo(Position that) {
            if (this.distance == that.distance)
                return this.moves.compareTo(that.moves);
            return this.distance - that.distance;
        }
    }
}