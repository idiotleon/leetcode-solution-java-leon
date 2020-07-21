/**
 * https://leetcode.com/problems/maximum-subarray/
 * 
 *  Kadane's Algorithm
 *  https://hackernoon.com/kadanes-algorithm-explained-50316f4fd8a6
 */
package com.zea7ot.lc.lvl2.lc0053;

public class SolutionApproach0KadanesAlgorithm1 {
    /**
     * Maximum sum subvector seen so far. The maximum is initially nums[0]. 
     * Suppose we've solved the problem for nums[1 .. i - 1], how can we extend that to nums[1 .. i]? 
     * The maximum sum in the first (i) elements is either the maximum sum in the first (i - 1) elements (which we'll call MaxSoFar), 
     * or it is that of a subvector that ends in position i (which we'll call MaxEndingHere).
     * MaxEndingHere is either nums[i] plus the previous MaxEndingHere, or just nums[i], whichever is larger.
     * https://leetcode.com/problems/maximum-subarray/discuss/20211/Accepted-O(n)-solution-in-java
     */
    public int maxSubArray(int[] nums) {
        // sanity check
        if(nums == null || nums.length == 0) return 0;

        final int N = nums.length;
        int maxSoFar = nums[0], maxEndingHere = nums[0];
        for(int i = 1; i < N; ++i){
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        
        return maxSoFar;
    }
}