/**
 * https://leetcode.com/problems/target-sum/
 * 
 * Time Complexity:     O(N * sum)
 * Space Complexity:    O(N * sum)
 * 
 * References:
 *  https://leetcode.com/problems/target-sum/discuss/97333/Java-simple-DFS-with-memorization/356995
 */
package com.zea7ot.lc.lvl3.lc0494;

public class SolutionApproach1DFSMemo {
    public int findTargetSumWays(int[] nums, int S) {
        // sanity check
        if(nums == null || nums.length == 0) return 0;
        int sum = 0;
        for(int num : nums) sum += num;
        // sanity check
        if(S > sum || S < -sum) return 0;

        Integer[][] memo = new Integer[nums.length + 1][sum * 2 + 1];
        return dfs(nums, 0, sum, S + sum, memo);
    }
    
    private int dfs(int[] nums, int idx, int sum, int target, Integer[][] memo){
        if(idx == nums.length) return sum == target ? 1 : 0;
        
        if(memo[idx][sum] != null) return memo[idx][sum];
        
        int ans = 0;
        ans = dfs(nums, idx + 1, sum + nums[idx], target, memo) 
            + dfs(nums, idx + 1, sum - nums[idx], target, memo);
        
        return memo[idx][sum] = ans;
    }
}