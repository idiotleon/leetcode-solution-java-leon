/**
 * https://leetcode.com/problems/meeting-rooms-ii/
 */
package com.null7ptr.lc.lvl3.lc0253;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SolutionApproachHeap {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(intervals.length, (a, b) -> a - b);
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        heap.add(intervals[0][1]);
        
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] >= heap.peek()) heap.poll();
            heap.add(intervals[i][1]);
        }
        
        return heap.size();
    }
}