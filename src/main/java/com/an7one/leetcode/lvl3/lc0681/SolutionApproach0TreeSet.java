/**
 * https://leetcode.com/problems/next-closest-time/
 * 
 * Time Complexity:     O(1)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/next-closest-time/discuss/107773/Java-AC-5ms-simple-solution-with-detailed-explaination/225418
 */
package com.an7one.leetcode.lvl3.lc0681;

import java.util.Arrays;
import java.util.TreeSet;

public class SolutionApproach0TreeSet {
    public String nextClosestTime(String time) {
        char[] chs = time.toCharArray();
        Character[] digits = new Character[] { chs[0], chs[1], chs[3], chs[4] };
        TreeSet<Character> set = new TreeSet<Character>(Arrays.asList(digits));

        chs[4] = next(chs[4], '9', set);
        if (time.charAt(4) < chs[4])
            return new String(chs);

        chs[3] = next(chs[3], '5', set);
        if (time.charAt(3) < chs[3])
            return new String(chs);

        chs[1] = next(chs[1], chs[0] == '2' ? '3' : '9', set);
        if (time.charAt(1) < chs[1])
            return new String(chs);

        chs[0] = next(chs[0], '2', set);
        return new String(chs);
    }

    private char next(char ch, char limit, TreeSet<Character> set) {
        Character next = set.higher(ch);
        return next == null || next > limit ? set.first() : next;
    }
}