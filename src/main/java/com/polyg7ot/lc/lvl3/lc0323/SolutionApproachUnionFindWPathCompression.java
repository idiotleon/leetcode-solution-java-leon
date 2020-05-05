/**
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 * 
 * Time Complexity: O(N * lg(M)), with M being length of edges(int[][]), N being length of all nodes(n)
 * Space Complexity: O(N)
 */
package com.polyg7ot.lc.lvl3.lc0323;

public class SolutionApproachUnionFindWPathCompression {
    public int countComponents(int n, int[][] edges) {
        int[] parents = new int[n];
        for(int i = 0; i < n; i++){
            parents[i] = i;
        }
        
        int count = n;
        for(int[] edge : edges){
            int rootx = find(parents, edge[0]);
            int rooty = find(parents, edge[1]);
            
            if(rootx != rooty){
                parents[rooty] = rootx;
                count--;
            }
        }
        
        return count;
    }
    
    private int find(int[] parents, int i){
        // path compression
        if(parents[i] != i){
            parents[i] = find(parents, parents[i]);
        }
        
        return parents[i];
    }
}