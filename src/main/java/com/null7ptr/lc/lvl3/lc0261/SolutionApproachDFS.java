/**
 * https://leetcode.com/problems/graph-valid-tree/
 * 
 * Time Complexity: O(V + E)
 * Space Complexity: O(V + E)
 */
package com.null7ptr.lc.lvl3.lc0261;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproachDFS {
    public boolean validTree(int n, int[][] edges) {
        // to build up the graph
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        
        // to initialize the graph
        for(int i = 0; i < n; i++){
            graph.add(i, new ArrayList<Integer>());
        }
        
        // to add edges
        for(int[] edge : edges){
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        boolean[] visited = new boolean[n];
        
        if(hasCycle(graph, 0, visited, -1)){
            return false;
        }
        
        // to make sure that all vertices are connected
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                return false;
            }
        }
        
        return true;
    }
    
    // to check if an undirected graph has cycle starting from vertext u
    private boolean hasCycle(List<List<Integer>> graph, int u, boolean[] visited, int pre){
        if(visited[u]) return true;
        
        visited[u] = true;
        
        for(int v : graph.get(u)){
            if(v != pre && hasCycle(graph, v, visited, u)){
                return true;
            }
        }
        
        return false;
    }
}