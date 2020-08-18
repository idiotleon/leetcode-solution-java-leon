/**
 * https://leetcode.com/problems/employee-free-time/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/employee-free-time/discuss/113134/Simple-Java-Sort-Solution-Using-(Priority-Queue)-or-Just-ArrayList
 */
package com.zea7ot.leetcode.lvl4.lc0759;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SolutionApproach0Greedy2 {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> ans = new ArrayList<Interval>();
        // sanity check
        if (schedule == null || schedule.isEmpty())
            return ans;

        Queue<Interval> minHeap = new PriorityQueue<Interval>((a, b) -> Integer.compare(a.start, b.start));
        schedule.forEach(list -> minHeap.addAll(list));

        Interval prev = minHeap.poll();
        while (!minHeap.isEmpty()) {
            if (prev.end < minHeap.peek().start) { // no intersection
                ans.add(new Interval(prev.end, minHeap.peek().start));
                prev = minHeap.poll();
            } else {
                prev = prev.end < minHeap.peek().end ? minHeap.peek() : prev;
                minHeap.poll();
            }
        }

        return ans;
    }

}