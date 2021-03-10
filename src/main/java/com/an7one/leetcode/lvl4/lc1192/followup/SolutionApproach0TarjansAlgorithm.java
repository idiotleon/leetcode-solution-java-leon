/**
 * https://leetcode.com/problems/critical-connections-in-a-network/
 * Instead of returning articulation bridges, to return articulation points
 * 
 * 
 * 
 * References:
 *  https://www.youtube.com/watch?v=2kREIkF9UAs
 */
package com.an7one.leetcode.lvl4.lc1192.followup;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0TarjansAlgorithm {
    private int id;
    private int[] ids, low;
    private boolean[] visited;
    private List<Integer> ans;
    private List<List<Integer>> graph;
    
    public List<Integer> criticalRouters(int n, List<List<Integer>> connections) {
        ans = new ArrayList<Integer>();
        // sanity check
        if(n <= 0) return ans;
        
        // some prepartion work
        ids = new int[n];
        id = 0;
        low = new int[n];
        visited = new boolean[n];

        graph = buildGraph(n, connections);

        // magic
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i, -1);
            }
        }
        
        return ans;
    }

    private void dfs(int at, int parent) {
        low[at] = ids[at] = id++;
        visited[at] = true;
        int children = 0;

        for(int to : graph.get(at)) {
            if (to == at) continue;
            
            if(!visited[to]) {
                children++;
                dfs(to, at);
                low[at] = Math.min(low[at], low[to]);
                if (ids[at] < low[to] || children > 1) {
                    ans.add(at);
                }
            } else {
                low[at] = Math.min(low[at], ids[to]);
            }
        }
    }

    private List<List<Integer>> buildGraph(int n, List<List<Integer>> connections){
        // to build up the graph
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<Integer>());
        }
                
        for(List<Integer> conn : connections){
            int u = conn.get(0), v = conn.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    }
}