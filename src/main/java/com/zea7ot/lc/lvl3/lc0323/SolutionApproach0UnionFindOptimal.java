/**
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 * 
 * Union find with path compression, and union by size(rank)
 * 
 * Time Complexity:     O(N + alpha(N)) ~ O(n + edges.length)
 * Space Complexity:    O(n)
 * 
 * alpha(N): inverse Akermann function
 * 
 */
package com.zea7ot.lc.lvl3.lc0323;

public class SolutionApproach0UnionFindOptimal {
    public int countComponents(int n, int[][] edges) {
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = i;
        }
        // union by size(rank)
        int[] size = new int[n];
        
        int count = n;
        for(int[] edge : edges){
            int rootx = find(nums, edge[0]);
            int rooty = find(nums, edge[1]);
            
            if(rootx != rooty){
                if(size[rootx] < size[rooty]){
                    nums[rootx] = rooty;
                    size[rooty] += size[rootx];
                }else{
                    nums[rooty] = rootx;
                    size[rootx] += size[rooty];
                }
                count--;
            }
        }
        
        return count;
    }
    
    private int find(int[] nums, int i){
        // path compression
        if(nums[i] != i){
            nums[i] = find(nums, nums[i]);
        }
        
        return nums[i];
    }
}