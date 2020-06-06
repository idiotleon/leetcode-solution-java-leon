/**
 * https://leetcode.com/problems/find-eventual-safe-states/
 * 
 * Time Complexity: O(V + E)
 * Space Complexity: O(V + E)
 */
package com.zea7ot.lc.lvl3.lc0802;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproachDFS1 {
    private static int NOT_VISITED = 0;
    private static int SAFE = 1;
    private static int UNSAFE = 2;
    
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<Integer>();
        if(graph == null || graph.length == 0) return ans;
        
        final int N = graph.length;
        int[] states = new int[N];
        
        for(int i = 0; i < N; i++){
            if(dfs(graph, i, states)){
                ans.add(i);
            }
        }
        
        return ans;
    }
    
    private boolean dfs(int[][] graph, int start, int[] states){
        if(states[start] != NOT_VISITED) return states[start] == SAFE;
        
        states[start] = UNSAFE;
        for(int next : graph[start]){
            if(!dfs(graph, next, states)){
                return false;
            }
        }
        states[start] = SAFE;
        
        return true;
    }
}