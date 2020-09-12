/**
 * https://leetcode.com/problems/maximum-number-of-occurrences-of-a-substring/
 * 
 * Time Complexity:     O()
 * Space Compleixty:    O()
 * 
 * References:
 *  https://leetcode.com/problems/maximum-number-of-occurrences-of-a-substring/discuss/458311/Java-HashMap-%2B-Bitmap-O(N)-Solution
 */
package com.zea7ot.leetcode.lvl4.lc1297;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0SlidingWindow1 {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        // sanity check
        if (s == null || s.isEmpty())
            return 0;

        final Map<String, Integer> SUB_OCCUR_MAP = new HashMap<>();

        final int L = s.length();
        final char[] CHS = s.toCharArray();

        int maxFreq = 0;

        for (int lo = 0; lo + minSize - 1 < L; ++lo) {
            int bitmap = 0;

            for (int hi = lo; hi < L && (hi - lo) < maxSize; ++hi) {
                bitmap |= 1 << (CHS[hi] - 'a');

                if (Integer.bitCount(bitmap) > maxLetters)
                    break;

                if (hi - lo + 1 >= minSize) {
                    String sub = s.substring(lo, hi + 1);
                    int freq = SUB_OCCUR_MAP.getOrDefault(sub, 0) + 1;
                    maxFreq = Math.max(maxFreq, freq);
                    SUB_OCCUR_MAP.put(sub, freq);
                }
            }
        }

        return maxFreq;
    }
}
