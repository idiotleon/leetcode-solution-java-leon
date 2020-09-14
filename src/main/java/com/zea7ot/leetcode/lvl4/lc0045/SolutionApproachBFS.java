/**
 * https://leetcode.com/problems/jump-game-ii/
 */
package com.zea7ot.leetcode.lvl4.lc0045;

public class SolutionApproachBFS {
    public int jump(int[] nums) {
        int jump = 0, curEnd = 0, curFurthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            curFurthest = Math.max(curFurthest, i + nums[i]);

            if (i == curEnd) {
                jump++;
                curEnd = curFurthest;
            }
        }

        return jump;
    }
}