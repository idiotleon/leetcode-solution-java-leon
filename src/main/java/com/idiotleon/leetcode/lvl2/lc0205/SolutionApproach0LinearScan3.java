package com.idiotleon.leetcode.lvl2.lc0205;

import com.idiotleon.util.Constant;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/isomorphic-strings/
 * <p>
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0LinearScan3 {
    public boolean isIsomorphic(String s, String t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;

        final int LEN_S = s.length();

        Map<Character, Character> mapped = new HashMap<>();
        Set<Character> seen = new HashSet<>();

        for (int i = 0; i < LEN_S; ++i) {
            char ch1 = s.charAt(i), ch2 = t.charAt(i);
            if (mapped.containsKey(ch1)) {
                if (mapped.get(ch1) != ch2) {
                    return false;
                }
            } else {
                if (seen.contains(ch2)) {
                    return false;
                }
                mapped.put(ch1, ch2);
                seen.add(ch2);
            }
        }

        return true;
    }
}