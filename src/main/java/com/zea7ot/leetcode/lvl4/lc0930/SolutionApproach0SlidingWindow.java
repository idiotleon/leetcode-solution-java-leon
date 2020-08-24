/**
 * https://leetcode.com/problems/binary-subarrays-with-sum/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * 
 * [x,x,x,0,0,0,y,y,y,0,0,0,z,z,z], assuming that y+y+y in the mediumm is what we want, 
 *  so when lo is the idx of the first y, and hi is the idx of the last y, 
 *  now prev is the idx of the last x, which is the closest non-0 to the first y(A[lo]), 
 *  then we can know that up to hi, 
 *  we have 1 + (lo - prev - 1) subarrays satisfying the sum equals K.
 * 
 * 
 * References:
 *  https://leetcode.com/problems/binary-subarrays-with-sum/discuss/187005/3-ways-to-solve-this-kind-of-problem.
 */
package com.zea7ot.leetcode.lvl4.lc0930;

public class SolutionApproach0SlidingWindow {
    public int numSubarraysWithSum(int[] nums, int S) {
        // sanity check
        if (nums == null || nums.length < S || S < 0)
            return 0;

        return atMost(nums, S) - atMost(nums, S - 1);
    }

    private int atMost(int[] nums, int S) {
        if (S < 0)
            return 0;
        final int L = nums.length;
        int ans = 0;
        for (int i = 0, j = 0; j < L; j++) {
            S -= nums[j];
            while (S < 0)
                S += nums[i++];

            // any subarray, containing the designated 1s,
            // with different number of zeros,
            // is valid
            ans += j - i + 1;
        }

        return ans;
    }
}