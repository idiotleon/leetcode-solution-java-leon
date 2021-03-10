/**
 * @author: Leon
 * https://leetcode.com/problems/network-delay-time/
 * 
 * Time Complexity:     O(V + E * lg(V)) ~ O(N + `times.length` * lg(N))
 * Space Complexity:    O(E * lg(V)) ~ O(`times.length` * lg(N))
 */
package com.an7one.leetcode.lvl3.lc0743;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class SolutionApproach0DijkstrasSPF {
    public int networkDelayTime(int[][] times, int N, int K) {
        // sanity check
        if (N <= 0)
            return -1;

        List<List<Node>> graph = buildGraph(N, times);

        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.time, b.time));
        // to turn `K` 0-indexed
        minHeap.offer(new Node(K - 1, 0));

        Set<Integer> seen = new HashSet<>();
        while (!minHeap.isEmpty()) {
            Node cur = minHeap.poll();
            int id = cur.id;
            int time = cur.time;

            if (!seen.add(id))
                continue;
            if (seen.size() == N)
                return time;

            for (Node next : graph.get(id)) {
                next.time += time;
                minHeap.offer(next);
            }
        }

        return -1;
    }

    private List<List<Node>> buildGraph(final int N, int[][] times) {
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < N; ++i)
            graph.add(new ArrayList<>());

        for (int[] t : times) {
            // to turn node IDs 0-indexed
            int from = t[0] - 1;
            // to turn node IDs 0-indexed
            int to = t[1] - 1;
            int time = t[2];

            graph.get(from).add(new Node(to, time));
        }

        return graph;
    }

    private class Node {
        protected int id;
        protected int time;

        protected Node(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }
}