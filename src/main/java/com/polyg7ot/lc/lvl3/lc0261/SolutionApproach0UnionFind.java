/**
 * https://leetcode.com/problems/graph-valid-tree/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
package com.polyg7ot.lc.lvl3.lc0261;

import java.util.Arrays;

public class SolutionApproach0UnionFind {
    public boolean validTree(int n, int[][] edges) {
        int[] nums = new int[n];
        Arrays.fill(nums, -1);
        
        // to perform union find
        for(int i = 0; i < edges.length; i++){
            int rootx = find(nums, edges[i][0]);
            int rooty = find(nums, edges[i][1]);
            
            // if two vertices happen to be in the same set
            // then there is a cycle
            if(rootx == rooty) return false;
            
            // to union
            nums[rootx] = rooty;
        }
        
        return edges.length == n - 1;
    }
    
    private int find(int[] nums, int i){
        if(nums[i] == -1) return i;
        return find(nums, nums[i]);
    }
}