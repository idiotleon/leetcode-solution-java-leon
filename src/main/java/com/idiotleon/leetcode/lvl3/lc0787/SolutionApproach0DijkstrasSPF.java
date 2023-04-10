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
package com.idiotleon.leetcode.lvl3.lc0787;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SolutionApproach0DijkstrasSPF {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if (n <= 0)
            return 0;

        List<List<Flight>> graph = buildGraph(n, flights);

        PriorityQueue<Flight> minHeap = new PriorityQueue<Flight>((a, b) -> Integer.compare(a.price, b.price));
        minHeap.offer(new Flight(src, 0, K + 1));

        while (!minHeap.isEmpty()) {
            Flight cur = minHeap.poll();
            int city = cur.city;
            int price = cur.price;
            if (city == dst)
                return price;

            int stops = cur.stops;
            if (stops > 0) {
                for (Flight next : graph.get(city)) {
                    minHeap.add(new Flight(next.city, price + next.price, stops - 1));
                }
            }
        }

        return -1;
    }

    private List<List<Flight>> buildGraph(int n, int[][] flights) {
        List<List<Flight>> graph = new ArrayList<List<Flight>>(n);
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<Flight>());
        for (int[] flight : flights) {
            int start = flight[0];
            int city = flight[1];
            int price = flight[2];
            graph.get(start).add(new Flight(city, price));
        }
        return graph;
    }

    private class Flight {
        protected int city;
        protected int price;
        protected int stops;

        protected Flight(int city, int price) {
            this.city = city;
            this.price = price;
            this.stops = -1;
        }

        protected Flight(int city, int price, int stops) {
            this(city, price);
            this.stops = stops;
        }
    }
}