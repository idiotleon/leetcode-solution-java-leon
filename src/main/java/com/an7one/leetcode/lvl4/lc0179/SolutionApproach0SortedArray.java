/**
 * https://leetcode.com/problems/largest-number/
 * 
 * Time Complexity:     O(N * LEN * lg(N)) + O(N)
 *  LEN, the average length of the string
 * 
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/largest-number/discuss/53158/My-Java-Solution-to-share
 */
package com.an7one.leetcode.lvl4.lc0179;

import java.util.Arrays;

public class SolutionApproach0SortedArray {
    public String largestNumber(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return "";

        final int N = nums.length;

        // to convert int array into String array for sorting later on
        String[] strs = new String[N];
        for (int i = 0; i < N; ++i) {
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strs, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        if (strs[0].charAt(0) == '0')
            return "0";

        StringBuilder builder = new StringBuilder();
        for (String str : strs)
            builder.append(str);

        return builder.toString();
    }
}