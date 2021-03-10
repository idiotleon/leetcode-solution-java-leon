/**
 * https://leetcode.com/problems/my-calendar-i/
 * 
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(N)
 */
package com.an7one.leetcode.ood.lvl3.lc0729;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach1BrutalForce {
    private List<int[]> bookings;

    public SolutionApproach1BrutalForce() {
        this.bookings = new ArrayList<int[]>();
    }

    public boolean book(int start, int end) {
        for (int[] booking : bookings) {
            if (Math.max(booking[0], start) < Math.min(booking[1], end)) {
                return false;
            }
        }

        bookings.add(new int[] { start, end });
        return true;
    }
}