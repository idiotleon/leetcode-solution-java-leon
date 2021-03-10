/**
 * https://leetcode.com/problems/my-calendar-ii/
 * 
 * Time Complexity:     O((N ^ 2) * lg(N))
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/my-calendar-ii/discuss/109522/Simplified-winner's-solution/111433
 *  https://leetcode.com/problems/my-calendar-ii/discuss/109522/Simplified-winner's-solution
 *  https://leetcode.com/problems/my-calendar-ii/discuss/109522/Simplified-winner's-solution/375247
 */
package com.an7one.leetcode.ood.lvl3.lc0731;

import java.util.Map;
import java.util.TreeMap;

public class SolutionApproach2SweepLine {
    private Map<Integer, Integer> timeline;

    public SolutionApproach2SweepLine() {
        this.timeline = new TreeMap<Integer, Integer>();
    }

    public boolean book(int start, int end) {
        timeline.put(start, timeline.getOrDefault(start, 0) + 1);
        timeline.put(end, timeline.getOrDefault(end, 0) - 1);
        int booked = 0;
        for (Map.Entry<Integer, Integer> entry : timeline.entrySet()) {
            if (entry.getKey() >= end)
                return true;
            booked += entry.getValue();
            if (booked == 3) {
                timeline.put(start, timeline.get(start) - 1);
                timeline.put(end, timeline.get(end) + 1);
                return false;
            }
        }

        return true;
    }
}