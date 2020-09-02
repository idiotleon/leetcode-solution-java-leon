/**
 * https://leetcode.com/problems/largest-time-for-given-digits/
 * 
 * Time Complexity:     O(4 * 4 * 4) ~ O(1)
 * Space Complexity:    O(5) ~ O(1)
 * 
 * References:
 *  -given-digits/discuss/200693/JavaPython-3-11-liner-O(64)-w-comment-6-ms.
 */
package com.zea7ot.leetcode.lvl3.lc0949;

public class SolutionApproach0ParsingString1 {
    public String largestTimeFromDigits(int[] nums) {
        String ans = "";
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                for (int k = 0; k < 4; ++k) {
                    if (i == j || i == k || j == k)
                        continue;
                    String hour = "" + nums[i] + nums[j];
                    String minute = "" + nums[k] + nums[6 - i - j - k];
                    String time = hour + ":" + minute;

                    if (hour.compareTo("24") < 0 && minute.compareTo("60") < 0 && ans.compareTo(time) < 0)
                        ans = time;
                }
            }
        }

        return ans;
    }
}