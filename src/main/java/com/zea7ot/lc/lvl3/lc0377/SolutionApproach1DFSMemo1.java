/**
 * https://leetcode.com/problems/combination-sum-iv/
 * 
 * Time Complexity:     O(target * N)
 * Space Complexity:    O(target)
 * 
 * Refences:
 *  https://leetcode.com/problems/combination-sum-iv/discuss/85036/1ms-Java-DP-Solution-with-Detailed-Explanation/256496
 *  https://leetcode.com/problems/combination-sum-iv/discuss/85036/1ms-Java-DP-Solution-with-Detailed-Explanation/89652
 */
package com.zea7ot.lc.lvl3.lc0377;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach1DFSMemo1 {
    public int combinationSum4(int[] nums, int target) {
        // sanity check
        if(nums == null || nums.length == 0 || target <= 0) return 0;

        return dfs(nums, target, new HashMap<Integer, Integer>());
    }
    
    private int dfs(int[] nums, 
                    int target, 
                    Map<Integer, Integer> memo){
        if(target < 0) return 0;
        if(target == 0) return 1;
        if(memo.containsKey(target)) return memo.get(target);
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            count += dfs(nums, target - nums[i], memo);
        }
        memo.put(target, count);
        return count;
    }
}