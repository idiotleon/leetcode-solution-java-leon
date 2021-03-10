/**
 * https://leetcode.com/problems/count-substrings-with-only-one-distinct-letter/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/count-substrings-with-only-one-distinct-letter/discuss/376921/Java-Simple-O(n)-code-brief-explanation-and-analysis./484876
 *  https://leetcode.com/problems/count-substrings-with-only-one-distinct-letter/discuss/376921/Java-Simple-O(n)-code-brief-explanation-and-analysis.
 */
package com.an7one.leetcode.lvl2.lc1180;

public class SolutionApproach0LinearScan {
    public int countLetters(String str) {
        // sanity check
        if (str == null || str.isEmpty())
            return 0;

        int count = 0;

        char prev = '-';
        int len = 0;

        for (final char CH : str.toCharArray()) {
            if (CH == prev) {
                ++len;
            } else {
                prev = CH;
                len = 1;
            }

            count += len;
        }

        return count;
    }
}
