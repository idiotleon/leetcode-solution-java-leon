/**
 * https://leetcode.com/problems/the-maze-ii/
 * 
 * to find the next shortest stop from the starting point and then continue to explore from there.
 * 
 * Time Complexity:     O(V + Elg(V)) ~ 
 * Space Complexity:    O(Elg(V)) ~ 
 */
package com.zea7ot.leetcode.lvl4.lc0505;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SolutionApproach0DijkstrasAlgorithm1 {
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
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> Integer.compare(a[0], b[0]));
        minHeap.add(new int[] { 0, start[0], start[1] });

        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int row = cur[1], col = cur[2];
            // to compare by value
            if (destination[0] == row && destination[1] == col)
                break;

            int distance = distances[row][col];
            for (int d = 0; d < 4; d++) {
                int steps = 0;
                int r = row, c = col;
                while (isValid(r + DIRS[d], c + DIRS[d + 1], maze)) {
                    ++steps;
                    r += DIRS[d];
                    c += DIRS[d + 1];
                }

                // to update with the shortest distance
                if (distances[r][c] > distance + steps) {
                    distances[r][c] = distance + steps;
                    minHeap.add(new int[] { distances[r][c], r, c });
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
}