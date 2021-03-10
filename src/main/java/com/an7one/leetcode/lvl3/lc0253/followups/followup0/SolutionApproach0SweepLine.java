/**
 * https://leetcode.com/problems/meeting-rooms-ii/
 * could you please output the schedules of all meeting rooms, in below orders:
 *  1. to sorted by meeting room IDs
 *  2. with 1 satisfied, to sort by starting time
 * 
 * e.g.: 
 *  given input:
 *      intervals: [[0, 30], [5, 10], [15, 20]]
 * 
 * expected output for reference:
 *  [0, 0, 30], means that meeting room, ID 0, is occupied from 0 to 30
 *  [1, 5, 10], means that meeting room, ID 1, is occupied from 5 to 10
 *  [1, 15, 20], means that meeting room, ID 1, is occupied from 15 to 20
 * or
 *  {{[0, 30]}, {[5, 10], [15, 20]}}
 */
package com.an7one.leetcode.lvl3.lc0253.followups.followup0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SolutionApproach0SweepLine {
    public List<List<int[]>> meetingRoomsSchedules(int[][] intervals) {
        List<List<int[]>> ans = new ArrayList<>();
        // sanity check
        if (intervals == null || intervals.length == 0)
            return ans;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        final Map<Integer, Integer> TIMELINE = new TreeMap<>();
        for (int[] interval : intervals) {
            final int START = interval[0];
            final int END = interval[1];

            TIMELINE.put(START, TIMELINE.getOrDefault(START, 0) + 1);
            TIMELINE.put(END, TIMELINE.getOrDefault(END, 0) - 1);
        }

        // 0-indexed
        int id = 0;
        int prevFreq = 0;
        List<List<int[]>> schedules = new ArrayList<>();

        int curFreq = 0;
        for (Map.Entry<Integer, Integer> entry : TIMELINE.entrySet()) {
            curFreq += entry.getValue();

            int curTimestamp = entry.getKey();
            if (prevFreq < curFreq) {
                final int SIZE = schedules.size();
                if (SIZE < id + 1)
                    schedules.add(new ArrayList<>());
                schedules.get(id).add(new int[] { curTimestamp, -1 });
                ++id;
            } else if (prevFreq > curFreq) {
                --id;
                final int IDX_LAST = schedules.get(id).size() - 1;
                schedules.get(id).get(IDX_LAST)[1] = curTimestamp;
            }

            prevFreq = curFreq;
        }

        return schedules;
    }
}
