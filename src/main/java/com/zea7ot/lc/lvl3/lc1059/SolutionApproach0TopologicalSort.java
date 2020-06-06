/**
 * https://leetcode.com/problems/all-paths-from-source-lead-to-destination/
 * 
 * Time Complexity:     O(E + V)
 * Space Complexity:    O(E + V)
 * https://leetcode.com/problems/all-paths-from-source-lead-to-destination/discuss/335148/Enough-DFS-there-is-a-plain-simple-BFS-solution
 */
package com.zea7ot.lc.lvl3.lc1059;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SolutionApproach0TopologicalSort {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        // to build up the graph
        List<List<Integer>> graph = new ArrayList<List<Integer>>(n);
        int[] counts = new int[n];
        
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<Integer>());
        }
        
        for(int[] edge : edges){
            ++counts[edge[1]];
            graph.get(edge[0]).add(edge[1]);
        }
        
        // condition 1
        // if(graph[destination].contains(destination)) return false;
        
        // BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(source);
        
        while(!queue.isEmpty()){
            final int SIZE = queue.size();
            
            for(int i = 0; i < SIZE; i++){
                int cur = queue.removeFirst();
                
                // condition 2
                // self-loop
                if(graph.get(cur).contains(cur)) return false;
                if(graph.get(cur).size() == 0 && cur != destination) return false;
                
                List<Integer> next = graph.get(cur);
                for(int node : next){
                    if(counts[node] < 0 && node != destination) return false;
                    --counts[node];
                    queue.add(node);
                }
            }
        }
        
        return true;
    }

    /**
     * to satisfy either condition1 or condition2 should word. No need to get both.
     * 
     * the counts[] will take care of self-loop dilemma except the destination(node)
     */
}