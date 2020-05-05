/**
 * https://leetcode.com/problems/graph-valid-tree/
 * 
 * Time Complexity: O(N + M)
 * Space Complexity: O(N + M)
 */
package com.polyg7ot.lc.lvl3.lc0261;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class SolutionApproachTSort {
    public boolean validTree(int n, int[][] edges) {
        Set<Integer>[] graph = new HashSet[n];
        
        for(int i = 0; i < n; i++){
            graph[i] = new HashSet<Integer>();
        }
        
        for(int[] edge : edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < n; i++){
            // isolated nodes, if ever been found
            // (1, []) is expected to return true
            // if(graph[i].size() == 0) return false;
            // eligible (leaf) nodes, with only 1 parent
            if(graph[i].size() == 1){
                queue.add(i);
            }
        }
        
        int count = 0;
        while(!queue.isEmpty()){
            int node = queue.removeFirst();
            if(graph[node].size() == 0) continue;
            int parent = graph[node].iterator().next();
            // --indegree[i]
            graph[parent].remove(node);
            if(graph[parent].size() == 1){
                queue.add(parent);
            }
            count++;
        }
        
        return count == n - 1;
    }
}