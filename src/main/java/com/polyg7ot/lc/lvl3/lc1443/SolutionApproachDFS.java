/**
 * https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(H), height of the tree
 * 
 * Bottom-up DFS
 */
package com.polyg7ot.lc.lvl3.lc1443;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SolutionApproachDFS {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        // to build up the tree
        Map<Integer, List<Integer>> tree = buildTree(edges);

        Set<Integer> visited = new HashSet<Integer>();
        
        return dfs(tree, hasApple, visited, 0);
    }
    
    private int dfs(Map<Integer, List<Integer>> tree, 
                    List<Boolean> hasApple, 
                    Set<Integer> visited, 
                    int start){
        if(visited.contains(start)) return 0;
        visited.add(start);
        
        int res = 0;
        
        for(int child : tree.getOrDefault(start, new ArrayList<Integer>())){
            res += dfs(tree, hasApple, visited, child);
        }
        
        if((res > 0 || hasApple.get(start)) && start != 0) res += 2;
        
        return res;
    }
    
    private Map<Integer, List<Integer>> buildTree(int[][] edges){
        Map<Integer, List<Integer>> tree = new HashMap<Integer, List<Integer>>();
        
        for(int[] edge : edges){
            tree.putIfAbsent(edge[0], new ArrayList<Integer>());
            tree.putIfAbsent(edge[1], new ArrayList<Integer>());
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        
        return tree;
    }
}