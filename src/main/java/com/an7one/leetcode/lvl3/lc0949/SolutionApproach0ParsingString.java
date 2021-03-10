/**
 * https://leetcode.com/problems/largest-time-for-given-digits/
 * 
 * Time Complexity:     O(4 * 4 * 4) ~ O(1) 
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/largest-time-for-given-digits/discuss/235388/topic
 */
package com.an7one.leetcode.lvl3.lc0949;

public class SolutionApproach0ParsingString {
    public String largestTimeFromDigits(int[] nums) {
        int largest = -1;
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                for (int k = 0; k < 4; ++k) {
                    if (i == j || i == k || j == k)
                        continue;
                    int l = 6 - i - j - k;

                    int res = composeTime(i, j, k, l, nums);
                    largest = Math.max(largest, res);
                }
            }
        }

        if (largest == -1)
            return "";

        return String.format("%02d:%02d", largest / 60, largest % 60);
    }

    private int composeTime(int a, int b, int c, int d, int[] nums) {
        int hours = nums[a] * 10 + nums[b];
        int min = nums[c] * 10 + nums[d];

        if (hours < 24 && min < 60)
            return hours * 60 + min;

        return -1;
    }
}