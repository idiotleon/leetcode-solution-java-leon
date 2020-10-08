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
 *  https://leetcode.com/problems/max-chunks-to-make-sorted-ii/discuss/113466/Simple-Java-Solution-with-explanation
 * 
 * Similar Questions:
 *  https://leetcode.com/problems/max-chunks-to-make-sorted-ii/
 *  https://leetcode.com/problems/jump-game/
 *  https://leetcode.com/problems/product-of-array-except-self/
 */
package com.zea7ot.leetcode.lvl4.lc0768;

public class SolutionApproach0DP1Dimen1 {
    public int maxChunksToSorted(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;
        int[] maxOfLeft = new int[N];
        int[] minOfRight = new int[N];

        maxOfLeft[0] = nums[0];
        for (int i = 1; i < N; i++) {
            maxOfLeft[i] = Math.max(maxOfLeft[i - 1], nums[i]);
        }

        minOfRight[N - 1] = nums[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            minOfRight[i] = Math.min(minOfRight[i + 1], nums[i]);
        }

        int ans = 0;
        for (int i = 0; i < N - 1; i++) {
            if (maxOfLeft[i] <= minOfRight[i + 1])
                ans++;
        }

        return ans + 1;
    }
}