/**
 * https://leetcode.com/problems/merge-intervals/
 */

package main.java.lcidiot.lc0056;

import java.util.Arrays;
import java.util.LinkedList;

class Solution{
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        
        LinkedList<int[]> merged = new LinkedList<int[]>();
        for(int[] interval : intervals)
            if(merged.isEmpty() || merged.getLast()[1] < interval[0]) 
                merged.add(interval);
            else
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
        
        return merged.toArray(new int[merged.size()][]);
    }
}