/**
 * https://leetcode.com/problems/diagonal-traverse-ii/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
package com.zea7ot.leetcode.lvl3.lc1424;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class SolutionApproachBFS {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        // sanity check
        if(nums == null || nums.isEmpty()) return new int[0];
        
        // bondaries
        final int NR = nums.size();
        int max = 0, count = 0;
        for(int i = 0; i < NR; i++){
            count += nums.get(i).size();
            max = Math.max(max, nums.get(i).size());
        } 
        // for MOD/key-hashing purpose
        final int NC = max;
           
        int[] ans = new int[count];
        int idx = 0;
       
        Set<Integer> visited = new HashSet<Integer>();
        visited.add(hash(0, 0, NC));
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(hash(0, 0, NC));
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                int pos = queue.poll();
                int row = pos / NC, col = pos % NC;
                ans[idx++] = nums.get(row).get(col);
                
                if(isValid(nums, row + 1, col) && !visited.contains(hash(row + 1, col, NC))){
                    int hash = hash(row + 1, col, NC);
                    queue.add(hash);
                    visited.add(hash);
                }
                
                if(isValid(nums, row, col + 1) && !visited.contains(hash(row, col + 1, NC))){
                    int hash = hash(row, col + 1, NC);
                    queue.add(hash);
                    visited.add(hash);
                }
            }
        }
        
        return ans;
    }
    
    private int hash(int row, int col, final int NC){
        return row * NC + col;
    }
    
    private boolean isValid(List<List<Integer>> nums, int row, int col){
        if(row < 0 || row >= nums.size() || col < 0 || col >= nums.get(row).size()) return false;
        
        return true;
    }
}