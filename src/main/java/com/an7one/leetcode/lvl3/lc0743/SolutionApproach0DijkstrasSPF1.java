/**
 * https://leetcode.com/problems/network-delay-time/
 * 
 * Time Complexity:     O(V + Vlg(E)) ~ ?O(N + Nlg(E))
 * Space Compleixty:    O(Vlg(E)) ~ 
 * 
 * References:
 *  https://leetcode.com/problems/network-delay-time/discuss/210698/Java-Djikstrabfs-Concise-and-very-easy-to-understand
 */
package com.an7one.leetcode.lvl3.lc0743;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SolutionApproach0DijkstrasSPF1 {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] time : times) {
            map.putIfAbsent(time[0], new HashMap<Integer, Integer>());
            map.get(time[0]).put(time[1], time[2]);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> Integer.compare(a[0], b[0]));
        minHeap.add(new int[] { 0, K });

        boolean[] visited = new boolean[N + 1];

        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int node = cur[1];
            int distance = cur[0];
            if (visited[node])
                continue;
            visited[node] = true;

            if (--N == 0)
                return distance;
            if (map.containsKey(node)) {
                for (int next : map.get(node).keySet()) {
                    minHeap.add(new int[] { distance + map.get(node).get(next), next });
                }
            }
        }

        return -1;
    }
}