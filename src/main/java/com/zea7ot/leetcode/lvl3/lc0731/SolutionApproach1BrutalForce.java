/**
 * https://leetcode.com/problems/my-calendar-ii/
 * 
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(2 * N) ~ O(N)
 * 
 * References:
 *  https://leetcode.com/problems/my-calendar-ii/discuss/109530/N2-Python-Short-and-Elegant/494341
 *  https://leetcode.com/problems/my-calendar-ii/discuss/109530/N2-Python-Short-and-Elegant
 */
package com.zea7ot.leetcode.lvl3.lc0731;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach1BrutalForce {
    private List<int[]> once;
    private List<int[]> twice;

    public SolutionApproach1BrutalForce() {
        this.once = new ArrayList<int[]>();
        this.twice = new ArrayList<int[]>();
    }

    public boolean book(int start, int end) {
        for (int[] interval : twice) {
            if (start < interval[1] && end > interval[0])
                return false;
        }

        for (int[] interval : once) {
            if (start < interval[1] && end > interval[0])
                twice.add(new int[] { Math.max(start, interval[0]), Math.min(end, interval[1]) });
        }

        once.add(new int[] { start, end });
        return true;
    }
}