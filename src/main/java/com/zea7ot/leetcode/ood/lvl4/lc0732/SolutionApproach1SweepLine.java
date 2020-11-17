/**
 * https://leetcode.com/problems/my-calendar-iii/
 * 
 * Time Complexity:     O((N ^ 2) * lg(N))
 *  
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/my-calendar-iii/discuss/109556/JavaC%2B%2B-Clean-Code
 *  https://leetcode.com/problems/my-calendar-iii/discuss/442127/Simple-C%2B%2B-Linesweep-Solution-with-Explanation-or-Then-Explanation-of-Added-Optimization
 */
package com.zea7ot.leetcode.ood.lvl4.lc0732;

import java.util.Map;
import java.util.TreeMap;

public class SolutionApproach1SweepLine {
    private Map<Integer, Integer> timeline;

    public SolutionApproach1SweepLine() {
        this.timeline = new TreeMap<Integer, Integer>();
    }

    public int book(int start, int end) {
        timeline.put(start, timeline.getOrDefault(start, 0) + 1);
        timeline.put(end, timeline.getOrDefault(end, 0) - 1);
        int ongoing = 0, k = 0;
        for (int val : timeline.values())
            k = Math.max(k, ongoing += val);

        return k;
    }
}