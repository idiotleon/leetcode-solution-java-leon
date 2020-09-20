/**
 * https://leetcode.com/problems/max-consecutive-ones-ii/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl3.lc0487;

public class SolutionApproach0DP0Dimen {
    public int findMaxConsecutiveOnes(int[] nums) {
        int flipped = 0, notFlipped = 0;
        int longest = 0;
        for (int num : nums) {
            flipped = num == 1 ? flipped + 1 : notFlipped + 1;
            notFlipped = num == 1 ? notFlipped + 1 : 0;
            longest = Math.max(longest, Math.max(flipped, notFlipped));
        }

        return longest;
    }
}