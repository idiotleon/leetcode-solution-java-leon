/**
 * https://leetcode.com/problems/merge-intervals/
 */
package com.zea7ot.lc.lvl3.lc0056;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution{
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (interval1, interval2) -> interval1[0] - interval2[0]);
        
        LinkedList<int[]> merged = new LinkedList<int[]>();
        for(int[] interval : intervals){
            if(merged.isEmpty() || merged.getLast()[1] < interval[0]){ 
                merged.add(interval);
            }else{
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        
        return merged.toArray(new int[merged.size()][2]);
    }
}