/**
 * https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/
 * 
 * Time Complexity:     O(N)
 * Space Compleixty:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/discuss/377397/Intuitive-Java-Solution-With-Explanation/376444
 *  https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/discuss/377397/Intuitive-Java-Solution-With-Explanation/392667
 */
package com.an7one.leetcode.lvl4.lc1186;

public class SolutionApproach0DP1Dimen {
    public int maximumSum(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;
        int[] maxSumsWithOneDeletion = new int[N];
        int[] maxSumsWithNoDeletion = new int[N];
        maxSumsWithNoDeletion[0] = nums[0];

        int maxSum = Integer.MIN_VALUE;
        maxSum = Math.max(maxSumsWithNoDeletion[0], maxSum);

        for (int i = 1; i < N; ++i) {
            maxSumsWithOneDeletion[i] = Math.max(maxSumsWithNoDeletion[i - 1], maxSumsWithOneDeletion[i - 1] + nums[i]);
            maxSumsWithNoDeletion[i] = Math.max(maxSumsWithNoDeletion[i - 1] + nums[i], nums[i]);

            maxSum = Math.max(maxSum, maxSumsWithNoDeletion[i]);
            maxSum = Math.max(maxSum, maxSumsWithOneDeletion[i]);
        }

        return maxSum;
    }
}
