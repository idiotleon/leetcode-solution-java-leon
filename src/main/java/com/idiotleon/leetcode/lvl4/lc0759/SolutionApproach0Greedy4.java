/**
 * https://leetcode.com/problems/employee-free-time/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/employee-free-time/discuss/113134/Simple-Java-Sort-Solution-Using-(Priority-Queue)-or-Just-ArrayList
 */
package com.idiotleon.leetcode.lvl4.lc0759;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SolutionApproach0Greedy4 {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> ans = new ArrayList<Interval>();
        // sanity check
        if (schedule == null || schedule.isEmpty())
            return ans;

        List<Interval> timeline = new ArrayList<Interval>();
        schedule.forEach(list -> timeline.addAll(list));
        Collections.sort(timeline, (a, b) -> Integer.compare(a.start, b.start));

        Interval prev = timeline.get(0);
        for (Interval cur : timeline) {
            if (prev.end < cur.start) {
                ans.add(new Interval(prev.end, cur.start));
                prev = cur;
            } else
                prev = prev.end < cur.end ? cur : prev;
        }

        return ans;
    }
}