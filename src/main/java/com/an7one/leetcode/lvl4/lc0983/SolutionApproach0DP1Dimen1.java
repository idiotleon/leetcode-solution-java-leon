/**
 * https://leetcode.com/problems/minimum-cost-for-tickets/
 * 
 * Time Complexity:     O(N) ~ O(365)
 * Space Complexity:    O(365)
 * 
 * a bottom-up approach
 * 
 * References:
 *  https://leetcode.com/problems/minimum-cost-for-tickets/discuss/226672/JAVA-1-D-DP-Time-Space-O(1)
 *  https://leetcode.com/problems/minimum-cost-for-tickets/discuss/226659/Two-DP-solutions-with-pictures
 *  https://leetcode.com/problems/minimum-cost-for-tickets/discuss/504403/DP-it's-not-easy-as-you-thought
 *  https://leetcode.com/problems/minimum-cost-for-tickets/discuss/504403/DP-it's-not-easy-as-you-thought
 */
package com.an7one.leetcode.lvl4.lc0983;

public class SolutionApproach0DP1Dimen1 {
    public int mincostTickets(int[] days, int[] costs) {
        int[] minCosts = new int[366];
        boolean[] isTravelDay = new boolean[366];
        for (int day : days)
            isTravelDay[day] = true;

        for (int i = 1; i <= days[days.length - 1]; i++) {
            if (!isTravelDay[i]) {
                minCosts[i] = minCosts[i - 1];
                continue;
            }

            int minCost;
            minCost = minCosts[i - 1] + costs[0];
            minCost = Math.min(minCost, minCosts[Math.max(0, i - 7)] + costs[1]);
            minCost = Math.min(minCost, minCosts[Math.max(0, i - 30)] + costs[2]);

            minCosts[i] = minCost;
        }

        return minCosts[days[days.length - 1]];
    }
}