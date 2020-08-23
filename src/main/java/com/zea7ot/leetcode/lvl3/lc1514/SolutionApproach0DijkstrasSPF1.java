/**
 * https://leetcode.com/problems/path-with-maximum-probability/
 * 
 * Time Complexity:     O(V + Elg(V)) ~ O(n + edges.length * lg(n))
 * Space Complexity:    O(V) + O(V) ~ O(2 * n) ~ O(n)
 * 
 * References:
 *  https://leetcode.com/problems/path-with-maximum-probability/discuss/731614/java-dijkstra/613879
 *  https://www.hackerearth.com/practice/algorithms/graphs/shortest-path-algorithms/tutorial/#:~:text=Time%20Complexity%20of%20Dijkstra's%20Algorithm,E%20l%20o%20g%20V%20)%20.
 */
package com.zea7ot.leetcode.lvl3.lc1514;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class SolutionApproach0DijkstrasSPF1 {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<State>> graph = buildGraph(n, edges, succProb);

        PriorityQueue<State> maxHeap = new PriorityQueue<State>((a, b) -> Double.compare(b.probability, a.probability));
        maxHeap.offer(new State(start, 1.0));

        Map<Integer, Double> memo = new HashMap<Integer, Double>();

        while (!maxHeap.isEmpty()) {
            State top = maxHeap.poll();

            if (top.vertex == end)
                return top.probability;

            for (State next : graph.get(top.vertex)) {
                double probability = top.probability * next.probability;
                if (probability > memo.getOrDefault(next.vertex, 0.0)) {
                    memo.put(next.vertex, probability);
                    maxHeap.offer(new State(next.vertex, probability));
                }
            }
        }

        return 0.0;
    }

    private List<List<State>> buildGraph(int n, int[][] edges, double[] succProb) {
        List<List<State>> graph = new ArrayList<List<State>>(n);

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<State>());

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            double probability = succProb[i];
            graph.get(u).add(new State(v, probability));
            graph.get(v).add(new State(u, probability));
        }

        return graph;
    }

    private class State {
        protected int vertex;
        protected double probability;

        protected State(int vertex, double probability) {
            this.vertex = vertex;
            this.probability = probability;
        }
    }
}