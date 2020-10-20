/**
 * https://leetcode.com/problems/max-chunks-to-make-sorted/
 * 
 * Time Complexity:     O(2 * N) ~ O(N)
 * Space Complexity:    O(N)
 * 
 *  "Each time all elements to the left are smaller than, 
 *  or equal to, all elements to the right,
 *  there is a new chunk."
 * 
 * References:
 *  https://leetcode.com/problems/max-chunks-to-make-sorted-ii/discuss/113462/Java-solution-left-max-and-right-min./182522
 *  https://leetcode.com/problems/max-chunks-to-make-sorted/discuss/113520/Java-solution-left-max-and-right-min.
 */
package com.zea7ot.leetcode.lvl4.lc0769;

public class SolutionApproach0DP1Dimen {
    public int maxChunksToSorted(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;
        int[] minsFromHi = new int[N];
        int hiMin = Integer.MAX_VALUE;

        for (int i = N - 1; i >= 0; --i) {
            hiMin = Math.min(hiMin, nums[i]);
            minsFromHi[i] = hiMin;
        }

        int chunks = 0;
        int loMax = Integer.MIN_VALUE;
        for (int i = 0; i < N - 1; ++i) {
            loMax = Math.max(loMax, nums[i]);
            if (loMax <= minsFromHi[i + 1]) {
                ++chunks;
            }
        }

        return 1 + chunks;
    }
}