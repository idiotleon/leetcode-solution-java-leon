/**
 * https://leetcode.com/problems/remove-interval/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/remove-interval/discuss/440799/JavaPython-3-12-and-11-liners-w-brief-comments-and-analysis.
 */
package com.zea7ot.lc.lvl3.lc1272;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionApproach0SweepLine1 {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // sanity check
        if(intervals == null || intervals.length == 0) return ans;
        if(toBeRemoved == null || toBeRemoved.length == 0){
            for(int[] interval : intervals){
                ans.add(Arrays.asList(interval[0], interval[1]));
            }
            return ans;
        }
        
        for(int[] interval : intervals){
            int start = interval[0], end = interval[1];
            
            if(start >= toBeRemoved[1] || end <= toBeRemoved[0]){
                ans.add(Arrays.asList(start, end));
            }else{  // start < toBeRemoved[1] && end > toBeRemoved[0]
                if(start < toBeRemoved[0]){
                    ans.add(Arrays.asList(start, toBeRemoved[0]));
                }
                
                if(end > toBeRemoved[1]){
                    ans.add(Arrays.asList(toBeRemoved[1], end));
                }
            }
        }
        
        return ans;
    }
}