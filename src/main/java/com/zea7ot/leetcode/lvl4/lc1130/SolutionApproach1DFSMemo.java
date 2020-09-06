/**
 * https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/
 * 
 * Time Complexity:     O(N * lg(N)), O(N ^ 2) in the worst case
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/discuss/339959/One-Pass-O(N)-Time-and-Space/309357
 *  https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/discuss/339959/One-Pass-O(N)-Time-and-Space
 */
package com.zea7ot.leetcode.lvl4.lc1130;

public class SolutionApproach1DFSMemo {
    public int mctFromLeafValues(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;
        int[] sum = { 0 };
        dfs(0, N - 1, nums, sum);
        return sum[0];
    }

    private int dfs(final int LOW, final int HIGH, final int[] NUMS, int[] sum) {
        if (LOW > HIGH)
            return 0;
        if (LOW == HIGH)
            return NUMS[LOW];
        if (LOW + 1 == HIGH) {
            sum[0] += NUMS[LOW] * NUMS[HIGH];
            return Math.max(NUMS[LOW], NUMS[HIGH]);
        }

        int maxIdx = LOW;
        for (int i = LOW; i <= HIGH; ++i)
            if (NUMS[i] > NUMS[maxIdx])
                maxIdx = i;

        int left = dfs(LOW, maxIdx - 1, NUMS, sum);
        if (left != 0)
            sum[0] += NUMS[maxIdx] * left;

        int right = dfs(maxIdx + 1, HIGH, NUMS, sum);
        if (right != 0)
            sum[0] += NUMS[maxIdx] * right;

        return NUMS[maxIdx];
    }
}
