/**
 * https://leetcode.com/problems/combination-sum-iv/
 * 
 * TLEed
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/combination-sum-iv/discuss/85036/1ms-Java-DP-Solution-with-Detailed-Explanation
 */
package com.zea7ot.leetcode.lvl3.lc0377;

public class SolutionApproach2DFS {
    public int combinationSum4(int[] nums, int target) {
        if (target == 0)
            return 1;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                ans += combinationSum4(nums, target - nums[i]);
            }
        }
        return ans;
    }
}