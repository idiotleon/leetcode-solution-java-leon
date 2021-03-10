/**
 * https://leetcode.com/problems/tree-diameter/
 * 
 * Time Complexity:     O(2 * N) ~ O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/tree-diameter/discuss/418820/(Java)-Using-2-BFS/402688
 *  https://leetcode.com/problems/tree-diameter/discuss/418820/(Java)-Using-2-BFS/402688
 *  https://stackoverflow.com/a/29219346/6061609
 */
package com.an7one.leetcode.lvl3.lc1245;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class SolutionApproach0BFS {
    public int treeDiameter(int[][] edges) {
        // sanity check
        if (edges == null || edges.length < 1)
            return 0;

        final int N = edges.length;

        // best[0]: the length
        // best[1]: the starting position/node/vetice
        int[] best = { -1, -1 };
        List<List<Integer>> graph = buildGraph(edges);

        bfs(0, N, graph, best);
        bfs(best[1], N, graph, best);

        return best[0];
    }

    private void bfs(int start, final int N, List<List<Integer>> graph, int[] best) {
        int[] distances = new int[N + 1];
        Arrays.fill(distances, -1);

        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        distances[start] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph.get(cur)) {
                // visited
                if (distances[next] != -1)
                    continue;
                // not visited
                distances[next] = distances[cur] + 1;
                queue.add(next);
            }
        }

        int maxDistance = 0, maxNode = 0;
        for (int i = 0; i < N + 1; ++i) {
            if (distances[i] > maxDistance) {
                maxDistance = distances[i];
                maxNode = i;
            }
        }

        best[0] = maxDistance;
        best[1] = maxNode;
    }

    private List<List<Integer>> buildGraph(int[][] edges) {
        final int N = edges.length;
        List<List<Integer>> graph = new ArrayList<>();
        // since it is a "tree", all nodes are connected
        for (int i = 0; i < N + 1; ++i)
            graph.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return graph;
    }
}