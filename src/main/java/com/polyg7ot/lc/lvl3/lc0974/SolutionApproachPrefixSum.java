/**
 * https://leetcode.com/problems/subarray-sums-divisible-by-k/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(K)
 * 
 * If sum[0, i] % K == sum[0, j] % K, sum[i + 1, j] is divisible by by K.
 * So for current index j, we need to find out how many index i (i < j) exit 
 * that has the same mod of K.
 * https://leetcode.com/problems/subarray-sums-divisible-by-k/
 */
package com.polyg7ot.lc.lvl3.lc0974;

public class SolutionApproachPrefixSum {
    public int subarraysDivByK(int[] nums, int K) {
        int[] prefixSum = new int[K];
        prefixSum[0] = 1;
        
        int count = 0, sum = 0;
        for(int num : nums){
            sum = (sum + num) % K;
            if(sum < 0) sum += K;
            count += prefixSum[sum];
            // if the sum of nums[i:j], and sum[0:j] - sum[0: i - 1], have the same remainder
            ++prefixSum[sum];
        }
        
        return count;
    }
}