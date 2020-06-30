/**
 * https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/discuss/288993/Java-DP-solution
 *  https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/discuss/355352/Full-Explanation-and-idea-formation.-JAVA-beat-99
 */
package com.zea7ot.lc.lvl3.lc1031;

public class SolutionApproach0KadensAlgorithm {
    public int maxSumTwoNoOverlap(int[] nums, int L, int M) {
        if(nums == null || nums.length == 0) return 0;
        final int N = nums.length;
        
        int[] sums = new int[N];
        
        sums[0] = nums[0];
        for(int i = 1; i < N; i++){
            sums[i] = Math.max(nums[i], sums[i - 1] + nums[i]);
        }
        
        int maxL = sums[L - 1];
        int maxM = sums[M - 1];
        int ans = sums[L + M - 1];
        for(int i = L + M; i < N; i++){
            maxL = Math.max(maxL, sums[i - M] - sums[i - M - L]); // maxL at index (i - M)
            maxM = Math.max(maxM, sums[i - L] - sums[i - M - L]); // maxM at index (i - L)
            ans = Math.max(ans, Math.max(maxL + sums[i] - sums[i - M], maxM + sums[i] - sums[i - L]));
        }
        
        return ans;
    }
}