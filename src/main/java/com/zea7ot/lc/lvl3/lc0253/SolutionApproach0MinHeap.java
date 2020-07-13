/**
 * https://leetcode.com/problems/meeting-rooms-ii/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(N)
 */
package com.zea7ot.lc.lvl3.lc0253;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SolutionApproach0MinHeap {
    public int minMeetingRooms(int[][] intervals) {
        // sanity check
        if(intervals == null || intervals.length == 0) return 0;
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for(int[] interval : intervals){
            if(!minHeap.isEmpty() && interval[0] >= minHeap.peek()) minHeap.poll();
            minHeap.add(interval[1]);
        }
        
        return minHeap.size();
    }
}