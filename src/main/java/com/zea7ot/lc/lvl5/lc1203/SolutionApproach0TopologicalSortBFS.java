/**
 * https://leetcode.com/problems/sort-items-by-groups-respecting-dependencies/
 * 
 * Time Complexity:     O(V + E) ~ O()
 * Space Complexity:    O(V + E) ~ O()
 * 
 * References:
 *  https://leetcode.com/problems/sort-items-by-groups-respecting-dependencies/discuss/389805/JAVA-Topological-sort.-Detailed-Explanation
 */
package com.zea7ot.lc.lvl5.lc1203;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionApproach0TopologicalSortBFS {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        for(int i = 0; i < n; i++){
            if(group[i] == -1) {
                group[i] = m++;
            }
        }
        
        int[] countsGroup = new int[m];
        List<List<Integer>> graphGroups = buildGraphGroups(group, beforeItems, countsGroup, m, n);
        
        int[] countsItem = new int[n];
        List<List<Integer>> graphItems = buildGraphItems(beforeItems, countsItem, n);
        
        // to acquire the topologically sorted groups and items
        List<Integer> groupsSorted = topologicalSort(graphGroups, countsGroup);
        List<Integer> itemsSorted = topologicalSort(graphItems, countsItem);
        // to detect any cycle
        if(groupsSorted.isEmpty() || itemsSorted.isEmpty()) return new int[0];
        
        // to build up the relationship between sorted groups and sorted items
        List<List<Integer>> groupsToItems = new ArrayList<List<Integer>>(m);
        for(int i = 0; i < m; i++){
            groupsToItems.add(new ArrayList<Integer>());
        }
        for(int item : itemsSorted){
            groupsToItems.get(group[item]).add(item);
        }
        
        // to generate the answer array
        int[] ans = new int[n];
        int idx = 0;
        // to first pick, in front groups, front elements/items 
        for(int curGroup : groupsSorted){
            for(int item : groupsToItems.get(curGroup)) {
                ans[idx++] = item;
            }
        }
                
        return ans;
    }
    
    private List<Integer> topologicalSort(List<List<Integer>> graph, int[] counts){
        final int N = counts.length;
        List<Integer> res = new ArrayList<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < N; i++){
            if(counts[i] == 0){
                queue.add(i);
            }
        }
        
        int count = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            res.add(node); 
            count++;
            for(int neighbor : graph.get(node)){
                if(--counts[neighbor] == 0){
                    queue.offer(neighbor);
                }
            }
        }
        
        return count == N ? res : new ArrayList<Integer>();
    }
    
    private List<List<Integer>> buildGraphItems(List<List<Integer>> beforeItems, 
                                                int[] counts, 
                                                int n){
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i < n; i++){
            List<Integer> items = beforeItems.get(i);
            for(int item : items){
                graph.get(item).add(i);
                ++counts[i];
            }
        }
        
        return graph;
    }
    
    private List<List<Integer>> buildGraphGroups(int[] group, 
                                                 List<List<Integer>> beforeItems, 
                                                 int[] counts, 
                                                 int m,
                                                 int n){
        List<List<Integer>> graph = new ArrayList<List<Integer>>(m);
        for(int i = 0; i < m; i++){
            graph.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i < n; i++){
            int toGroup = group[i];
            List<Integer> fromItems = beforeItems.get(i);
            for(int fromItem : fromItems){
                int fromGroup = group[fromItem];
                if(fromGroup != toGroup){
                    graph.get(fromGroup).add(toGroup);
                    ++counts[toGroup];
                }
            }
        }
        
        return graph;
    }
}