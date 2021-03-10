/**
 * https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * to find the max 2 numbers
 * 
 * References:
 *  https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/discuss/661687/JavaPython-3-Find-the-max-2-numbers.
 */
package com.an7one.leetcode.lvl2.lc1464;

public class SolutionApproach0LinearScan {
    public int maxProduct(int[] nums) {
        int m = Integer.MIN_VALUE, n = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num >= m) {
                n = m;
                m = num;
            } else if (num > n) {
                n = num;
            }
        }

        return (m - 1) * (n - 1);
    }
}