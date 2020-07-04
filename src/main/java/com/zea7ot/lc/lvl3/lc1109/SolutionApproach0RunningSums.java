/**
 * https://leetcode.com/problems/corporate-flight-bookings/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/corporate-flight-bookings/discuss/328871/C%2B%2BJava-with-picture-O(n)
 */
package com.zea7ot.lc.lvl3.lc1109;

public class SolutionApproach0RunningSums {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        for(int[] booking : bookings){
            ans[booking[0] - 1] += booking[2];
            if(booking[1] < n) ans[booking[1]] -= booking[2];
        }
        
        for(int i = 1; i < n; ++i)
            ans[i] += ans[i - 1];
        
        return ans;
    }
}