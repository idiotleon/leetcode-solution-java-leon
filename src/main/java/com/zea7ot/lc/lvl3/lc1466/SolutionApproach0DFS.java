/**
 * @author: Leon
 * https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
package com.zea7ot.lc.lvl3.lc1466;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionApproach0DFS {
    public int minReorder(int n, int[][] connections) {
        // sanity check
        if(n <= 0 
            || connections == null 
            || connections.length == 0 
            || connections[0].length == 0) return 0;

        Map<Integer, List<Integer>> inMap = new HashMap<Integer, List<Integer>>();
        Map<Integer, List<Integer>> outMap = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < n; i++){
            inMap.put(i, new ArrayList<Integer>());
            outMap.put(i, new ArrayList<Integer>());
        }
        
        for(int[] conn : connections){
            int from = conn[0], to = conn[1];
            
            inMap.get(to).add(from);
            outMap.get(from).add(to);
        }
        
        int[] ans = new int[1];
        int[] visited = new int[n];
        dfs(inMap, outMap, visited, 0, ans);
        
        return ans[0];
    }
    
    private void dfs(Map<Integer, List<Integer>> inMap, 
                     Map<Integer, List<Integer>> outMap, 
                     int[] visited,
                     int city, 
                     int[] count){
        
        if(visited[city] == 1) return;
        visited[city] = 1;
        
        for(int in : inMap.get(city)){
            if(in == 0) continue;
            dfs(inMap, outMap, visited, in, count);
        }
        
        for(int out : outMap.get(city)){
            if(visited[out] == 0) count[0]++;
            dfs(inMap, outMap, visited, out, count);
        }
    }
}