/**
 * https://leetcode.com/problems/graph-valid-tree/
 * 
 * Time Complexity: O(V + E)
 * Space Complexity: O(V + E)
 */
package com.polyg7ot.lc.lvl3.lc0261;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class SolutionApproachTSort1 {
    public boolean validTree(int n, int[][] edges) {
        // to builde up the graph
        Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
        LinkedList<Integer> queue = new LinkedList<Integer>();
        
        for(int i = 0; i < n; i++){
            graph.put(i, new HashSet<Integer>());
        }
        
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        for(int key : graph.keySet()){
            if(graph.get(key).size() == 1){
                queue.add(key);
            }
        }
        
        // to topological sort
        int count = 0;
        while(!queue.isEmpty()){
            int node = queue.removeFirst();
            if(graph.get(node).size() == 0) continue;
            int parent = graph.get(node).iterator().next();
            // --indegree[i]
            graph.get(parent).remove(node);
            // to reduce traversal, by removing empty Map<>.entry
            graph.remove(node);
            if(graph.get(parent).size() == 1){
                queue.add(parent);
            }
            count++;
        }
        
        if(count == n - 1) return true;
        return false;
    }
}