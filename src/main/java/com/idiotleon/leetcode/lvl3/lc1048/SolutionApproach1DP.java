/**
 * https://leetcode.com/problems/longest-string-chain/
 * 
 * Time Complexity:     O(N * lg(N)) + O(N * (L ^ 2))
 *  O(N * lg(N)), consumed by sorting the words(String[])
 *  O(N * (L ^ 2)), consumed by later checking.
 *      Please be noted that the operation "builder.deleteCharAt(i)" costs O(L)
 * 
 * Space Complexity:    O(N) + O(N * L)
 * 
 * to apply [Bottom-up] DP
 * 
 * References:
 *  https://leetcode.com/problems/longest-string-chain/discuss/458069/JAVA-Easy-Solution-with-Explanation-(MUST-READ)!
 */
package com.idiotleon.leetcode.lvl3.lc1048;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SolutionApproach1DP {
    public int longestStrChain(String[] words) {
        // sanity check
        if (words == null || words.length == 0)
            return 0;

        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        Map<String, Integer> dp = new HashMap<>();

        int longest = 1;
        for (String word : words) {
            if (dp.containsKey(word))
                continue;

            dp.put(word, 1);
            final int LEN = word.length();
            for (int i = 0; i < LEN; ++i) {
                StringBuilder builder = new StringBuilder(word);
                String previous = builder.deleteCharAt(i).toString();
                if (dp.containsKey(previous)
                        // this comparison is trivial,
                        // withouth which this test case, ["fha","fgha","egha","efha","efgh","efgha"],
                        // fails
                        && dp.get(previous) + 1 > dp.get(word)) {
                    dp.put(word, dp.get(previous) + 1);
                }
            }

            longest = Math.max(longest, dp.get(word));
        }

        return longest;
    }
}