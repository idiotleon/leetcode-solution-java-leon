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
package com.zea7ot.lc.lvl3.lc0253;

import java.util.Map;
import java.util.TreeMap;

public class SolutionApproach0SweepLine {
    public int minMeetingRooms(int[][] intervals) {
        // sanity check
        if(intervals == null || intervals.length == 0) return 0;
        
        Map<Integer, Integer> timeline = new TreeMap<Integer, Integer>();
        for(int[] interval : intervals){
            int start = interval[0], end = interval[1];
            timeline.put(start, timeline.getOrDefault(start, 0) + 1);
            timeline.put(end, timeline.getOrDefault(end, 0) - 1);
        }
        
        int count = 0, ans = 0;
        for(int val : timeline.values()){
            count += val;
            ans = Math.max(ans, count);
        }

        return ans;
    }
}