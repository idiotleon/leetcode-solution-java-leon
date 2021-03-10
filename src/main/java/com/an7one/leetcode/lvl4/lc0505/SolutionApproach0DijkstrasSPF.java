/**
 * https://leetcode.com/problems/the-maze-ii/
 * 
 * Time Complexity:     O(V + Elg(V)) ~ O(NR * NC * lg(NR * NC))
 * Space Complexity:    O(Elg(V)) ~ O(NR * NC)
 * 
 * to find the next shortest stop from the starting point and then continue to explore from there.
 * 
 * 
 * References:
 *  https://leetcode.com/problems/the-maze-ii/solution/
 */
package com.an7one.leetcode.lvl4.lc0505;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SolutionApproach0DijkstrasSPF {
    private static final int[] DIRS = { 0, -1, 0, 1, 0 };

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        // sanity check
        if (maze == null || maze.length == 0 || maze[0].length == 0)
            return -1;

        // boundaries/sizes of the maze
        final int NR = maze.length, NC = maze[0].length;

        int[][] distances = new int[NR][NC];
        for (int[] row : distances)
            Arrays.fill(row, Integer.MAX_VALUE);
        distances[start[0]][start[1]] = 0;

        // min heap, by distance, the 1st element
        PriorityQueue<Position> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.distance, b.distance));
        minHeap.add(new Position(start[0], start[1], 0));

        while (!minHeap.isEmpty()) {
            Position cur = minHeap.poll();
            // to compare by value
            if (destination[0] == cur.row && destination[1] == cur.col)
                break;

            int distance = distances[cur.row][cur.col];
            for (int d = 0; d < 4; ++d) {
                int nextRow = cur.row, nextCol = cur.col;
                int steps = 0;

                while (isValid(nextRow + DIRS[d], nextCol + DIRS[d + 1], maze)) {
                    nextRow += DIRS[d];
                    nextCol += DIRS[d + 1];
                    ++steps;
                }

                // to update with the shortest distance
                if (distances[nextRow][nextCol] > distance + steps) {
                    distances[nextRow][nextCol] = distance + steps;
                    minHeap.add(new Position(nextRow, nextCol, distances[nextRow][nextCol]));
                }
            }
        }

        int shortestDistance = distances[destination[0]][destination[1]];
        return shortestDistance == Integer.MAX_VALUE ? -1 : shortestDistance;
    }

    private boolean isValid(int row, int col, int[][] maze) {
        final int NR = maze.length, NC = maze[0].length;
        return row >= 0 && row < NR && col >= 0 && col < NC && maze[row][col] == 0;
    }

    private class Position {
        protected int row;
        protected int col;
        protected int distance;

        protected Position(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }
}