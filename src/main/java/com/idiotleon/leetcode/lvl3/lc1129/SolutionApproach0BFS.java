/**
 * https://leetcode.com/problems/shortest-path-with-alternating-colors/
 * 
 * Time Complexity:     O(V + E)
 * Space Complexity:    O(V + E)
 * 
 * References:
 *  https://leetcode.com/problems/shortest-path-with-alternating-colors/discuss/340258/Java-BFS-Solution-with-Video-Explanation
 */
package com.idiotleon.leetcode.lvl3.lc1129;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class SolutionApproach0BFS {
    private static final int COLOR_RED = 1;
    private static final int COLOR_BLUE = -1;
    private static final int COLOR_BOTH = 0;

    private static final int NOT_EXISTS = -1;

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] ans = new int[n];
        for (int i = 1; i < n; ++i) {
            ans[i] = Integer.MAX_VALUE;
        }

        int[][] graph = buildGraph(redEdges, blueEdges, n);

        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(0, COLOR_RED));
        queue.offer(new Node(0, COLOR_BLUE));

        int shortest = 1;
        final Set<String> SEEN = new HashSet<>();

        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int i = 0; i < SIZE; ++i) {
                Node cur = queue.poll();
                int curNode = cur.node;
                int curColor = cur.color;
                String hash = "" + curNode + "#" + curColor;
                if (!SEEN.add(hash))
                    continue;

                int otherColor = -curColor;
                for (int nextNode = 1; nextNode < n; ++nextNode) {
                    if (graph[curNode][nextNode] != otherColor && graph[curNode][nextNode] != COLOR_BOTH)
                        continue;

                    queue.offer(new Node(nextNode, otherColor));
                    ans[nextNode] = Math.min(ans[nextNode], shortest);
                }
            }

            ++shortest;
        }

        for (int i = 1; i < n; ++i) {
            if (ans[i] == Integer.MAX_VALUE) {
                ans[i] = NOT_EXISTS;
            }
        }

        return ans;
    }

    private int[][] buildGraph(int[][] redEdges, int[][] blueEdges, final int N) {
        int[][] graph = new int[N][N];
        for (int[] row : graph) {
            Arrays.fill(row, -N);
        }

        for (int[] edge : redEdges) {
            int from = edge[0];
            int to = edge[1];

            graph[from][to] = COLOR_RED;
        }

        for (int[] edge : blueEdges) {
            int from = edge[0];
            int to = edge[1];

            if (graph[from][to] == COLOR_RED) {
                graph[from][to] = COLOR_BOTH;
            } else {
                graph[from][to] = COLOR_BLUE;
            }
        }

        return graph;
    }

    private class Node {
        private int node;
        private int color;

        private Node(int node, int color) {
            this.node = node;
            this.color = color;
        }
    }
}
