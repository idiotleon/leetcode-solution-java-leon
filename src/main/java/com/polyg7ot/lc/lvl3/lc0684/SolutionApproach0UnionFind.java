/**
 * https://leetcode.com/problems/redundant-connection
 * 
 * Time Complexity: O(N) ~ O(lg(N)) with union by rank and path compression
 * Time Complexity: O(N)
 * 
 * Similar Problems:
 *  https://leetcode.com/problems/redundant-connection-ii/
 */
package com.polyg7ot.lc.lvl3.lc0684;

public class SolutionApproach0UnionFind {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parents = new int[2001];
        for(int i = 0; i < parents.length; i++){
            parents[i] = i;
        }
        
        for(int[] edge : edges){
            int vertex1 = edge[0], vertex2 = edge[1];
            int parent1 = find(parents, vertex1), parent2 = find(parents, vertex2);
            if(parent1 == parent2) return edge;
            else parents[parent2] = parent1;
        }
        
        return new int[2];
    }
    
    private int find(int[] parents, int x){
        if(x != parents[x]){
            // path compression
            parents[x] = find(parents, parents[x]);
        }
        return parents[x];
    }
}