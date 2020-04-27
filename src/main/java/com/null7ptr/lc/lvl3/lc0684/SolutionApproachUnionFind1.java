/**
 * https://leetcode.com/problems/redundant-connection
 * 
 * Time Complexity: O(N) ~ O(lg(N)) with union by rank and path compression
 * Time Complexity: O(N)
 */
package com.null7ptr.lc.lvl3.lc0684;

public class SolutionApproachUnionFind1 {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[2001];
        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
        }
        
        for(int[] edge : edges){
            int f = edge[0], t = edge[1];
            if(find(parent, f) == find(parent, t)) return edge;
            else parent[find(parent, f)] = find(parent, t);
        }
        
        return new int[2];
    }
    
    private int find(int[] parent, int x){
        if(x != parent[x]){
            parent[x] = find(parent, parent[x]);
        }
        
        return parent[x];
    }
}