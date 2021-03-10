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
 * Approach DFS
 * Time Complexity: O(V * (V + E))
 * Space ComplexityL O(V + E)
 * 
 * Please be noted that:
 *  this approach lies on the assumption that previously visited airports is NOT going
 *  to be re-visited, which is WRONG
 */
package com.an7one.bycompany.google.graph.itinerary_modification_cost;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FalseApproachDFS {
    private int minCost = Integer.MAX_VALUE;

    public int minCost(List<String[]> airports, List<String> itinerary){
        // sanity check
        if(airports == null || airports.isEmpty() || itinerary == null || itinerary.isEmpty()) return 0;

        // to build up the undirected graph
        Map<String, Set<String>> graph = new HashMap<String, Set<String>>();
        Set<String> visited = new HashSet<String>();

        for(int i = 0; i < airports.size(); i++){
            String from = airports.get(i)[0], to = airports.get(i)[1];
            graph.putIfAbsent(from, new HashSet<String>());
            graph.putIfAbsent(to, new HashSet<String>());

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        // to try every possible starting airport
        for(String startAirport : graph.keySet()){
            dfs(graph, itinerary, startAirport, visited, 0, 0);
        }
        
        return minCost;
    }

    private void dfs(Map<String, Set<String>> graph, List<String> itinerary, String startAirport, Set<String> visited, int start, int cost){
        if(visited.contains(startAirport)) return;
        visited.add(startAirport);

        if(start == itinerary.size()) {
            minCost = Math.min(minCost, cost);
            return;
        }

        cost += getModificationCost(startAirport, itinerary.get(start));

        for(String nextAirport : graph.get(startAirport)){
            dfs(graph, itinerary, nextAirport, visited, start + 1, cost);
        }

        visited.remove(startAirport);
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