/**
 * https://leetcode.com/problems/wiggle-sort/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/wiggle-sort/discuss/71692/Java-O(N)-solution/74161
 *  https://leetcode.com/problems/wiggle-sort/discuss/71693/My-explanations-of-the-best-voted-Algo
 */
package com.zea7ot.leetcode.lvl2.lc0280;

public class SolutionApproach0Sorting1 {
    public void wiggleSort(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return;

        final int N = nums.length;
        for (int i = 1; i < N; ++i) {
            int temp = nums[i - 1];
            if ((i % 2 == 1) == (temp > nums[i])) {
                nums[i - 1] = nums[i];
                nums[i] = temp;
            }
        }
    }
}