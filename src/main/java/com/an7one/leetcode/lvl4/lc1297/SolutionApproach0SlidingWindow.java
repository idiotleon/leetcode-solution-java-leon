/**
 * https://leetcode.com/problems/maximum-number-of-occurrences-of-a-substring/
 * 
 * Time Complexity:     O(26 * L) ~ O(L)
 * Space Complexity:    O(L) + O(26) ~ O(L)
 * 
 * 
 * The greedy part of the solution is that, we also notice that we only need `minSize`,
 *  since if the `minSize` satisfies the constraints that distinct letters <= `maxLetters`,
 *  any substring greater than that size would only add at max a new distinct letter.
 *   
 * This essentially means that since the substring of size greater than `minSize` satisfies the constraint of distinct letters <= `maxLetters`,
 *  there will be a substring of this selected substring of length `minSize`,
 *  that'll satisfy the same constraint and the frequency of this substring will be at least as much as the parent substring.
 * 
 * We also know that number of shorter substrings are more than the longer ones, 
 *  thus we only need to check for substrings of `minSize` satisfying the condition.
 * 
 * 
 * References:
 *  https://leetcode.com/problems/maximum-number-of-occurrences-of-a-substring/discuss/457577/C++-Greedy-approach-+-Sliding-window-O(n)./411614
 *  https://leetcode.com/problems/maximum-number-of-occurrences-of-a-substring/discuss/457577/C%2B%2B-Greedy-approach-%2B-Sliding-window-O(n).
 */
package com.an7one.leetcode.lvl4.lc1297;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0SlidingWindow {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        // sanity check
        if (s == null || s.isEmpty())
            return 0;

        // substring - ocurrences map
        final Map<String, Integer> SUB_OCCUR_MAP = new HashMap<>();
        int maxOccur = 0;

        final int L = s.length();
        final char[] CHS = s.toCharArray();

        final int[] FREQS = new int[26];
        int lo = 0, hi = 0;
        int distinct = 0;

        while (hi < L) {
            if (FREQS[CHS[hi] - 'a']++ == 0)
                ++distinct;

            while (distinct > maxLetters || (hi - lo + 1) > minSize) {
                if (--FREQS[CHS[lo] - 'a'] == 0)
                    --distinct;

                ++lo;
            }

            if (hi - lo + 1 == minSize) {
                String sub = s.substring(lo, hi + 1);
                SUB_OCCUR_MAP.put(sub, SUB_OCCUR_MAP.getOrDefault(sub, 0) + 1);
                maxOccur = Math.max(maxOccur, SUB_OCCUR_MAP.get(sub));
            }

            ++hi;
        }

        return maxOccur;
    }
}
