/**
 * https://leetcode.com/problems/longest-happy-string/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/longest-happy-string/discuss/564277/C%2B%2BJava-a-greater-b-greater-c
 */
package com.an7one.leetcode.lvl3.lc1405;

import java.util.Collections;

public class SolutionApproach0Greedy {
    public String longestDiverseString(int a, int b, int c) {
        return generate(a, b, c, "a", "b", "c");
    }

    private String generate(int a, int b, int c, String aa, String bb, String cc) {
        if (a < b)
            return generate(b, a, c, bb, aa, cc);
        if (b < c)
            return generate(a, c, b, aa, cc, bb);
        if (b == 0)
            return String.join("", Collections.nCopies(Math.min(2, a), aa));
        // java 11
        // return aa.repeat(Math.min(2, a));

        int aUsed = Math.min(2, a), bUsed = a - aUsed >= b ? 1 : 0;
        return String.join("", Collections.nCopies(aUsed, aa)) + String.join("", Collections.nCopies(bUsed, bb))
                + generate(a - aUsed, b - bUsed, c, aa, bb, cc);
        // java 11
        // return aa.repeat(aUsed) + bb.repeat(bUsed) + generate(a - aUsed, b - bUsed,
        // c, aa, bb, cc);
    }
}