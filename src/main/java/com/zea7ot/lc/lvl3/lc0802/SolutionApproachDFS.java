/**
 * https://leetcode.com/problems/find-eventual-safe-states/
 * 
 * Time Complexity: O(V + E)
 * Space Complexity: O(V + E)
 */
package com.zea7ot.lc.lvl3.lc0802;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproachDFS {
    private enum State{
        SAFE,
        UNSAFE
    }
    
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<Integer>();
        if(graph == null || graph.length == 0) return ans;
        
        final int N = graph.length;
        State[] states = new State[N];
        for(int i = 0; i < N; i++){
            if(dfs(graph, i, states)){
                ans.add(i);
            }
        }
        
        return ans;
    }
    
    private boolean dfs(int[][] graph, int start, State[] states){
        if(states[start] != null) return states[start] == State.SAFE;
        
        states[start] = State.UNSAFE;
        for(int next : graph[start]){
            if(!dfs(graph, next, states)){
                return false;
            }
        }
        states[start] = State.SAFE;
        
        return true;
    }
}