/**
 * @author: Leon
 * https://leetcode.com/problems/max-consecutive-ones/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
package com.idiotleon.leetcode.lvl2.lc0485;

public class SolutionApproach0Greedy {
    public int findMaxConsecutiveOnes(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        // not used
        // final int N = nums.length;
        int longest = 0;
        int len = 0;

        for (int num : nums) {
            if (num == 0) {
                len = 0;
            } else {
                longest = Math.max(longest, ++len);
            }
        }

        return longest;
    }
}
