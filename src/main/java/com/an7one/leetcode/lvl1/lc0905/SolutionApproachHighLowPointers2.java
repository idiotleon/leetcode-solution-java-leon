/**
 * @author: Leon
 * https://leetcode.com/problems/sort-array-by-parity/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1) / O(N)
 */
package com.an7one.leetcode.lvl1.lc0905;

public class SolutionApproachHighLowPointers2 {
    public int[] sortArrayByParity(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return new int[0];

        final int N = nums.length;
        int[] ans = new int[N];

        int lo = 0, hi = N - 1;
        for (int num : nums) {
            if (num % 2 == 0)
                ans[lo++] = num;
            else
                ans[hi--] = num;
        }

        return ans;
    }
}