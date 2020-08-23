/**
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/
 * 
 * Time Complexity:     O(V + E * lg(V)) ~  O(n + edges.length * lg(n))
 * Space Complexity:    O(V) ~ O(n)
 * 
 * References:
 *  https://leetcode.com/problems/cheapest-flights-within-k-stops/discuss/115541/JavaPython-Priority-Queue-Solution
 *  https://leetcode.com/problems/cheapest-flights-within-k-stops/discuss/361711/Java-DFSBFSBellman-Ford-Dijkstra's
 */
package com.zea7ot.leetcode.lvl3.lc0787;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SolutionApproach0DijkstrasSPF1 {
    public int findCminHeapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> prices = new HashMap<Integer, Map<Integer, Integer>>();
        for(int[] flight : flights){
            prices.putIfAbsent(flight[0], new HashMap<Integer, Integer>());
            prices.get(flight[0]).put(flight[1], flight[2]);;
        }
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        minHeap.add(new int[]{0, src, K + 1});
        
        while(!minHeap.isEmpty()){
            int[] top = minHeap.poll();
            int price = top[0];
            int city = top[1];
            int stops = top[2];
            if(city == dst) return price;
            if(stops > 0){
                Map<Integer, Integer> adj = prices.getOrDefault(city, new HashMap<Integer, Integer>());
                for(Map.Entry<Integer, Integer> entry : adj.entrySet()){
                    minHeap.add(new int[]{price + entry.getValue(), entry.getKey(), stops - 1});
                }
            }
        }
        
        return -1;
    }
}