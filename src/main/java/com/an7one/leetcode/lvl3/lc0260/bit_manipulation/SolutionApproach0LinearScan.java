/**
 * https://leetcode.com/problems/single-number-iii/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/single-number-iii/discuss/68900/Accepted-C%2B%2BJava-O(n)-time-O(1)-space-Easy-Solution-with-Detail-Explanations
 */
package com.an7one.leetcode.lvl3.lc0260.bit_manipulation;

public class SolutionApproach0LinearScan {
    public int[] singleNumber(int[] nums) {
        int diffBits = 0;
        for (int num : nums) {
            diffBits ^= num;
        }

        int lastDigit = diffBits & (-diffBits);

        int single1 = 0, single2 = 0;
        for (int num : nums) {
            if ((lastDigit & num) == 0) {
                single1 ^= num;
            } else {
                single2 ^= num;
            }
        }

        return new int[] { single1, single2 };
    }
}