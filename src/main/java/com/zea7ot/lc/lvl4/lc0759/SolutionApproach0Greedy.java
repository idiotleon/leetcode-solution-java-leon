/**
 * https://leetcode.com/problems/employee-free-time/
 * 
 * Time Complexity:     O(N * lg(k))
 *  k, the number of employees, also the size of the "schedule".
 * 
 * Space Complexity:    O(k)
 *  k, the number of employees, also the size of the "schedule".
 */
package com.zea7ot.lc.lvl4.lc0759;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SolutionApproach0Greedy {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> ans = new ArrayList<Interval>();
        // sanity check
        if (schedule == null || schedule.isEmpty())
            return ans;

        final int N = schedule.size();
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>(
                (a, b) -> Integer.compare(schedule.get(a[0]).get(a[1]).start, schedule.get(b[0]).get(b[1]).start));
        for (int i = 0; i < N; ++i)
            minHeap.add(new int[] { i, 0 });

        int prev = schedule.get(minHeap.peek()[0]).get(minHeap.peek()[1]).start;
        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            Interval cur = schedule.get(top[0]).get(top[1]);
            if (prev < cur.start) {
                ans.add(new Interval(prev, cur.start));
            }
            prev = Math.max(prev, cur.end);
            if (schedule.get(top[0]).size() > top[1] + 1) {
                minHeap.add(new int[] { top[0], top[1] + 1 });
            }
        }

        return ans;
    }
}