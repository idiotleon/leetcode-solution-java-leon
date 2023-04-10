/**
 * https://leetcode.com/problems/campus-bikes-ii/
 * 
 * Time Complexity:     O(`1 << N_B` * `N_B`)
 * Space Complexity:    O(`1 << N_B`)
 * 
 * References:
 *  https://leetcode.com/problems/campus-bikes-ii/discuss/311331/Java-DFS-with-memorization!Very-666
 *  https://leetcode.com/problems/campus-bikes-ii/discuss/303417/Python-Bit-Mask-DP
 *  https://leetcode.com/problems/campus-bikes-ii/discuss/360037/Step-by-Step-solution-from-400ms-to-1ms-(beating-100)
 */
package com.idiotleon.leetcode.lvl4.lc1066;

public class SolutionApproach0DP1Dimen {
    public int assignBikes(int[][] workers, int[][] bikes) {
        int min = Integer.MAX_VALUE;
        final int N_W = workers.length, N_B = bikes.length;

        int[] dp = new int[1 << N_B];

        for (int state = 1; state < (1 << N_B); ++state) {
            int idxWorker = Integer.bitCount(state);
            if (idxWorker > N_W)
                continue;

            dp[state] = Integer.MAX_VALUE;
            for (int idxBike = 0; idxBike < N_B; ++idxBike) {
                if ((state & (1 << idxBike)) == 0)
                    continue;

                int prevState = state ^ (1 << idxBike);
                dp[state] = Math.min(dp[state], dp[prevState] + getDistance(workers[idxWorker - 1], bikes[idxBike]));
            }

            if (idxWorker == N_W) {
                min = Math.min(min, dp[state]);
            }
        }

        return min;
    }

    private int getDistance(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
}
