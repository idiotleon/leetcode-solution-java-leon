/**
 * https://leetcode.com/problems/accounts-merge/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/accounts-merge/discuss/109157/JavaC++-Union-Find/241144
 */
package com.zea7ot.leetcode.lvl3.lc0721;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SolutionApproach0DFSRecursive {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> ans = new ArrayList<List<String>>();
        // sanity check
        if(accounts == null || accounts.isEmpty()) return ans;
        
        Map<String, Set<String>> graph = new HashMap<String, Set<String>>();
        Map<String, String> emailToName = new HashMap<String, String>();
        
        // to build up the undirected graph,
        // as well the as the owner table/map
        for(List<String> account : accounts){
            String name = account.get(0);
            final int SIZE = account.size();
            for(int i = 1; i < SIZE; i++){
                graph.putIfAbsent(account.get(i), new HashSet<String>());
                emailToName.put(account.get(i), name);
                
                if(i != 1){
                    graph.get(account.get(i)).add(account.get(i - 1));
                    graph.get(account.get(i - 1)).add(account.get(i));
                }
            }
        }
        
        // DFS
        Set<String> visited = new HashSet<String>();
        for(String email : graph.keySet()){
            if(!visited.contains(email)){
                visited.add(email);
                List<String> newList = new ArrayList<String>();
                dfs(graph, newList, visited, email);
                Collections.sort(newList);
                newList.add(0, emailToName.get(newList.get(0)));
                ans.add(newList);
            }
        }
        
        return ans;
    }
    
    // the actual implementation of DFS
    private void dfs(Map<String, Set<String>> graph, List<String> result, Set<String> visited, String curPoint){
        result.add(curPoint);
        Set<String> neighbors = graph.get(curPoint);
        for(String neighbor : neighbors){
            if(!visited.contains(neighbor)){
                visited.add(neighbor);
                dfs(graph, result, visited, neighbor);
            }
        }
    }
}