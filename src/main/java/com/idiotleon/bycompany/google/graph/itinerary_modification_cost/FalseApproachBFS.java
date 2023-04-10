/**
 * A friend tells you a list of airport names of hit/her itinerary.
 * But the airport names may be wrong.
 * Given a biderectional graph of the airlines (between airports).
 * The cost is the number of different characters in the airport names.
 * For example, the right airport name is "SFO", but the given airport is "SFC",
 * then the modification cost is 1.
 * Output the min total cost of traversing over the itinerary
 * 
 * Example 1:
 * Input:
 * airports:
 *  [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * itinerary:
 *  ["MUC", "LHR", "SFC", SJC]
 * 
 * Output:
 *  1
 * 
 * 
 * Approach BFS
 * Time Complexity: O(V * (V + E))
 * Space ComplexityL O(V + E)
 * 
 * Please be noted that:
 *  this approach lies on the assumption that previously visited airports is NOT going
 *  to be re-visited, which is WRONG
 */
package com.idiotleon.bycompany.google.graph.itinerary_modification_cost;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class FalseApproachBFS {
    public int minCost(List<String[]> airports, List<String> itinerary){
        // sanity check
        if(airports == null || airports.isEmpty() || itinerary == null || itinerary.isEmpty()) return 0;

        // to build up the undirected graph
        Map<String, Set<String>> graph = new HashMap<String, Set<String>>();
        for(String[] airport : airports){
            String from = airport[0], to = airport[1];
            graph.putIfAbsent(from, new HashSet<String>());
            graph.putIfAbsent(to, new HashSet<String>());

            graph.get(from).add(to);
            graph.get(to).add(to);
        }

        Set<String> visited = new HashSet<String>();

        int minCost = Integer.MAX_VALUE;
        for(String startAirport : graph.keySet()){
            int cost = bfs(graph, itinerary, startAirport, visited);
            minCost = Math.min(minCost, cost);
        }

        return minCost;
    }

    private int bfs(Map<String, Set<String>> graph, List<String> itinerary, String startAirport, Set<String> visited){
        Queue<String> queue = new LinkedList<String>();
        Map<String, Integer> costs = new HashMap<String, Integer>();
        int start = 0;

        while(!queue.isEmpty()){
            for(String nextAirport : graph.get(startAirport)){
                if(visited.contains(nextAirport)) continue;
                visited.add(nextAirport);
                queue.add(nextAirport);
                costs.put(nextAirport, costs.getOrDefault(nextAirport, 0) + getModificationCost(nextAirport, itinerary.get(start)));
            }

            start++;
        }

        int minCost = Integer.MAX_VALUE;
        for(String key : costs.keySet()){
            minCost = Math.min(minCost, costs.get(key));
        }

        return minCost;
    }

    private int getModificationCost(String correct, String wrong){
        int count = 0;
        for(int i = 0; i < correct.length(); i++){
            if(correct.charAt(i) != wrong.charAt(i)){
                count++;
            }
        }
        return count;
    }
}