/**
 * https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/discuss/377397/Intuitive-Java-Solution-With-Explanation/392667
 *  https://youtu.be/FLbqgyJ-70I?t=2381
 */
package com.zea7ot.leetcode.lvl4.lc1186;

public class SolutionApproach0DP0Dimen {
    public int maximumSum(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;
        int maxSumNoDeletion = nums[0];
        int maxSumOneDeletion = 0;
        int maxSum = nums[0];

        for (int i = 1; i < N; ++i) {
            maxSumOneDeletion = Math.max(maxSumNoDeletion, maxSumOneDeletion + nums[i]);
            maxSumNoDeletion = Math.max(maxSumNoDeletion + nums[i], nums[i]);

            maxSum = Math.max(maxSum, maxSumNoDeletion);
            maxSum = Math.max(maxSum, maxSumOneDeletion);
        }

        return maxSum;
    }
}