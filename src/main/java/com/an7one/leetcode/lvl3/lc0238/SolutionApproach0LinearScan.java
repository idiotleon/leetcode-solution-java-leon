/**
 * https://leetcode.com/problems/product-of-array-except-self/
 * 
 * Time Complexity:     O(2 * N) ~ O(N)
 * Space Complexity:    O(N) / O(1)
 * 
 * References:
 *  https://leetcode.com/problems/product-of-array-except-self/discuss/65622/Simple-Java-solution-in-O(n)-without-extra-space
 */
package com.an7one.leetcode.lvl3.lc0238;

public class SolutionApproach0LinearScan {
    public int[] productExceptSelf(int[] nums) {
        // sanity cehck
        if (nums == null || nums.length == 0)
            return new int[0];

        final int N = nums.length;
        int[] ans = new int[N];
        ans[0] = 1;
        // from the left to the right
        for (int i = 1; i < N; ++i) {
            ans[i] = nums[i - 1] * ans[i - 1];
        }

        // from the right to the left
        int res = 1;
        for (int i = N - 1; i >= 0; --i) {
            ans[i] *= res;
            res *= nums[i];
        }

        return ans;
    }
}