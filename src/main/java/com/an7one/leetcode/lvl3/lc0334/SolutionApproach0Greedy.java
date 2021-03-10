/**
 * https://leetcode.com/problems/increasing-triplet-subsequence/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  http://zxi.mytechroad.com/blog/greedy/leetcode-334-increasing-triplet-subsequence/
 */
package com.an7one.leetcode.lvl3.lc0334;

public class SolutionApproach0Greedy {
    public boolean increasingTriplet(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return false;

        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > min2)
                return true;
            else if (num < min1) {
                min1 = num;
            } else if (num > min1 && num < min2) {
                min2 = num;
            }
        }

        return false;
    }
}