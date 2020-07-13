/**
 * https://leetcode.com/problems/employee-free-time/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(N)
 * 
 * a non-overlapping interval exists when "score" becomes 0.
 * 
 * References:
 *  https://leetcode.com/problems/employee-free-time/discuss/175081/Sweep-line-Java-with-Explanations
 */
package com.zea7ot.lc.lvl4.lc0759;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SolutionApproach0SweepLine {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> ans = new ArrayList<Interval>();
        // sanity check
        if(schedule == null || schedule.isEmpty()) return ans;
        
        Map<Integer, Integer> timeline = new TreeMap<Integer, Integer>(); // key: timestamp, value: score
        schedule.forEach(list -> {
            for(Interval interval : list){
                timeline.put(interval.start, timeline.getOrDefault(interval.start, 0) + 1);
                timeline.put(interval.end, timeline.getOrDefault(interval.end, 0) - 1);
            }
        });
        
        int start = -1, score = 0;
        for(Map.Entry<Integer, Integer> entry : timeline.entrySet()){
            int snap = entry.getKey();
            score += entry.getValue();
            if(score == 0 && start == -1) start = snap;
            else if(start != -1 && score != 0){
                ans.add(new Interval(start, snap));
                start = -1;
            }
        }
        
        return ans;
    }
}