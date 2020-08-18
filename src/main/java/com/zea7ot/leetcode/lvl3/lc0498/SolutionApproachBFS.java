/**
 * https://leetcode.com/problems/diagonal-traverse/
 */
package com.zea7ot.leetcode.lvl3.lc0498;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SolutionApproachBFS {
    public int[] findDiagonalOrder(int[][] matrix) {
        // sanity check
        if(matrix == null || matrix.length == 0) return new int[0];
        
        final int NR = matrix.length, NC = matrix[0].length;
        
        Map<Integer, ArrayList<Integer>> idxMap = new HashMap<Integer, ArrayList<Integer>>();
        for(int row = 0; row < NR; row++){
            for(int col = 0; col < NC; col++){
                // characterization of coordinates of diagonals (vs anti-diagonals)
                int key = row + col;
                idxMap.putIfAbsent(key, new ArrayList<Integer>());
                if(key % 2 == 0){
                    idxMap.get(key).add(0, matrix[row][col]);
                }else{
                    idxMap.get(key).add(matrix[row][col]);
                }
            }
        }
        
        int[] ans = new int[NR * NC];
        int idx = 0;
        for(int key : idxMap.keySet()){
            for(int val : idxMap.get(key)){
                ans[idx++] = val;
            }
        }
        
        return ans;
    }
}