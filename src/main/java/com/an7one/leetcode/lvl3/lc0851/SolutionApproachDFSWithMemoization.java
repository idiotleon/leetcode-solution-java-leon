/**
 * https://leetcode.com/problems/loud-and-rich/
 */
package com.an7one.leetcode.lvl3.lc0851;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SolutionApproachDFSWithMemoization {
    private int[] ans;
    
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        final int N = quiet.length;
        ans = new int[N];
        Arrays.fill(ans, -1);
        
        // to build up the graph
        Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
        
        for(int i = 0; i < N; i++){
            graph.put(i, new HashSet<Integer>());
        }
        
        for(int[] rich : richer){
            graph.get(rich[1]).add(rich[0]);
        }
        
        for(int i = 0; i < N; i++){
            dfs(graph, quiet, i);
        }
        
        return ans;
    }
    
    // to return the answer element, in this case, the index, with the quietest
    private int dfs(Map<Integer, Set<Integer>> graph, int[] quiet, int i){
        if(ans[i] >= 0) return ans[i];
        
        // to assign the (initial) value once it is been visited
        ans[i] = i;
        
        // dfs to the next level
        for(int j : graph.get(i)){
            // if any person who is quieter 
            if(quiet[ans[i]] > quiet[dfs(graph, quiet, j)]){
                // to update the value
                ans[i] = ans[j];
            }
        }
        
        return ans[i];
    }
}