/**
 * https://leetcode.com/problems/critical-connections-in-a-network/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://www.youtube.com/watch?v=2kREIkF9UAs
 */
package com.zea7ot.lc.lvl4.lc1192;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0TarjansAlgorithm {
    private boolean[] visited;
    private int[] ids;
    private int id;
    private int[] low;
    private List<List<Integer>> ans;
    private List<List<Integer>> graph;
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ans = new ArrayList<List<Integer>>();
        // sanity check
        if(n <= 0) return ans;
        
        // prepartion work
        visited = new boolean[n];
        ids = new int[n];
        id = 0;
        low = new int[n];
        
        // to build up the graph
        graph = buildGraph(n, connections);
        
        // core logic
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i, -1);
            }
        }
        
        return ans;
    }
    
    private void dfs(int at, int parent){
        visited[at] = true;
        ids[at] = ++id;
        low[at] = ids[at];
        
        for(int to : graph.get(at)){
            if(to == parent) continue;
            
            if(!visited[to]){
                dfs(to, at);
                low[at] = Math.min(low[at], low[to]);
                if(ids[at] < low[to]){
                    ans.add(Arrays.asList(at, to));
                }
            }else low[at] = Math.min(low[at], ids[to]);
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