/**
 * https://leetcode.com/problems/max-chunks-to-make-sorted/
 *
 * Time Complexity:     O(`N`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/max-chunks-to-make-sorted/discuss/113528/Simple-Java-O(n)-Solution-with-detailed-explanation/162249
 *  https://leetcode.com/problems/max-chunks-to-make-sorted/discuss/113528/Simple-Java-O(n)-Solution-with-detailed-explanation
 */
package com.zea7ot.leetcode.lvl4.lc0769;

public class SolutionApproach0Greedy {
    public int maxChunksToSorted(int[] nums) {
        final int N = nums.length;

        int localMax = Integer.MIN_VALUE;

        int chunks = 0;

        for (int i = 0; i < N; ++i) {
            localMax = Math.max(localMax, nums[i]);

            if (localMax == i) {
                ++chunks;
            }
        }

        return chunks;
    }
}
