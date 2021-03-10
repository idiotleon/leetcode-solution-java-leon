/**
 * https://leetcode.com/problems/target-sum/
 * 
 * Time Complexity:     O(N * sum)
 * Space Complexity:    O(N * sum)
 * 
 * References:
 *  https://leetcode.com/problems/target-sum/discuss/97333/Java-simple-DFS-with-memorization/356995
 */
package com.an7one.leetcode.lvl3.lc0494;

public class SolutionApproach1DFSMemo {
    public int findTargetSumWays(int[] nums, int S) {
        // sanity check
        if(nums == null || nums.length == 0) return 0;
        int sum = 0;
        for(int num : nums) sum += num;
        // sanity check
        if(S > sum || S < -sum) return 0;

        Integer[][] memo = new Integer[nums.length + 1][sum * 2 + 1];
        return dfs(0, sum, S + sum, nums, memo);
    }
    
    private int dfs(int idx, int sum, int target, int[] nums, Integer[][] memo){
        if(idx == nums.length) return sum == target ? 1 : 0;
        if(memo[idx][sum] != null) return memo[idx][sum];
        
        int res = 0;
        res = dfs(idx + 1, sum + nums[idx], target, nums, memo) 
            + dfs(idx + 1, sum - nums[idx], target, nums, memo);
        
        return memo[idx][sum] = res;
    }
}