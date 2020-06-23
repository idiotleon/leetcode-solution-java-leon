/**
 * https://leetcode.com/problems/tree-diameter/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/tree-diameter/discuss/418830/Java-short-DFS-solution
 */
package com.zea7ot.lc.lvl3.lc1245;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SolutionApproach0DFS1 {
    public int treeDiameter(int[][] edges) {
        // sanity check
        if(edges == null || edges.length < 1) return 0;
        Map<Integer, List<Integer>> graph = buildGraph(edges);
        
        // since it is a tree-like structure, which guarantees no cycle,
        // there is no need to keep all visited node.
        // only the parent/previous one is needed
        Set<Integer> visited = new HashSet<Integer>();
        int[] far = dfs(graph, edges[0][0], visited);
        int[] result = dfs(graph, far[0], visited);
        return result[1];
    }
    
    private int[] dfs(Map<Integer, List<Integer>> graph, int start, Set<Integer> visited){
        visited.add(start);
        int distance = 0;
        int node = start;
        for(int adj : graph.get(start)){
            if(!visited.contains(adj)){
                int[] values = dfs(graph, adj, visited);
                if(distance < values[1]+ 1){
                    distance = values[1] + 1;
                    node = values[0];
                }
            }
        }
        visited.remove(start);
        return new int[]{node, distance};
    }
    
    private Map<Integer, List<Integer>> buildGraph(int[][] edges){
        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        for(int[] edge : edges){
            int u = edge[0], v = edge[1];
            graph.putIfAbsent(u, new ArrayList<Integer>());
            graph.putIfAbsent(v, new ArrayList<Integer>());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        return graph;
    }
}