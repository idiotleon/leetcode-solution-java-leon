/**
 * https://leetcode.com/problems/my-calendar-i/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/my-calendar-i/discuss/109475/JavaC++-Clean-Code-with-Explanation/113896
 *  https://leetcode.com/problems/my-calendar-i/discuss/109475/JavaC%2B%2B-Clean-Code-with-Explanation
 */
package com.an7one.leetcode.ood.lvl3.lc0729;

import java.util.TreeMap;

public class SolutionApproach0SweepLine {
    private TreeMap<Integer, Integer> timeline;

    public SolutionApproach0SweepLine() {
        this.timeline = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer low = timeline.lowerKey(end);

        if (low == null || timeline.get(low) <= start) {
            timeline.put(start, end);
            return true;
        }

        return false;
    }
}