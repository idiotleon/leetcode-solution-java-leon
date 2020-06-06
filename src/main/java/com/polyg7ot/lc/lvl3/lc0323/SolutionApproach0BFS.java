/**
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 * 
 * Time Complexity:     O(V + E) ~ O(n + edges.length)
 * Space Complexity:    O(n)
 */
package com.polyg7ot.lc.lvl3.lc0323;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class SolutionApproach0BFS {
    public int countComponents(int n, int[][] edges) {
        // to build up the graph
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<Integer>());
        }
        
        for(int[] edge : edges){
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        int count = 0;
        boolean[] visited = new boolean[n];
        for(int u = 0; u < n; u++){
            count += bfs(graph, visited, u);
        }
        
        return count;
    }
    
    private int bfs(List<List<Integer>> graph, boolean[] visited, int cur){
        if(visited[cur]) return 0;
        visited[cur] = true;
        
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(cur);
        while(!queue.isEmpty()){
            int u = queue.removeFirst();
            for(int v : graph.get(u)){
                if(!visited[v]){
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
        
        return 1;
    }
}