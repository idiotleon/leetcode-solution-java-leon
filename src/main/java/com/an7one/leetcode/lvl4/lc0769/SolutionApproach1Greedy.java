/**
 * https://leetcode.com/problems/max-chunks-to-make-sorted-ii/
 * 
 * Time Complexity:     O(N * lg(N)) + O(N) ~ O(N * lg(N))
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/max-chunks-to-make-sorted-ii/discuss/113466/simple-java-solution-with-explanation
 */
package com.an7one.leetcode.lvl4.lc0769;

import java.util.Arrays;

public class SolutionApproach1Greedy {
    public int maxChunksToSorted(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int[] max = new int[N];
        max[0] = nums[0];
        for (int i = 1; i < N; ++i) {
            max[i] = Math.max(max[i - 1], nums[i]);
        }

        int count = 0;
        int upperLimit = sorted[N - 1];
        for (int i = N - 1; i >= 0; --i) {
            if (max[i] == sorted[i]) {
                if (sorted[i] > upperLimit)
                    continue;

                ++count;
                upperLimit = nums[i];
            }
        }

        return count;
    }

}
