/**
 * https://leetcode.com/problems/find-eventual-safe-states/
 * 
 * Time Complexity: O(V + E)
 * Space Complexity: O(V + E)
 */
package com.polyg7ot.lc.lvl3.lc0802;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionApproachDFS3 {
    private enum States{
        NOT_VISITED,
        SAFE,
        UNSAFE
    }
    
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<Integer>();
        if(graph == null || graph.length == 0) return ans;
        
        final int N = graph.length;
        States[] states = new States[N];
        // do not forget initialization
        Arrays.fill(states, States.NOT_VISITED);
        
        for(int i = 0; i < N; i++){
            if(dfs(graph, i, states)){
                ans.add(i);
            }
        }
        
        return ans;
    }
    
    private boolean dfs(int[][] graph, int start, States[] states){
        if(states[start] != States.NOT_VISITED) return states[start].equals(States.SAFE);
        
        states[start] = States.UNSAFE;
        for(int next : graph[start]){
            if(!dfs(graph, next, states)){
                return false;
            }
        }
        states[start] = States.SAFE;
        
        return true;
    }
}