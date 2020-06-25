/**
 * https://leetcode.com/problems/sort-items-by-groups-respecting-dependencies/
 * 
 * Time Complexity:     O(V + E) ~ O()
 * Space Complexity:    O(V + E) ~ O()
 * 
 * References:
 * https://leetcode.com/problems/sort-items-by-groups-respecting-dependencies/discuss/440249/Java-two-round-DFS-sort
 */
package com.zea7ot.lc.lvl5.lc1203;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0TopologicalSortDFS {
    private static final int VISITING = 1;
    private static final int VISITED = 2;
    
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        for(int i = 0; i < n; i++){
            if(group[i] == -1) {
                group[i] = m++;
            }
        }
        
        List<List<Integer>> graphGroups = buildGraphGroups(group, beforeItems, m, n);
        List<List<Integer>> graphItems = buildGraphItems(beforeItems, n);
        
        // to acquire the topologically sorted groups and items
        List<Integer> groupsSorted = new ArrayList<Integer>();
        int[] seenGroups = new int[m];
        for(int i = 0; i < m; i++){
            if(hasCycle(i, seenGroups, graphGroups, groupsSorted)){
                return new int[0];
            }
        }
        
        List<Integer> itemsSorted = new ArrayList<Integer>();
        int[] seenItems = new int[n];
        for(int i = 0; i < n; i++){
            if(hasCycle(i, seenItems, graphItems, itemsSorted)) {
                return new int[0];
            }
        }
        
        // to build up the relationship between sorted groups and sorted items
        List<List<Integer>> groupsToItems = new ArrayList<List<Integer>>(m);
        for(int i = 0; i < m; i++){
            groupsToItems.add(new ArrayList<Integer>());
        }
        for(int item : itemsSorted){
            groupsToItems.get(group[item]).add(item);
        }
        
        // to generate the answer array
        List<Integer> ans = new ArrayList<Integer>();
        // to pick, in front groups, front elements/items
        for(int curGroup : groupsSorted){
            for(int item : groupsToItems.get(curGroup)) {
                ans.add(item);
            }
        }
                
        return ans.stream().mapToInt(i -> i).toArray();
    }
    
    private boolean hasCycle(int vertex, 
                             int[] visited, 
                             List<List<Integer>> graph, 
                             List<Integer> res){
        if(visited[vertex] == VISITING) return true;
        if(visited[vertex] == VISITED) return false;
        
        visited[vertex] = VISITING;
        for(int next : graph.get(vertex)){
            if(hasCycle(next, visited, graph, res)){
                return true;
            }
        }
        
        visited[vertex] = VISITED;
        res.add(vertex);
        return false;
    }
    
    private List<List<Integer>> buildGraphItems(List<List<Integer>> beforeItems, 
                                                int n){
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i < n; i++){
            graph.get(i).addAll(beforeItems.get(i));
        }
        
        return graph;
    }
    
    private List<List<Integer>> buildGraphGroups(int[] group, 
                                                 List<List<Integer>> beforeItems, 
                                                 int m,
                                                 int n){
        List<List<Integer>> graph = new ArrayList<List<Integer>>(m);
        for(int i = 0; i < m; i++){
            graph.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i < n; i++){
            int curGroup = group[i];
            List<Integer> items = beforeItems.get(i);
            for(int beforeItem : items){
                int beforeGroup = group[beforeItem];
                if(curGroup != beforeGroup){
                    graph.get(curGroup).add(beforeGroup);
                }
            }
        }
        
        return graph;
    }
}