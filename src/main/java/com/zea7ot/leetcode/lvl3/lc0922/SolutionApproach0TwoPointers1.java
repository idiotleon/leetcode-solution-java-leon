/**
 * https://leetcode.com/problems/sort-array-by-parity-ii/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl3.lc0922;

public class SolutionApproach0TwoPointers1 {
    public int[] sortArrayByParityII(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return nums;

        final int N = nums.length;
        int[] ans = new int[N];

        int even = 0, odd = 1;
        for (int num : nums) {
            if (num % 2 == 0) {
                ans[even] = num;
                even += 2;
            } else {
                ans[odd] = num;
                odd += 2;
            }
        }

        return ans;
    }
}