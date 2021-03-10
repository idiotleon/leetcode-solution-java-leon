/**
 * https://leetcode.com/problems/max-chunks-to-make-sorted/
 * 
 * Time Complexity:     O(3 * N) ~ O(N)
 * Space Complexity:    O(N)
 * 
 *  "Each time all elements to the left are smaller than, 
 *  or equal to, all elements to the right,
 *  there is a new chunk."
 * 
 * References:
 *  https://leetcode.com/problems/max-chunks-to-make-sorted-ii/discuss/113462/Java-solution-left-max-and-right-min.
 */
package com.an7one.leetcode.lvl4.lc0769;

public class SolutionApproach0DP1Dimen1 {
    public int maxChunksToSorted(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;
        int[] maxFromLo = new int[N];
        int[] minFromHi = new int[N];

        maxFromLo[0] = nums[0];
        for (int i = 1; i < N; i++) {
            maxFromLo[i] = Math.max(maxFromLo[i - 1], nums[i]);
        }

        minFromHi[N - 1] = nums[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            minFromHi[i] = Math.min(minFromHi[i + 1], nums[i]);
        }

        int chunks = 0;
        for (int i = 0; i < N - 1; i++) {
            if (maxFromLo[i] <= minFromHi[i + 1]){
                ++chunks;
            }
        }

        return  1 + chunks;
    }
}