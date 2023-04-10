/**
 * https://leetcode.com/problems/reconstruct-itinerary/
 * 
 * Time Complexity:     O(N * lg(N)) + O(N) ~ O(N * lg(N))
 *  O(N * lg(N)), consumed by PQ
 *  O(N), consumed by `postorder()`
 * 
 * Space Complexity:    O(N) + O(H)
 * 
 * to sort the children and post order traverse the graph
 * 
 * Hierholzer's algorithm
 * Pseudocode:
 *  path = []
 *  DFS(u):
 *      while(!visited[edge(u, v)])
 *          visited[edge(u, v)] = true;
 *          DFS(v)
 *      End
 *      path.pushLeft(u)
 * 
 * References:
 *  https://www.youtube.com/watch?v=LKSdX31pXjY
 *  https://www.youtube.com/watch?v=4udFSOWQpdg
 *  http://zxi.mytechroad.com/blog/graph/leetcode-332-reconstruct-itinerary/
 *  Hierholzer's algorithm: https://en.wikipedia.org/wiki/Eulerian_path
 */
package com.idiotleon.leetcode.lvl3.lc0332;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class SolutionApproach0HierholzersAlgorithm1 {
    public List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> ans = new LinkedList<String>();
        // sanity check
        if (tickets == null || tickets.isEmpty())
            return ans;

        // a tree-like graph, with children sorted lexicographically and greedily
        Map<String, PriorityQueue<String>> graph = new HashMap<String, PriorityQueue<String>>();
        for (List<String> ticket : tickets) {
            // this PriorityQueue is a minHeap
            graph.putIfAbsent(ticket.get(0), new PriorityQueue<String>((a, b) -> a.compareTo(b)));
            graph.get(ticket.get(0)).add(ticket.get(1));
        }

        postorder("JFK", graph, ans);
        return ans;
    }

    private void postorder(String source, Map<String, PriorityQueue<String>> graph, LinkedList<String> routes) {
        PriorityQueue<String> destinations = graph.get(source);
        while (destinations != null && !destinations.isEmpty()) {
            postorder(destinations.poll(), graph, routes);
        }

        routes.addFirst(source);
    }
}