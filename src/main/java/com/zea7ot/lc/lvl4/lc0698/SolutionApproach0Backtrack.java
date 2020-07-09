/**
 * https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
 * 
 * #NP-hard
 * Time Complexity:     ?O(k * (2 ^ N))
 * Space Complexity:    
 * 
 * to [top-down] DFS
 * 
 * References:
 *  https://leetcode.com/problems/partition-to-k-equal-sum-subsets/discuss/108730/JavaC%2B%2BStraightforward-dfs-solution
 *  https://leetcode.com/problems/partition-to-k-equal-sum-subsets/discuss/108730/JavaC++Straightforward-dfs-solution/183103
 *  https://leetcode.com/problems/partition-to-k-equal-sum-subsets/discuss/180014/Backtracking-Thinking-Process
 *  https://www.geeksforgeeks.org/partition-set-k-subsets-equal-sum/
 */
package com.zea7ot.lc.lvl4.lc0698;

public class SolutionApproach0Backtrack {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        // sanity check
        if(nums == null || nums.length == 0 || k <= 0) return false;
    
        final int N = nums.length;    
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum % k != 0) return false;
        
        boolean[] visited = new boolean[N];
        return canPartition(0, 0, visited, 0, k, nums, sum / k);
    }
    
    private boolean canPartition(int curSum,
                                 int curNum,
                                 boolean[] visited, 
                                 int start, 
                                 int k,
                                 int[] nums, 
                                 int target){
        if(k == 1) return true;
        // such a pruning only applies on the promise that all numbers are positive
        if(curSum > target) return false;
        if(curSum == target && curNum > 0){
            return canPartition(0, 0, visited, 0, k - 1, nums, target);
        }
        
        for(int i = start; i < nums.length; i++){
            if(!visited[i]){
                visited[i] = true;
                if(canPartition(curSum + nums[i], curNum++, visited, i + 1, k, nums, target)) return true;
                visited[i] = false;
            }
        }
        
        return false;
    }
}