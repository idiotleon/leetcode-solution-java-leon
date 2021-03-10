/**
 * @author: Leon
 * https://leetcode.com/problems/all-paths-from-source-to-target/
 * 
 * Time Complexity:     O(V + E) ~ O(N + TOTAL_ELEMENTS)
 * Space Complexity:    O(V + E) ~ O(N + TOTAL_ELEMENTS)
 */
package com.an7one.leetcode.lvl3.lc0797;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SolutionApproach0BFS1 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        // sanity check
        if (graph == null || graph.length == 0)
            return paths;

        final int N = graph.length;
        final int DESTINATION = N - 1;

        Deque<PathNode> queue = new ArrayDeque<>();
        queue.offer(new PathNode(0));

        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int i = 0; i < SIZE; ++i) {
                PathNode node = queue.poll();
                int cur = node.getLast();
                if (cur == DESTINATION) {
                    paths.add(new ArrayList<>(node.path));
                    continue;
                }

                for (int next : graph[cur]) {
                    PathNode nextNode = new PathNode(node);
                    nextNode.path.add(next);
                    queue.offer(nextNode);
                }
            }
        }

        return paths;
    }

    private class PathNode {
        private final List<Integer> path;

        private PathNode(int node) {
            this.path = new ArrayList<>();
            this.path.add(node);
        }

        private PathNode(PathNode node) {
            this.path = new ArrayList<>(node.path);
        }

        private int getLast() {
            final int SIZE = this.path.size();
            final int IDX_LAST = SIZE - 1;
            return this.path.get(IDX_LAST);
        }
    }
}