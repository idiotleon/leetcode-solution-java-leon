/**
 * https://leetcode.com/problems/delete-tree-nodes/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/delete-tree-nodes/discuss/440914/Java-DFS-Time-O(N)-Clean-code
 */
package com.zea7ot.leetcode.lvl3.lc1273;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0DFS {
    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        for(int i = 0; i < nodes; i++) graph.add(new ArrayList<Integer>());
        for(int i = 0; i < nodes; i++){
            if(parent[i] != -1){
                graph.get(parent[i]).add(i);
            }
        }
        return dfs(graph, value, 0)[1];
    }
    
    private int[] dfs(List<List<Integer>> graph, int[] value, int node){
        int sum = value[node];
        int count = 1;
        for(int child : graph.get(node)){
            int[] temp = dfs(graph, value, child);
            sum += temp[0];
            count += temp[1];
        }
        
        if(sum == 0) count = 0;
        
        return new int[]{sum, count};
    }
}