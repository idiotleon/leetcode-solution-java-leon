/**
 * https://leetcode.com/problems/repeated-dna-sequences/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 * 
 * References:
 *  https://leetcode.com/problems/repeated-dna-sequences/discuss/53867/Clean-Java-solution-(hashmap-+-bits-manipulation)/201065
 *  https://leetcode.com/problems/repeated-dna-sequences/discuss/53867/Clean-Java-solution-(hashmap-+-bits-manipulation)/55192
 *  https://leetcode.com/problems/repeated-dna-sequences/discuss/53867/Clean-Java-solution-(hashmap-%2B-bits-manipulation)
 */
package com.zea7ot.leetcode.lvl4.lc0187;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SolutionApproach0SlidingWindow {
    private static final int LEN = 10;
    private static final Map<Character, Integer> DECODE_MAP = new HashMap<>() {
        {
            put('A', 0);
            put('C', 1);
            put('G', 2);
            put('T', 3);
        }
    };

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        final int LEN_S = s.length();
        if (LEN_S < LEN + 1)
            return ans;

        final char[] CHS = s.toCharArray();

        final Set<Integer> SEEN_ONCE = new HashSet<>();
        final Set<Integer> SEEN_TWICE = new HashSet<>();

        int bitMask = 0;
        for (int i = 0; i < LEN; ++i) {
            bitMask <<= 2;
            bitMask |= DECODE_MAP.get(CHS[i]);
        }
        SEEN_ONCE.add(bitMask);

        for (int lo = 1; lo < LEN_S - LEN + 1; ++lo) {
            // the ending index (inclusive) of
            // the sliding window of fixed sized `LEN`
            int hi = lo + LEN - 1;

            bitMask &= ~(3 << 18);
            bitMask <<= 2;
            bitMask |= DECODE_MAP.get(CHS[hi]);

            if (!SEEN_ONCE.add(bitMask) && SEEN_TWICE.add(bitMask)) {
                ans.add(s.substring(lo, hi + 1));
            }
        }

        return ans;
    }
}
