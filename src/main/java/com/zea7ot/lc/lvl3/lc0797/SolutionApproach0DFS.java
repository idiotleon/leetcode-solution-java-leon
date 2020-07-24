/**
 * https://leetcode.com/problems/all-paths-from-source-to-target/
 * 
 * Time Complexity:     O(V + E) ~ O(N + N) ~ O(N)
 * Space Complexity:    O(V + E) ~ O(N + N) ~ O(N)
 */
package com.zea7ot.lc.lvl3.lc0797;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0DFS {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // sanity check
        if(graph == null || graph.length == 0) return ans;
        
        // final int N = graph.length;
        backtrack(0, new ArrayList<Integer>(), graph, ans);
        return ans;
    }
    
    private void backtrack(int cur, 
                     List<Integer> path, 
                     int[][] graph, 
                     List<List<Integer>> paths){
        final int N = graph.length;
        path.add(cur);
        if(cur == N - 1) 
            paths.add(new ArrayList<Integer>(path));
        for(int next : graph[cur]){
            backtrack(next, path, graph, paths);
        }
        path.remove(path.size() - 1);
    }
}