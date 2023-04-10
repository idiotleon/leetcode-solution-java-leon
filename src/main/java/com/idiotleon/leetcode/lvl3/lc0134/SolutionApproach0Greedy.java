/**
 * https://leetcode.com/problems/gas-station/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
package com.idiotleon.leetcode.lvl3.lc0134;

public class SolutionApproach0Greedy {
    public int canCompleteCircuit(int[] gas, int[] costs) {
        // sanity check
        if (gas == null || costs == null || gas.length == 0 || costs.length == 0 || gas.length != costs.length)
            return -1;

        final int N = gas.length;
        int curTank = 0;
        int startPos = 0;
        int totalTank = 0;

        for (int i = 0; i < N; ++i) {
            int gasBalance = gas[i] - costs[i];
            curTank += gasBalance;

            if (curTank < 0) {
                startPos = i + 1;
                curTank = 0;
            }

            totalTank += gasBalance;
        }

        return totalTank >= 0 ? startPos : -1;
    }
}