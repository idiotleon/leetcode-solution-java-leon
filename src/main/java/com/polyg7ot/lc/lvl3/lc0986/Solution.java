/**
 * https://leetcode.com/problems/interval-list-intersections/
 */
package com.polyg7ot.lc.lvl3.lc0986;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> result = new ArrayList<int[]>();
        int i = 0, j = 0;
        while(i < A.length && j < B.length){
            int start = Math.max(A[i][0], B[j][0]);
            int end = Math.min(A[i][1], B[j][1]);
            if(start <= end){
                result.add(new int[]{start, end});
            }
            
            if(A[i][1] > B[j][1]) j++;
            else i++;
        }
        
        return result.toArray(new int[result.size()][2]);
    }
}