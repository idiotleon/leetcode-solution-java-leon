/**
 * https://leetcode.com/problems/campus-bikes-ii/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/campus-bikes-ii/discuss/412367/Java-DFS-And-DP-Solution-with-Video-Explanation-(Chinese-and-English)
 *  https://leetcode.com/problems/campus-bikes-ii/discuss/303417/Python-Bit-Mask-DP
 *  https://leetcode.com/problems/campus-bikes-ii/discuss/360037/Step-by-Step-solution-from-400ms-to-1ms-(beating-100)
 */
package com.an7one.leetcode.lvl4.lc1066;

public class SolutionApproach0DFSMemo {
    public int assignBikes(int[][] workers, int[][] bikes) {
        final int N_B = bikes.length;
        int[] memo = new int[1 << N_B];
        return dfs(0, 0, workers, bikes, memo);
    }

    private int dfs(int idxWorker, int state, int[][] workers, int[][] bikes, int[] memo) {
        final int N_W = workers.length, N_B = bikes.length;
        if (idxWorker == N_W)
            return 0;
        if (memo[state] != 0)
            return memo[state];

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N_B; ++i) {
            if ((state & (1 << i)) == 0) {
                int distance = getDistance(workers[idxWorker], bikes[i])
                        + dfs(idxWorker + 1, state | (1 << i), workers, bikes, memo);

                min = Math.min(min, distance);
            }
        }

        return memo[state] = min;
    }

    private int getDistance(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
}
