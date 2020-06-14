package com.zea7ot.lc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TreeAncestor {

    public static void main(String[] args){
        final int[] nums = {-1,0,0,1,1,2,2};

        TreeAncestor treeAncestor = new TreeAncestor(nums.length, nums);
        treeAncestor.getKthAncestor(3, 1);
    }

    private Map<Integer, List<Integer>> map;

    public TreeAncestor(int n, int[] parent) {
        this.map = new HashMap<Integer, List<Integer>>();
        map.put(0, new ArrayList<Integer>());
        // map.get(0).add(0);
        
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
        // if(!map.containsKey(node)) return -1;
        if(k >= map.get(node).size()) return -1;
        
        return map.get(node).get(k - 1);
    }
}