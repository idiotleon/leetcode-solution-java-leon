/**
 * https://leetcode.com/problems/word-pattern/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(2 * L) ~ O(L)
 * 
 * References:
 *  https://leetcode.com/problems/word-pattern/discuss/73399/Very-fast-(3ms)-Java-Solution-using-HashMap/270654
 */
package com.an7one.leetcode.lvl2.lc0290;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SolutionApproach0HashMap {
    public boolean wordPattern(String pattern, String str) {
        final int L = pattern.length();
        String[] arr = str.split(" ");
        final int N = arr.length;
        // sanity check
        if (N != L)
            return false;

        Map<Character, String> map = new HashMap<>();
        final Set<String> SEEN = new HashSet<>();

        final char[] CHS = pattern.toCharArray();
        for (int i = 0; i < N; ++i) {
            final char CH = CHS[i];
            final String WORD = arr[i];

            if (map.containsKey(CH)) {
                if (!map.get(CH).equals(WORD))
                    return false;
            } else {
                // str, represented by one pattern,
                // cannot be represented by another one.
                if (!SEEN.add(WORD))
                    return false;
                map.put(CH, WORD);
            }
        }

        return true;
    }
}