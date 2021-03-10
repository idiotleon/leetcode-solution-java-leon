/**
 * https://leetcode.com/problems/max-chunks-to-make-sorted/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/max-chunks-to-make-sorted/discuss/113528/Simple-Java-O(n)-Solution-with-detailed-explanation/162249
 *  https://leetcode.com/problems/max-chunks-to-make-sorted/discuss/113528/Simple-Java-O(n)-Solution-with-detailed-explanation
 */
package com.an7one.leetcode.lvl4.lc0768;

public class SolutionApproach0Greedy1 {
    public int maxChunksToSorted(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;
        int[] max = new int[N];
        max[0] = nums[0];

        for (int i = 1; i < N; i++) {
            max[i] = Math.max(max[i - 1], nums[i]);
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (max[i] == i) {
                count++;
            }
        }

        return count;
    }
}