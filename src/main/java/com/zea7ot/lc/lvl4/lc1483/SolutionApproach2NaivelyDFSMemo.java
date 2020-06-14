/**
 * https://leetcode.com/problems/kth-ancestor-of-a-tree-node/
 * 
 * TLEed
 * 
 * Time Complexities:
 *  initialization,     O(N)
 *  getKthAncestor(),   O(L)
 * 
 * Space Complexities:  O(N)
 */
package com.zea7ot.lc.lvl4.lc1483;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionApproach2NaivelyDFSMemo {
    private Map<Integer, List<Integer>> map;

    public SolutionApproach2NaivelyDFSMemo(int n, int[] parent) {
        this.map = new HashMap<Integer, List<Integer>>();
        map.put(0, new ArrayList<Integer>());
        
        for(int i = 0; i < n; i++){
            dfs(i, parent, map);
        }
    }
    
    private void dfs(int node, int[] parent, Map<Integer, List<Integer>> map){
        if(node == 0) return;
        if(map.containsKey(parent[node])) {
            map.putIfAbsent(node, new ArrayList<Integer>());
            map.get(node).add(parent[node]);
            map.get(node).addAll(map.get(parent[node]));
            return;
        }
        
        map.putIfAbsent(node, new ArrayList<Integer>());
        map.get(node).add(parent[node]);
        
        dfs(parent[node], parent, map);
    }
    
    public int getKthAncestor(int node, int k) {
        if(!map.containsKey(node)) return -1;
        if(k > map.get(node).size()) return -1;
        
        return map.get(node).get(k - 1);
    }
}