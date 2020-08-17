/**
 * https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
 * 
 * Time Complexity:     O(N * lg(N)) + O(N * (2 ^ N))
 * Space Complexity:    O(2 ^ N)
 * 
 * References:
 *  https://leetcode.com/problems/partition-to-k-equal-sum-subsets/discuss/335668/DP-with-Bit-Masking-Solution-%3A-Best-for-Interviews
 *  http://codeforces.com/blog/entry/337
 *  https://www.hackerearth.com/practice/algorithms/dynamic-programming/bit-masking/tutorial/
 *  https://www.geeksforgeeks.org/partition-set-k-subsets-equal-sum/
 */
package com.zea7ot.leetcode.lvl4.lc0698;

import java.util.Arrays;

public class SolutionApproach0KnapsackBitMasking {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        // sanity check
        if(nums == null || nums.length == 0) return false;
        
        Arrays.sort(nums);
        final int N = nums.length;
        boolean[] dp = new boolean[1 << N];
        dp[0] = true;
        int[] total = new int[1 << N];
        
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum % k != 0) return false;
        
        sum /= k;
        if(nums[N - 1] > sum) return false;
        
        // to traverse the whole power set
        for(int i = 0; i < (1 << N); i++){
            if(dp[i]){
                // to loop over each element to find the subset
                for(int j = 0; j < N; j++){
                    // to set the j-th bit
                    int temp = i | (1 << j);
                    if(temp != i){
                        // if the total sum is less than the target store in dp and total array
                        // https://leetcode.com/problems/partition-to-k-equal-sum-subsets/discuss/335668/DP-with-Bit-Masking-Solution-:-Best-for-Interviews/380789
                        if(nums[j] <= (sum - (total[i] % sum))){
                            dp[temp] = true;
                            total[temp] = nums[j] + total[i];
                        }else break;
                    }
                }
            }
        }
        
        return dp[(1 << N) - 1];
    }
}