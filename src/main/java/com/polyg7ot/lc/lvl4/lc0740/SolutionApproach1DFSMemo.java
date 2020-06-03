/**
 * https://leetcode.com/problems/delete-and-earn/
 * 
 * Time Complexity:     O(N * lg(N)) + 
 * Space Complexity:    
 * 
 * to top-down DFS
 * 
 * References:
 *  https://leetcode.com/problems/delete-and-earn/discuss/284609/For-top-down-DP-fans-Java-2ms-solution-explained
 * 
 * NOT well understood
 *  1. why the array must be sorted?
 *  2. how is deletion of (nums[idx] - 1) elements implemented?
 *  3. why is deleteion of (nums[idx] - 1) elements automatically calculated in the memo, were the array sorted?
 */
package com.polyg7ot.lc.lvl4.lc0740;

import java.util.Arrays;

public class SolutionApproach1DFSMemo {
    public int deleteAndEarn(int[] nums) {
        // sanity check
        if(nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        // to save the highest points at indexes
        int[] memo = new int[nums.length];
        return deleteAndEarn(nums, 0, memo);
    }
    
    private int deleteAndEarn(int[] nums, int idx, int[] memo){
        final int N = nums.length;
        if(idx == N) return 0;
        
        if(memo[idx] > 0) return memo[idx];
        
        // to delete and earn this element/point
        int earned = nums[idx];
        // to start with exactly one latter element
        int skip = idx + 1;
        
        // to add all elements with the same value as "nums[idx]" to earn all points
        while(skip < N && nums[skip] == nums[idx]){
            earned += nums[idx];
            skip++;
        }
        
        // to skip all latter elements (nums[idx] + 1),
        // as required by the problem
        while(skip < N && nums[skip] == nums[idx] + 1){
            skip++;
        }
        
        // to sum up all (later) earnings based the current earning/setup
        earned += deleteAndEarn(nums, skip, memo);
        
        // to skip deletion and thus earning of this element(nums[idx])
        int skipped = deleteAndEarn(nums, idx + 1, memo);
        
        // to return the max of the two
        return memo[idx] = Math.max(earned, skipped);
    }
}