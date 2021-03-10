/**
 * https://leetcode.com/problems/path-with-maximum-minimum-value/
 * 
 * Time Complexity:     O(E * lg(V)) ~ 
 * Space Complexity:    O()
 * 
 * Starting from the left corner, we record the max score to each node, 
 * we choose the path with maximum score to the a node which has not been visited, 
 * or re-visit it wherever a higher score is discovered. 
 * And explore all the neighbors, and store scores (the minimum value on the path) to the new node. 
 * If there is a higher score to the node we already visited, 
 * we will revisit it with the new score.
 * 
 * References:
 *  https://leetcode.com/problems/path-with-maximum-minimum-value/discuss/416227/Python-Dijkstra-Binary-Search-%2B-DFS-Union-Find-complexity-analysis
 *  https://leetcode.com/problems/path-with-maximum-minimum-value/discuss/324923/Clear-Code-Dijkstra-Algorithm-(C%2B%2BJavaPythonGoPHP)
 */
package com.an7one.leetcode.lvl4.lc1102;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SolutionApproach0DijkstraSPF {
    private static final int[] DIRS = { 0, 1, 0, -1, 0 };

    public int maximumMinimumPath(int[][] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        final int NR = nums.length, NC = nums[0].length;
        // max heap
        PriorityQueue<Node> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.score, a.score));
        maxHeap.offer(new Node(0, 0, nums[0][0]));

        int[][] scores = new int[NR][NC];
        for (int[] row : scores) {
            Arrays.fill(row, -1);
        }

        while (!maxHeap.isEmpty()) {
            Node cur = maxHeap.poll();
            int row = cur.row, col = cur.col;
            if (row == NR - 1 && col == NC - 1)
                return cur.score;

            for (int d = 0; d < 4; ++d) {
                int nextRow = row + DIRS[d], nextCol = col + DIRS[d + 1];

                if (nextRow < 0 || nextRow >= NR || nextCol < 0 || nextCol >= NC)
                    continue;

                int score = Math.min(nums[nextRow][nextCol], cur.score);
                if (score > scores[nextRow][nextCol]) {
                    scores[nextRow][nextCol] = score;
                    maxHeap.offer(new Node(nextRow, nextCol, score));
                }
            }
        }

        return -1;
    }

    private class Node {
        private int row;
        private int col;
        private int score;

        private Node(int row, int col, int score) {
            this.row = row;
            this.col = col;
            this.score = score;
        }
    }
}