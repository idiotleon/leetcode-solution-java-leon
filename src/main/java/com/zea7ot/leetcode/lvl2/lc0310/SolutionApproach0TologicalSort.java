/**
 * https://leetcode.com/problems/minimum-height-trees/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * to peel off the onion
 * 
 * References:
 *  https://leetcode.com/problems/minimum-height-trees/discuss/76055/Share-some-thoughts/211634
 */
package com.zea7ot.leetcode.lvl2.lc0310;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class SolutionApproach0TologicalSort {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<Integer>();
        if(n <= 0) return ans;
        if(n == 1) return Arrays.asList(0);
        
        List<Set<Integer>> graph = new ArrayList<Set<Integer>>();
        for(int i = 0; i < n; i++) graph.add(new HashSet<Integer>());
        for(int[] edge : edges){
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        Queue<Integer> leaves = new LinkedList<Integer>();
        int[] counts = new int[n];
        for(int i = 0; i < n; i++){
            counts[i] = graph.get(i).size();
            if(counts[i] == 1){
                leaves.add(i);
            }
        }
        
        int count = n;
        while(count > 2){
            final int SIZE = leaves.size();
            count -= SIZE;
            for(int i = 0; i < SIZE; i++){
                int leaf = leaves.poll();
                for(int next : graph.get(leaf)){
                    if(--counts[next] == 1){
                        leaves.add(next);
                    }
                }
            }
        }
        
        ans.addAll(leaves);
        return ans;
    }
}