/**
 * https://leetcode.com/problems/combination-sum-iv/
 * 
 * Time Complexity:
 * Space Complexity:
 * 
 * References:
 *  https://leetcode.com/problems/combination-sum-iv/discuss/85036/1ms-Java-DP-Solution-with-Detailed-Explanation
 */
package com.zea7ot.leetcode.lvl3.lc0377;

import java.util.Arrays;

public class SolutionApproach1DFSMemo {
    public int combinationSum4(int[] nums, int target) {
        int[] memo = new int[target + 1];
        Arrays.fill(memo, -1);
        memo[0] = 1;
        return dfs(nums, target, memo);
    }
    
    private int dfs(int[] nums, 
                    int target, 
                    int[] memo){
        if(target < 0) return 0;
        if(target == 0) return 1;
        if(memo[target] != -1) return memo[target];
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            count += dfs(nums, target - nums[i], memo);
        }
        return memo[target] = count;
    }
}