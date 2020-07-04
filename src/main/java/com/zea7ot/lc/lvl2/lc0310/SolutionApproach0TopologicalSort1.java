/**
 * https://leetcode.com/problems/minimum-height-trees/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * 
 * to peel off the onion
 * 
 * References:
 *  https://leetcode.com/problems/minimum-height-trees/discuss/76055/Share-some-thoughts
 */
package com.zea7ot.lc.lvl2.lc0310;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionApproach0TopologicalSort1 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> leaves = new ArrayList<Integer>();
        if(n <= 0) return leaves;
        if(n == 1) return Arrays.asList(0);
        
        List<Set<Integer>> graph = new ArrayList<Set<Integer>>();
        for(int i = 0; i < n; i++) graph.add(new HashSet<Integer>());
        for(int[] edge : edges){
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        for(int i = 0; i < n; i++){
            if(graph.get(i).size() == 1){
                leaves.add(i);
            }
        }
        
        while(n > 2){
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<Integer>();
            for(int leaf : leaves){
                int next = graph.get(leaf).iterator().next();
                graph.get(next).remove(leaf);
                if(graph.get(next).size() == 1) newLeaves.add(next);
            }
            leaves = newLeaves;
        }
        
        return leaves;
    }
}