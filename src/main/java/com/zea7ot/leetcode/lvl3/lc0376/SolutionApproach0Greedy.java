/**
 * https://leetcode.com/problems/wiggle-subsequence/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/wiggle-subsequence/discuss/84843/Easy-understanding-DP-solution-with-O(n)-Java-version/89522
 *  https://youtu.be/FLbqgyJ-70I?t=1306
 *  https://docs.google.com/presentation/d/1OeA0rsnOrklarLM5G2tHHJ6EE37HpRqD7KedzOqkihk/edit#slide=id.g8285dd8f3f_1_299
 *  https://leetcode.com/problems/wiggle-subsequence/discuss/84843/Easy-understanding-DP-solution-with-O(n)-Java-version
 */
package com.zea7ot.leetcode.lvl3.lc0376;

public class SolutionApproach0Greedy {
    public int wiggleMaxLength(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;
        int up = 1, down = 1;

        for (int i = 1; i < N; ++i) {
            if (nums[i - 1] > nums[i])
                down = up + 1;
            else if (nums[i - 1] < nums[i])
                up = down + 1;
        }

        return Math.max(down, up);
    }
}