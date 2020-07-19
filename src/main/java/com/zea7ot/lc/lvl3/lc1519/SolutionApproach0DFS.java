/**
 * https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/discuss/743133/Java-DFS.
 */
package com.zea7ot.lc.lvl3.lc1519;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionApproach0DFS {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        int[] ans = new int[n];
        // sanity check
        if(n <= 0) return ans;

        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        for(int[] edge : edges){
            int u = edge[0], v = edge[1];
            graph.computeIfAbsent(u, e -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, e -> new ArrayList<>()).add(u);
        }
        
        dfs(0, -1, labels, graph, ans);
        return ans;
    }
    
    private int[] dfs(int node, 
                      int parent, 
                      String lables, 
                      Map<Integer, List<Integer>> graph, 
                      int[] ans){
        int[] freq = new int[26];
        char ch = lables.charAt(node);
        for(int child : graph.getOrDefault(node, Collections.emptyList())){
            if(child == parent) continue;
            int[] sub= dfs(child, node, lables, graph, ans);
            for(int i = 0; i < 26; i++){
                freq[i] += sub[i];
            }
        }
        
        ++freq[ch - 'a'];
        ans[node] = freq[ch - 'a'];
        return freq;
    }
}