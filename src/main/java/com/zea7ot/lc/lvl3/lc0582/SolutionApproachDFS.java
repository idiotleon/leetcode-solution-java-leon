/**
 * https://leetcode.com/problems/kill-process/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
package com.zea7ot.lc.lvl3.lc0582;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SolutionApproachDFS {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> ans = new ArrayList<Integer>();
        
        Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
        for(int i = 0; i < pid.size(); i++){
            graph.putIfAbsent(ppid.get(i), new HashSet<Integer>());
            graph.get(ppid.get(i)).add(pid.get(i));
        }
        
        dfs(graph, kill, ans);
        
        return ans;
    }
    
    private void dfs(Map<Integer, Set<Integer>> graph, int kill, List<Integer> ans){
        ans.add(kill);
        if(!graph.containsKey(kill)) return;
        
        for(int process : graph.get(kill)){
            dfs(graph, process, ans);
        }
    }
}