/**
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 * 
 * Time Complexity: O(V + E) ~ O(N + M)
 * Space Complexity: O(N)
 */
package com.null7ptr.lc.lvl3.lc0323;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproachDFS {
    public int countComponents(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        // to initialize the graph
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<Integer>();
        }
        
        // to build up the graph
        for(int[] edge : edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
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
    
    private void dfs(List<Integer>[] graph, 
                     int start, 
                     boolean[] visited){
        List<Integer> neighbors = graph[start];
        for(int neighbor : neighbors){
            if(!visited[neighbor]){
                visited[neighbor] = true;
                dfs(graph, neighbor, visited);
            }
        }
    }
}