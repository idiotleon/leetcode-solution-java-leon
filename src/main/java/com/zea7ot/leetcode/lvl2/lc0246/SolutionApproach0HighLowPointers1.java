/**
 * https://leetcode.com/problems/strobogrammatic-number/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(1) / O(L)
 * 
 * References:
 *  https://leetcode.com/problems/strobogrammatic-number/discuss/67182/Accepted-Java-solution
 */
package com.zea7ot.leetcode.lvl2.lc0246;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0HighLowPointers1 {
    private static final Map<Character, Character> map = new HashMap<>() {
        {
            put('0', '0');
            put('1', '1');
            put('6', '9');
            put('8', '8');
            put('9', '6');
        }
    };

    public boolean isStrobogrammatic(String num) {
        // sanity check
        if (num == null || num.isEmpty())
            return false;

        final int L = num.length();
        char[] digits = num.toCharArray();

        int lo = 0, hi = L - 1;
        while (lo <= hi) {
            if (!map.containsKey(digits[lo]))
                return false;

            if (map.get(digits[lo]) != digits[hi])
                return false;

            ++lo;
            --hi;
        }

        return true;
    }
}