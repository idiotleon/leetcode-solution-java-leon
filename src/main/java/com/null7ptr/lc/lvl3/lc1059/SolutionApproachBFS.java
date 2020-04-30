/**
 * https://leetcode.com/problems/all-paths-from-source-lead-to-destination/
 * 
 * Time Complexity: O(E + V)
 * Space Complexity: O(E + V)
 * https://leetcode.com/problems/all-paths-from-source-lead-to-destination/discuss/335148/Enough-DFS-there-is-a-plain-simple-BFS-solution
 */
package com.null7ptr.lc.lvl3.lc1059;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SolutionApproachBFS {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        // to build up the graph
        List<Integer>[] graph = new List[n];
        int[] indegree = new int[n];
        
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<Integer>();
        }
        
        for(int[] edge : edges){
            ++indegree[edge[1]];
            graph[edge[0]].add(edge[1]);
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
                if(graph[cur].contains(cur)) return false;
                if(graph[cur].size() == 0 && cur != destination) return false;
                
                List<Integer> next = graph[cur];
                for(int node : next){
                    if(indegree[node] < 0 && node != destination) return false;
                    --indegree[node];
                    queue.add(node);
                }
            }
        }
        
        return true;
    }

    /**
     * to satisfy either condition1 or condition2 should word. No need to get both.
     * 
     * the indegree[] will take care of self-loop dilemma except the destination(node)
     */
}