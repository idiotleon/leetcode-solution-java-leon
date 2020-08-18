/**
 * https://leetcode.com/problems/my-calendar-i/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/my-calendar-i/discuss/109475/JavaC%2B%2B-Clean-Code-with-Explanation
 */
package com.zea7ot.leetcode.lvl3.lc0729;

import java.util.TreeSet;

public class SolutionApproach0TreeSet {
    private TreeSet<int[]> bookings;

    public SolutionApproach0TreeSet() {
        this.bookings = new TreeSet<int[]>((a, b) -> a[0] - b[0]);
    }
    
    public boolean book(int start, int end) {
        int[] booking = new int[]{start, end};
        int[] floor = bookings.floor(booking);
        int[] ceiling = bookings.ceiling(booking);
        // the new "booking" starts within the "floor"
        if(floor != null && start < floor[1]) return false;
        // the new "booking" ends within the "ceiling"
        if(ceiling != null && ceiling[0] < end) return false;
        bookings.add(booking);
        return true;
    }
}