/**
 * https://leetcode.com/problems/trapping-rain-water-ii/
 * 
 * Time Complexity:     O(V + Elg(V)) ~ 
 * Space Complexity:    O(Elg(V)) ~
 * 
 * References:
 *  https://leetcode.com/problems/trapping-rain-water-ii/discuss/89461/Java-solution-using-PriorityQueue
 */
package com.an7one.leetcode.lvl4.lc0407;

import java.util.PriorityQueue;

public class SolutionApproach0DijkstrasSPF {
    private static final int[] DIRS = { 0, -1, 0, 1, 0 };

    public int trapRainWater(int[][] heightMap) {
        // sanity checl
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0)
            return 0;

        final int NR = heightMap.length, NC = heightMap[0].length;

        boolean[][] visited = new boolean[NR][NC];
        PriorityQueue<Cell> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.height, b.height));

        // to start with dealing with borders
        for (int row = 0; row < NR; ++row) {
            minHeap.offer(new Cell(row, 0, heightMap[row][0]));
            visited[row][0] = true;
            minHeap.offer(new Cell(row, NC - 1, heightMap[row][NC - 1]));
            visited[row][NC - 1] = true;
        }

        for (int col = 1; col < NC - 1; ++col) {
            minHeap.offer(new Cell(0, col, heightMap[0][col]));
            visited[0][col] = true;
            minHeap.offer(new Cell(NR - 1, col, heightMap[NR - 1][col]));
            visited[NR - 1][col] = true;
        }

        int water = 0;
        while (!minHeap.isEmpty()) {
            Cell top = minHeap.poll();
            for (int d = 0; d < 4; ++d) {
                int r = top.row + DIRS[d];
                int c = top.col + DIRS[d + 1];
                if (r < 0 || r >= NR || c < 0 || c >= NC || visited[r][c])
                    continue;
                visited[r][c] = true;
                water += Math.max(0, top.height - heightMap[r][c]);
                minHeap.offer(new Cell(r, c, Math.max(heightMap[r][c], top.height)));
            }
        }

        return water;
    }

    private class Cell {
        protected int row;
        protected int col;
        protected int height;

        protected Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }
}