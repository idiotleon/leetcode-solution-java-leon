/**
 * https://leetcode.com/problems/reconstruct-itinerary/
 * 
 * Time Complexity:     O(N * lg(N)) + O(N) ~ O(N * lg(N))
 * Space Complexity:    O(N) + 
 * 
 * References:
 *  https://www.youtube.com/watch?v=LKSdX31pXjY
 */
package com.zea7ot.leetcode.lvl3.lc0332;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionApproach0Backtrack {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> ans = new ArrayList<String>();
        // sanity check
        if(tickets == null || tickets.isEmpty()) return ans;
        
        final int N = tickets.size();
        Map<String, List<String>> graph = buildGraph(tickets);

        final String START = "JFK";
        ans.add(START);
        if(findItinerary(START, ans, graph, N + 1)) return ans;
        return null;
    }
    
    private boolean findItinerary(String source, 
                                  List<String> route, 
                                  Map<String, List<String>> graph, 
                                  final int LEN){
        if(route.size() == LEN) return true;
        if(!graph.containsKey(source)) return false;
        
        List<String> destinations = graph.get(source);
        for(int i = 0; i < destinations.size(); i++){
            String destination = destinations.get(i);
            destinations.remove(i);
            route.add(destination);
            if(findItinerary(destination, route, graph, LEN)) return true;
            route.remove(route.size() - 1);
            destinations.add(i, destination);
        }
        
        return false;
    }
    
    private Map<String, List<String>> buildGraph(List<List<String>> tickets){
        Map<String, List<String>> graph = new HashMap<String, List<String>>();
        for(List<String> ticket : tickets){
            graph.putIfAbsent(ticket.get(0), new ArrayList<String>());
            graph.get(ticket.get(0)).add(ticket.get(1));
        }
        
        for(Map.Entry<String, List<String>> entry : graph.entrySet()){
            Collections.sort(entry.getValue());
        }
        
        return graph;
    }
}