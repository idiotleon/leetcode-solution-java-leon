/**
 * https://leetcode.com/problems/time-needed-to-inform-all-employees/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/time-needed-to-inform-all-employees/discuss/533109/Java-BFSDFS-Solutions-Clean-code
 */
package com.idiotleon.leetcode.lvl3.lc1376;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0DFS {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> graph = buildGraph(n, manager);
        return dfs(graph, headID, informTime);
    }
    
    private int dfs(List<List<Integer>> graph, int manager, int[] informTime){
        int max = 0;
        for(int employee : graph.get(manager)){
            max = Math.max(max, dfs(graph, employee, informTime));
        }
        return max + informTime[manager];
    }

    private List<List<Integer>> buildGraph(int n, int[] manager){
        List<List<Integer>> graph = new ArrayList<List<Integer>>(n);
        for(int i = 0; i < n; i++) graph.add(new ArrayList<Integer>());
        for(int i = 0; i < n; i++){
            int mgr = manager[i];
            if(mgr != -1){
                graph.get(mgr).add(i);
            }
        }
        return graph;
    }
}