/**
 * https://leetcode.com/problems/remove-interval/
 * 
 * Time Complexity:     O(N)
 * 
 * Space Complexity:    O(1) + O(N)
 *  O(N), consumed by the answer list
 * 
 * References:
 *  https://leetcode.com/problems/remove-interval/discuss/440887/python-my-simple-4-if-conditions/396763
 */
package com.idiotleon.leetcode.lvl3.lc1272;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionApproach0SweepLine {
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
            if(start < toBeRemoved[0] && toBeRemoved[0] < end){
                ans.add(Arrays.asList(start, toBeRemoved[0]));
            }
            
            if(start < toBeRemoved[1] && toBeRemoved[1] < end){
                ans.add(Arrays.asList(toBeRemoved[1], end));
            }
            
            if(start >= toBeRemoved[1] || end <= toBeRemoved[0]){
                ans.add(Arrays.asList(start, end));
            }
        }
        
        return ans;
    }
}