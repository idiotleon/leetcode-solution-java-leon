/**
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 * 
 * Time Complexity: O(V + E) ~ O(N + M)
 * Space Complexity: O(N)
 */
package com.polyg7ot.lc.lvl3.lc0323;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class SolutionApproachBFS {
    public int countComponents(int n, int[][] edges) {
        // to build up the graph
        List<Integer>[] graph = new List[n];
        
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<Integer>();
        }
        
        for(int[] edge : edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        int count = 0;
        boolean[] visited = new boolean[n];
        for(int u = 0; u < n; u++){
            count += bfs(graph, visited, u);
        }
        
        return count;
    }
    
    private int bfs(List<Integer>[] graph, boolean[] visited, int cur){
        if(visited[cur]) return 0;
        visited[cur] = true;
        
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(cur);
        while(!queue.isEmpty()){
            int u = queue.removeFirst();
            for(int v : graph[u]){
                if(!visited[v]){
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
        
        return 1;
    }
}