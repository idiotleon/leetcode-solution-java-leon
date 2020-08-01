/**
 * https://leetcode.com/problems/employee-free-time/
 * 
 * Time Complexity:     O(N * lg(k))
 *  k, the number of employees, also the size of the "schedule"
 * 
 * Space Complexity:    O(k)
 *  k, the number of employees, also the size of the "schedule"
 * 
 * 
 * References:
 *  https://leetcode.com/problems/employee-free-time/discuss/113122/Merge-Sort-O(nlgK)-(Java)
 */
package com.zea7ot.lc.lvl4.lc0759;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Greedy1 {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> ans = new ArrayList<Interval>();
        // sanity check
        if (schedule == null || schedule.isEmpty())
            return ans;

        final int N = schedule.size();
        List<Interval> timeline = mergeSort(schedule, 0, N - 1);

        int end = timeline.get(0).end;
        for (Interval cur : timeline) {
            if (cur.start > end) {
                ans.add(new Interval(end, cur.start));
            }
            end = Math.max(end, cur.end);
        }

        return ans;
    }

    private List<Interval> mergeSort(List<List<Interval>> schedule, int lo, int hi) {
        if (lo == hi)
            return schedule.get(lo);
        int mid = lo + (hi - lo) / 2;
        List<Interval> left = mergeSort(schedule, lo, mid);
        List<Interval> right = mergeSort(schedule, mid + 1, hi);
        return merge(left, right);
    }

    private List<Interval> merge(List<Interval> list1, List<Interval> list2) {
        List<Interval> res = new ArrayList<Interval>();
        final int M = list1.size(), N = list2.size();
        int i = 0, j = 0;
        while (i < M || j < N) {
            if (i == M)
                res.add(list2.get(j++));
            else if (j == N)
                res.add(list1.get(i++));
            else if (list1.get(i).start < list2.get(j).start)
                res.add(list1.get(i++));
            else
                res.add(list2.get(j++));
        }
        return res;
    }
}