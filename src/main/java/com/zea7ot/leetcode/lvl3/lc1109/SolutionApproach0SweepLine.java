/**
 * https://leetcode.com/problems/corporate-flight-bookings/
 * 
 * Time Complexity:     O(`n`)
 * Space Complexity:    O(1) / O(`n`)
 * 
 * References:
 *  https://leetcode.com/problems/corporate-flight-bookings/discuss/328871/C%2B%2BJava-with-picture-O(n)
 */
package com.zea7ot.leetcode.lvl3.lc1109;

public class SolutionApproach0SweepLine {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        for (int[] booking : bookings) {
            // 0-indexed
            int iLabel = booking[0] - 1;
            int jLabel = booking[1];
            int seats = booking[2];
            ans[iLabel] += seats;
            if (jLabel < n)
                ans[jLabel] -= seats;
        }

        for (int i = 1; i < n; ++i)
            ans[i] += ans[i - 1];

        return ans;
    }
}