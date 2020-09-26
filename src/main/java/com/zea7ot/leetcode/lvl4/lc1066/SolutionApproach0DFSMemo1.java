/**
 * https://leetcode.com/problems/campus-bikes-ii/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/campus-bikes-ii/discuss/412367/Java-DFS-And-DP-Solution-with-Video-Explanation-(Chinese-and-English)
 *  https://leetcode.com/problems/campus-bikes-ii/discuss/360037/Step-by-Step-solution-from-400ms-to-1ms-(beating-100)
 */
package com.zea7ot.leetcode.lvl4.lc1066;

public class SolutionApproach0DFSMemo1 {
    public int assignBikes(int[][] workers, int[][] bikes) {
        final int N_B = bikes.length;
        boolean[] used = new boolean[N_B];
        int[] min = { Integer.MAX_VALUE };
        dfs(0, 0, workers, bikes, used, min);

        return min[0];
    }

    private void dfs(int idxWorker, int sum, int[][] workers, int[][] bikes, boolean[] used, int[] min) {
        final int N_W = workers.length, N_B = bikes.length;
        if (idxWorker == N_W) {
            min[0] = Math.min(min[0], sum);
            return;
        }

        if (sum > min[0])
            return;

        for (int i = 0; i < N_B; ++i) {
            if (used[i])
                continue;
            used[i] = true;
            dfs(idxWorker + 1, sum + getDistance(workers[idxWorker], bikes[i]), workers, bikes, used, min);
            used[i] = false;
        }
    }

    private int getDistance(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
}
