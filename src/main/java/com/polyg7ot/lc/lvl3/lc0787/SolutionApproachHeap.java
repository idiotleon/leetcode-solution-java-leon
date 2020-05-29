/**
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/
 */
package com.polyg7ot.lc.lvl3.lc0787;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class SolutionApproachHeap {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> prices = new HashMap<Integer, Map<Integer, Integer>>();
        for(int[] flight : flights){
            prices.putIfAbsent(flight[0], new HashMap<Integer, Integer>());
            prices.get(flight[0]).put(flight[1], flight[2]);;
        }
        
        Queue<int[]> heap = new PriorityQueue<int[]>((e0, e1) -> Integer.compare(e0[0], e1[0]));
        heap.add(new int[]{0, src, K + 1});
        
        while(!heap.isEmpty()){
            int[] top = heap.poll();
            int price = top[0];
            int city = top[1];
            int stops = top[2];
            if(city == dst) return price;
            if(stops > 0){
                Map<Integer, Integer> adj = prices.getOrDefault(city, new HashMap<Integer, Integer>());
                for(int a : adj.keySet()){
                    heap.add(new int[]{price + adj.get(a), a, stops - 1});
                }
            }
        }
        
        return -1;
    }
}