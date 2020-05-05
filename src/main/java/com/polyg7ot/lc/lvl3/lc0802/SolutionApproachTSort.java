/**
 * https://leetcode.com/problems/find-eventual-safe-states/
 * 
 * Time Complexity: O(V + E) ~ O(N + graph.length)
 * Space Complexity: O(V + E) ~ O(N + graph.length)
 */
package com.polyg7ot.lc.lvl3.lc0802;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SolutionApproachTSort {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<Integer>();
        if(graph == null || graph.length == 0) return ans;
        
        final int N = graph.length;
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        for(int i = 0; i < N; i++){
            map.put(i, new HashSet<Integer>());
        }
        
        int[] indegrees = new int[N];
        for(int parent = 0; parent < N; parent++){
            for(int j = 0; j < graph[parent].length; j++){
                int child = graph[parent][j];
                map.get(child).add(parent);
                
                ++indegrees[parent];
            }
            
            // equivalent
            // indegrees[parent] = graph[parent].length;
        }
        
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < N; i++){
            if(indegrees[i] == 0){
                queue.add(i);
            }
        }
        
        while(!queue.isEmpty()){
            int cur = queue.removeFirst();
            ans.add(cur);
            
            for(int parent : map.get(cur)){
                if(--indegrees[parent] == 0){
                    queue.add(parent);
                }
            }
        }
        
        Collections.sort(ans);
        
        return ans;
    }
}