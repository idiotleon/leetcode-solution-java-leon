/**
 * https://leetcode.com/problems/meeting-rooms-ii/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(N)
 */
package com.zea7ot.lc.lvl3.lc0253;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class SolutionApproach0MinHeap {
    public int minMeetingRooms(int[][] intervals) {
        // sanity check
        if(intervals == null || intervals.length == 0) return 0;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);        
        Queue<Integer> minHeap = new PriorityQueue<Integer>();
        
        for(int i = 1; i < intervals.length; i++){
            if(!minHeap.isEmpty() && intervals[i][0] >= minHeap.peek()) minHeap.poll();
            minHeap.add(intervals[i][1]);
        }
        
        return minHeap.size();
    }
}