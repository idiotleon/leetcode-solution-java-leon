/**
 * https://leetcode.com/problems/kth-ancestor-of-a-tree-node/
 * 
 * Not Finished Yet
 * 
 * Time Complexities:
 *  getKthAncestor():   
 * 
 * Space Complexity:  O(N)
 */
package com.zea7ot.leetcode.lvl4.lc1483;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionApproach1ControlledDFSMemo {
    private Map<Integer, List<Integer>> map;
    private int[] parents;

    public SolutionApproach1ControlledDFSMemo(int n, int[] parents) {
        this.map = new HashMap<Integer, List<Integer>>();
        this.parents = parents;
    }
    
    private int dfs(int node, int further){
        if(node == -1) return -1;
        int parent = parents[node];
        if(further == 1) return parent;

        if(map.containsKey(parent)) {
            List<Integer> parentList = map.get(parent);
            parentList.add(0, parent);
            if(parentList.size() > further) return parentList.get(further);
            if(parentList.size() < further && isComplete(parentList)) return -1;

            map.putIfAbsent(node, new ArrayList<Integer>());
            // map.get(node).add(parent);
            map.get(node).addAll(parentList);
            int tail = getTail(parentList);
            return dfs(tail, further - parentList.size() - 1);
        }
        
        map.putIfAbsent(node, new ArrayList<Integer>());
        map.get(node).add(parent);
        
        return dfs(parent, further - 1);
    }
    
    public int getKthAncestor(int node, int k) {
        List<Integer> parentList = map.get(node);
        if(parentList == null || parentList.isEmpty()) return dfs(node, k);
        if(k > parentList.size()) {
            if(isComplete(parentList)) return -1;
            return dfs(getTail(parentList), k - parentList.size());
        }
        
        return parentList.get(k - 1);
    }

    private boolean isComplete(List<Integer> list){
        return list.get(list.size() - 1) == -1;
    }
    
    private int getTail(List<Integer> list){
        return list.get(list.size() - 1);
    }
}