/**
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/longest-continuous-increasing-subsequence/discuss/107351/Java-solution-DP/118270
 *  https://leetcode.com/problems/longest-continuous-increasing-subsequence/discuss/107351/Java-solution-DP
 */
package com.an7one.leetcode.lvl2.lc0674;

public class SolutionApproach1DP0Dimen {
    public int findLengthOfLCIS(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;

        int longest = 1;
        int len = 1;

        for (int i = 1; i < N; ++i) {
            len = nums[i - 1] < nums[i] ? len + 1 : 1;
            longest = Math.max(longest, len);
        }

        return longest;
    }
}
