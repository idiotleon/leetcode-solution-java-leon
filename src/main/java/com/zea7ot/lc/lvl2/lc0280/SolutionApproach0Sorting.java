/**
 * https://leetcode.com/problems/wiggle-sort/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/wiggle-sort/discuss/71692/Java-O(N)-solution/122857
 *  https://leetcode.com/problems/wiggle-sort/discuss/71693/My-explanations-of-the-best-voted-Algo
 */
package com.zea7ot.lc.lvl2.lc0280;

public class SolutionApproach0Sorting {
    public void wiggleSort(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return;

        final int N = nums.length;
        int toggle = 1;
        for (int i = 0; i < N - 1; ++i) {
            if ((nums[i + 1] - nums[i]) * toggle < 0)
                swap(i, i + 1, nums);

            toggle *= -1;
        }
    }

    private void swap(int i, int j, int[] nums) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
}