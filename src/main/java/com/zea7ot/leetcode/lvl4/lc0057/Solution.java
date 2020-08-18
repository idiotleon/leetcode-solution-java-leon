/**
 * https://leetcode.com/problems/insert-interval/
 */
package com.zea7ot.leetcode.lvl4.lc0057;

import java.util.ArrayList;
import java.util.List;

class Solution{
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        for(int[] interval : intervals)
            if(newInterval == null || interval[1] < newInterval[0])
                res.add(interval);
            else if(interval[0] > newInterval[1]){
                res.add(newInterval);
                res.add(interval);
                newInterval = null;
            }else{
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        
        if(newInterval != null) res.add(newInterval);
        
        return res.toArray(new int[res.size()][]);
    }
}