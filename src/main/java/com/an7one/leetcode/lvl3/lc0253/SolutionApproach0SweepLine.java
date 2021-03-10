/**
 * https://leetcode.com/problems/meeting-rooms-ii/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(N)
 * 
 * overlapped edge points are NOT counted, 
 *  eg: [[1, 2], [2, 3]] is considered as NOT overlapped
 * 
 * References:
 *  https://leetcode.com/problems/my-calendar-iii/discuss/109556/JavaC++-Clean-Code/111457
 */
package com.an7one.leetcode.lvl3.lc0253;

import java.util.Map;
import java.util.TreeMap;

public class SolutionApproach0SweepLine {
    public int minMeetingRooms(int[][] intervals) {
        // sanity check
        if (intervals == null || intervals.length == 0)
            return 0;

        final Map<Integer, Integer> TIMELINE = new TreeMap<>();
        for (int[] interval : intervals) {
            final int START = interval[0];
            final int END = interval[1];

            TIMELINE.put(START, TIMELINE.getOrDefault(START, 0) + 1);
            TIMELINE.put(END, TIMELINE.getOrDefault(END, 0) - 1);
        }

        int freq = 0, required = 0;
        for (Map.Entry<Integer, Integer> entry : TIMELINE.entrySet()) {
            freq += entry.getValue();
            required = Math.max(required, freq);
        }

        return required;
    }
}