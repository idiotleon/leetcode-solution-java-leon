/**
 * https://leetcode.com/problems/path-with-maximum-probability/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/path-with-maximum-probability/discuss/731614/Java-Dijkstra
 *  https://leetcode.com/problems/path-with-maximum-probability/discuss/731767/JavaPython-3-2-codes%3A-Bellman-Ford-and-Dijkstra's-algorithm-w-brief-explanation-and-analysis.
 */
package com.idiotleon.leetcode.lvl3.lc1514;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class SolutionApproach0DijkstrasSPF {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        // sanity check
        if (n <= 0)
            return 0.0;

        List<List<Node>> graph = buildGraph(n, edges, succProb);

        PriorityQueue<Node> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b.probability, a.probability));
        maxHeap.offer(new Node(start, 1.0));

        Map<Integer, Double> memo = new HashMap<>();

        while (!maxHeap.isEmpty()) {
            Node cur = maxHeap.poll();
            int id = cur.id;
            double probability = cur.probability;
            if (id == end)
                return probability;

            for (Node next : graph.get(id)) {
                double prob = probability * next.probability;

                if (prob > memo.getOrDefault(next.id, 0.0)) {
                    memo.put(next.id, prob);
                    maxHeap.offer(new Node(next.id, prob));
                }
            }
        }

        return 0.0;
    }

    private List<List<Node>> buildGraph(int n, int[][] edges, double[] succProb) {
        final int N = edges.length;

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            graph.add(new ArrayList<>());

        for (int i = 0; i < N; ++i) {
            int u = edges[i][0], v = edges[i][1];
            double probability = succProb[i];

            graph.get(u).add(new Node(v, probability));
            graph.get(v).add(new Node(u, probability));
        }

        return graph;
    }

    private class Node {
        protected int id;
        protected double probability;

        protected Node(int id, double probability) {
            this.id = id;
            this.probability = probability;
        }
    }
}