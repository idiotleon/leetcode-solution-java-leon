/**
 * https://leetcode.com/problems/accounts-merge/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/accounts-merge/discuss/109157/JavaC++-Union-Find/241144
 */
package com.an7one.leetcode.lvl3.lc0721;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class SolutionApproach0BFS {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> ans = new ArrayList<List<String>>();
        // sanity check
        if(accounts == null || accounts.isEmpty()) return ans;
        
        Map<String, Set<String>> graph = new HashMap<String, Set<String>>();
        Map<String, String> emailToName = new HashMap<String, String>();
        
        /**
         * to build up the undirected graph
         * 
         * e.g.:
         * {
         *  johnnybravo@mail.com=[], 
         *  johnsmith@mail.com=[john00@mail.com, john_newyork@mail.com], 
         *  john00@mail.com=[johnsmith@mail.com], 
         *  john_newyork@mail.com=[johnsmith@mail.com], 
         *  mary@mail.com=[]
         * }
         */
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
        
        // BFS
        Set<String> visited = new HashSet<String>();
        for(String email: graph.keySet()){
            if(!visited.contains(email)){
                visited.add(email);
                List<String> newList = bfs(graph, visited, email);
                Collections.sort(newList);
                newList.add(0, emailToName.get(newList.get(0)));
                ans.add(newList);
            }
        }
        
        return ans;
    }
    
    // the acutal implementation of BFS (of an undirected graph)
    private List<String> bfs(Map<String, Set<String>> graph, Set<String> visited, String startPos){
        List<String> newList = new ArrayList<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.offer(startPos);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String curEmail = queue.poll();
                newList.add(curEmail);
                Set<String> neighbors = graph.get(curEmail);
                for(String neigbhor : neighbors){
                    if(!visited.contains(neigbhor)){
                        visited.add(neigbhor);
                        queue.offer(neigbhor);
                    }
                }
            }
        }
        
        return newList;
    }
}