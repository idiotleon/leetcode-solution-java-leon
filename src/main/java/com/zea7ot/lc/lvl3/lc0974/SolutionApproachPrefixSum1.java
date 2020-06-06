/**
 * https://leetcode.com/problems/subarray-sums-divisible-by-k/
 * 
 * Time Complexity: O(N)
 * Space Comlexity: O(K)
 * 
 * If sum[0, i] % K == sum[0, j] % K, sum[i + 1, j] is divisible by by K.
 * So for current index j, we need to find out how many index i (i < j) exit 
 * that has the same mod of K.
 * https://leetcode.com/problems/subarray-sums-divisible-by-k/
 */
package com.zea7ot.lc.lvl3.lc0974;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproachPrefixSum1 {
    public int subarraysDivByK(int[] nums, int K) {
        // sanity check
        if(nums == null || nums.length == 0) return 0;
        
        int count = 0, sum = 0;
        Map<Integer, Integer> prefixSum = new HashMap<Integer, Integer>();
        prefixSum.put(0, 1);
      
        for(int num : nums){
            sum = (sum + num) % 5;
            
            // in cases -1 % 5 = -1,
            // while its positive mod is expected,
            // which is -1 + 5 = 4
            if(sum < 0) sum += K;
            
            count += prefixSum.getOrDefault(sum, 0);
            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
        }
        
                            
        return count;
    }
}