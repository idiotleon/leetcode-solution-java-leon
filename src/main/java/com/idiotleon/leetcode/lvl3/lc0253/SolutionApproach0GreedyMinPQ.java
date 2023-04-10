/**
 * https://leetcode.com/problems/meeting-rooms-ii/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(N)
 */
package com.idiotleon.leetcode.lvl3.lc0253;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SolutionApproach0GreedyMinPQ {
    public int minMeetingRooms(int[][] intervals) {
        // sanity check
        if (intervals == null || intervals.length == 0)
            return 0;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int[] interval : intervals) {
            int start = interval[0], end = interval[1];
            if (!minHeap.isEmpty() && start >= minHeap.peek())
                minHeap.poll();

            minHeap.add(end);
        }

        return minHeap.size();
    }
}