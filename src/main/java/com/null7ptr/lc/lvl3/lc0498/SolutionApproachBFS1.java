package com.null7ptr.lc.lvl3.lc0498;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class SolutionApproachBFS1 {
    private int NR, NC;
    
    public int[] findDiagonalOrder(int[][] matrix) {
        // sanity check
        if(matrix == null || matrix.length == 0) return new int[0];
        
        // boundaries
        NR = matrix.length;
        NC = matrix[0].length;
        
        int[] ans = new int[NR * NC];
        int idx = 0;
        
        // BFS
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(hash(0, 0));
        Set<Integer> visited = new HashSet<Integer>();
        visited.add(hash(0, 0));
        
        // Zig-Zag level order traversal
        List<Integer> intermediate = new ArrayList<Integer>();
        int level = 0;
        
        while(!queue.isEmpty()){
            intermediate.clear();
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                int pos = queue.poll();
                int row = pos / NC, col = pos % NC;
                
                if(level % 2 == 0) intermediate.add(pos);
                else intermediate.add(0, pos);
                
                if(isValid(row + 1, col) && !visited.contains(hash(row + 1, col))){
                    queue.add(hash(row + 1, col));
                    visited.add(hash(row + 1, col));
                }
                    
                if(isValid(row, col + 1) && !visited.contains(hash(row, col + 1))){
                    queue.add(hash(row, col + 1));
                    visited.add(hash(row, col + 1));
                }
            }
            
            for(int pos : intermediate){
                ans[idx++] = matrix[pos / NC][pos % NC];
            }
            
            level++;
        }
        
        return ans;
    }
    
    private int hash(int row, int col){
        return row * NC + col;
    }
    
    private boolean isValid(int row, int col){
        if(row < 0 || row >= NR || col < 0 || col >= NC) return false;
        
        return true;
    }
}