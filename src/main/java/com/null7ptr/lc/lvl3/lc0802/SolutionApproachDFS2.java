/**
 * https://leetcode.com/problems/find-eventual-safe-states/
 * 
 * Time Complexity: O(V + E)
 * Space Complexity: O(V + E)
 */
package com.null7ptr.lc.lvl3.lc0802;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproachDFS2 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<Integer>();
        if(graph == null || graph.length == 0) return ans;
        
        final int N = graph.length;
        int[] colors = new int[N];
        
        for(int i = 0; i < N; i++){
            if(dfs(graph, i, colors)){
                ans.add(i);
            }
        }
        
        return ans;
    }
    
    private boolean dfs(int[][] graph, int start, int[] colors){
        if(colors[start] != 0) return colors[start] == 1;
        
        colors[start] = 2;
        for(int next : graph[start]){
            if(!dfs(graph, next, colors)){
                return false;
            }
        }
        colors[start] = 1;
        
        return true;
    }
}