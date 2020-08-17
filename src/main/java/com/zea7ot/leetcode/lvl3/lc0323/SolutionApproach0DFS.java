/**
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 * 
 * Time Complexity:     O(V + E) ~ O(n + edges.length)
 * Space Complexity:    O(n)
 */
package com.zea7ot.leetcode.lvl3.lc0323;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0DFS {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        // to initialize the graph
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<Integer>());
        }
        
        // to build up the graph
        for(int[] edge : edges){
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        // dfs
        boolean[] visited = new boolean[n];
        int res = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(graph, i, visited);
                res++;
            }
        }
        
        return res;
    }
    
    private void dfs(List<List<Integer>> graph, 
                     int start, 
                     boolean[] visited){
        List<Integer> neighbors = graph.get(start);
        for(int neighbor : neighbors){
            if(!visited[neighbor]){
                visited[neighbor] = true;
                dfs(graph, neighbor, visited);
            }
        }
    }
}