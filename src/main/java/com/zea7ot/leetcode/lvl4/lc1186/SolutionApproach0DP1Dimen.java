/**
 * https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/
 * 
 * Time Complexity:     O(N)
 * Space Compleixty:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/discuss/377397/Intuitive-Java-Solution-With-Explanation
 */
package com.zea7ot.leetcode.lvl4.lc1186;

public class SolutionApproach0DP1Dimen {
    public int maximumSum(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;
        int[] maxEndsHere = new int[N];
        maxEndsHere[0] = nums[0];
        int[] maxStartsHere = new int[N];

        int max = nums[0];
        for (int i = 1; i < N; ++i) {
            maxEndsHere[i] = Math.max(nums[i], maxEndsHere[i - 1] + nums[i]);
            max = Math.max(max, maxEndsHere[i]);
        }

        maxStartsHere[N - 1] = nums[N - 1];
        for (int i = N - 2; i >= 0; --i)
            maxStartsHere[i] = Math.max(nums[i], maxStartsHere[i + 1] + nums[i]);
        for (int i = 1; i < N - 1; ++i)
            max = Math.max(max, maxEndsHere[i - 1] + maxStartsHere[i + 1]);

        return max;
    }
}