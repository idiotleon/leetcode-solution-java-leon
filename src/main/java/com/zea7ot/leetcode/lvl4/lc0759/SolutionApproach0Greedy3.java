/**
 * https://leetcode.com/problems/employee-free-time/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/employee-free-time/discuss/113121/O(n-*-lg(n))-short-java-solution
 */
package com.zea7ot.leetcode.lvl4.lc0759;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SolutionApproach0Greedy3 {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> ans = new ArrayList<Interval>();
        // sanity check
        if (schedule == null || schedule.isEmpty())
            return ans;

        List<Interval> timeline = new ArrayList<Interval>();
        schedule.forEach(list -> timeline.addAll(list));
        Collections.sort(timeline, (a, b) -> Integer.compare(a.start, b.start));

        int end = timeline.get(0).end;
        for (Interval cur : timeline) {
            if (cur.start > end) {
                ans.add(new Interval(end, cur.start));
            }
            end = Math.max(end, cur.end);
        }

        return ans;
    }
}