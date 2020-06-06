/**
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 * 
 * Time Complexity: O(MN), with M being length of edges(int[][]), N being length of all nodes(n)
 * Space Complexity: O(N)
 */
package com.zea7ot.lc.lvl3.lc0323;

import java.util.Arrays;

public class SolutionApproach1UnionFindNaively {
    public int countComponents(int n, int[][] edges) {
        int[] parents = new int[n];
        Arrays.fill(parents, -1);
        
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
        if(parents[i] == -1) return i;
        return find(parents, parents[i]);
    }
}