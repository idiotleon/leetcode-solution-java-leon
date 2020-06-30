/**
 * https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/discuss/279221/JavaPython-3-two-easy-DP-codes-w-comment-time-O(n)-NO-change-of-input
 *  https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/discuss/355352/Full-Explanation-and-idea-formation.-JAVA-beat-99
 */
package com.zea7ot.lc.lvl3.lc1031;

public class SolutionApproach0PrefixSum {
    public int maxSumTwoNoOverlap(int[] nums, int L, int M) {
        final int N = nums.length;
        int[] prefixSum = new int[N + 1];
        for(int i = 0; i < N; i++){
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        
        return Math.max(maxSum(prefixSum, L, M), maxSum (prefixSum, M, L));
    }
    
    private int maxSum(int[] prefixSum, int L, int M){
        final int N = prefixSum.length;
        int ans = 0;
        for(int i = L + M, maxL = 0; i < N; i++){
            maxL = Math.max(maxL, prefixSum[i - M] - prefixSum[i - M - L]); // to update the max value of the subarrays of length L
            ans = Math.max(ans, maxL + prefixSum[i] - prefixSum[i - M]); // to update the max value of the sum of subarrays of length L and M
        }
        return ans;
    }
}