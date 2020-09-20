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
        int maxNoDeletion = nums[0];
        int maxWithDeletion = nums[0];
        int max = nums[0];

        for (int i = 1; i < N; ++i) {
            maxWithDeletion = Math.max(maxNoDeletion, maxWithDeletion + nums[i]);
            maxNoDeletion = Math.max(maxNoDeletion + nums[i], nums[i]);

            max = Math.max(max, maxNoDeletion);
            max = Math.max(max, maxWithDeletion);
        }

        return max;
    }
}