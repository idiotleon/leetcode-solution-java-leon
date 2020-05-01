/**
 * https://leetcode.com/problems/all-paths-from-source-lead-to-destination/
 * 
 * Time Complexity: O(E + V)
 * Space Complexity: O(E + V)
 * https://leetcode.com/problems/all-paths-from-source-lead-to-destination/discuss/303566/Java-DFS-with-cycle-detection-(5ms)
 */
package com.null7ptr.lc.lvl3.lc1059;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproachDFS {
    private enum State {PROCESSING, PROCESSED};
    
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<Integer>[] graph = buildGraph(edges, n);
        return dfs(graph, source, destination, new State[n]);
    }
    
    private boolean dfs(List<Integer>[] graph, int node, int destination, State[] states){
        if(states[node] != null) return states[node] == State.PROCESSED;
        if(graph[node].isEmpty()) return node == destination;
        
        states[node] = State.PROCESSING;
        for(int next : graph[node]){
            if(!dfs(graph, next, destination, states)) return false;
        }
        states[node] = State.PROCESSED;
        
        return true;
    }
    
    private List<Integer>[] buildGraph(int[][] edges, int n){
        List<Integer>[] graph = new List[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<Integer>();
        }
        
        for(int[] edge : edges){
            graph[edge[0]].add(edge[1]);
        }
        
        return graph;
    }
}