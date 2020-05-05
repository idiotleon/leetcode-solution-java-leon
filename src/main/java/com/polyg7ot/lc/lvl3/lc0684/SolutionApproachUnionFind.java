/**
 * https://leetcode.com/problems/redundant-connection/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N);
 */
package com.polyg7ot.lc.lvl3.lc0684;

public class SolutionApproachUnionFind {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parents = new int[edges.length + 1];
        
        for(int[] edge : edges){
            int u = find(parents, edge[0]);
            int v = find(parents, edge[1]);
            if(u == v) return edge;
            parents[u] = v;
        }
        
        return new int[2];
    }
    
    private int find(int[] parents, int v){
        return parents[v] == 0 ? v : find(parents, parents[v]);
    }
}