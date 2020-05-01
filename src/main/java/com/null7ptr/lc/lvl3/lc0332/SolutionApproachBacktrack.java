/**
 * https://leetcode.com/problems/reconstruct-itinerary/
 * 
 * Time Complexity: O(V + E) ~ O(N)
 * Space Complexity: O(N)
 */
package com.null7ptr.lc.lvl3.lc0332;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SolutionApproachBacktrack {
    private int numTickets;
    private int numTicketsUsed;
    
    public List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> routes = new LinkedList<String>();
        if(tickets == null || tickets.isEmpty()) return routes;
        
        Map<String, List<String>> adjList = new HashMap<String, List<String>>();
        this.numTickets = tickets.size();
        this.numTicketsUsed = 0;
        
        // to build up the graph
        for(int i = 0; i < tickets.size(); i++){
            if(!adjList.containsKey(tickets.get(i).get(0))){
                List<String> list = new ArrayList<String>();
                list.add(tickets.get(i).get(1));
                adjList.put(tickets.get(i).get(0), list);
            }else{
                // to add to existing list
                adjList.get(tickets.get(i).get(0)).add(tickets.get(i).get(1));
            }
        }
        
        // to sort vertices in the adjacency list so that they appear in lexical order
        for(Map.Entry<String, List<String>> entry : adjList.entrySet()){
            Collections.sort(entry.getValue());
        }
        
        // to DFS
        routes.add("JFK");
        backtrack("JFK", routes, adjList);
        
        return routes;
    }
    
    private void backtrack(String v, LinkedList<String> routes, Map<String, List<String>> adjList){
        if(!adjList.containsKey(v)) return;
        List<String> list = adjList.get(v);
        for(int i = 0; i < list.size(); i++){
            String neighbor = list.get(i);
            list.remove(i);
            routes.add(neighbor);
            numTicketsUsed++;
            
            backtrack(neighbor, routes, adjList);
            if(numTickets == numTicketsUsed) return;
            
            list.add(i, neighbor);
            routes.removeLast();
            numTicketsUsed--;
        }
    }
}