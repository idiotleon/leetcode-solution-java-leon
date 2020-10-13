/**
 * https://leetcode.com/problems/jump-game-ii/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/jump-game-ii/discuss/18014/Concise-O(n)-one-loop-JAVA-solution-based-on-Greedy/191474
 *  https://leetcode.com/problems/jump-game-ii/discuss/18014/Concise-O(n)-one-loop-JAVA-solution-based-on-Greedy
 */
package com.zea7ot.leetcode.lvl4.lc0045;

public class SolutionApproach0BFS {
    public int jump(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;
        int jump = 0, curEnd = 0, curFurthest = 0;

        for (int i = 0; i < N - 1; ++i) {
            curFurthest = Math.max(curFurthest, i + nums[i]);

            if (i == curEnd) {
                ++jump;
                curEnd = curFurthest;

                // pruning here
                if (curEnd >= N - 1)
                    return jump;
            }
        }

        return curEnd >= N - 1 ? jump : -1;
    }
}