/**
 * https://leetcode.com/problems/strobogrammatic-number-iii/
 * 
 * Time Complexity:     O()
 * Space Complexiyt:    O()
 * 
 * References:
 *  https://leetcode.com/problems/strobogrammatic-number-iii/discuss/67378/Concise-Java-Solution/69269
 *  https://leetcode.com/problems/strobogrammatic-number-iii/discuss/67378/Concise-Java-Solution
 */
package com.zea7ot.leetcode.lvl4.lc0248;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionApproach0DFSRecursive1 {
    public int strobogrammaticInRange(String low, String high) {
        // sanity check
        if (low == null || high == null || low.length() > high.length()
                || (low.length() == high.length() && low.compareTo(high) > 0))
            return 0;

        final int LEN_LOW = low.length(), LEN_HIGH = high.length();

        int count = 0;
        List<String> res = new ArrayList<>();
        for (int len = LEN_LOW; len <= LEN_HIGH; ++len)
            res.addAll(dfs(len, len));

        for (String num : res) {
            final int LEN = num.length();
            if ((LEN == LEN_LOW && num.compareTo(low) < 0) || (LEN == LEN_HIGH && num.compareTo(high) > 0))
                continue;
            ++count;
        }

        return count;
    }

    private List<String> dfs(int cur, int max) {
        if (cur == 0)
            return Arrays.asList("");
        if (cur == 1)
            return Arrays.asList("1", "8", "0");

        List<String> trimmed = dfs(cur - 2, max);

        List<String> res = new ArrayList<String>();

        for (String str : trimmed) {
            if (cur != max)
                res.add("0" + str + "0");
            res.add("1" + str + "1");
            res.add("6" + str + "9");
            res.add("8" + str + "8");
            res.add("9" + str + "6");
        }

        return res;
    }
}