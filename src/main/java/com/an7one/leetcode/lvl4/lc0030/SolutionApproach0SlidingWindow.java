/**
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/substring-with-concatenation-of-all-words/discuss/13656/An-O(N)-solution-with-detailed-explanation/13911
 *  https://leetcode.com/problems/substring-with-concatenation-of-all-words/discuss/13656/An-O(N)-solution-with-detailed-explanation
 *  https://leetcode.wang/leetCode-30-Substring-with-Concatenation-of-All-Words.html
 */
package com.an7one.leetcode.lvl4.lc0030;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionApproach0SlidingWindow {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<Integer>();
        // sanity check
        if (s == null || s.isEmpty() || words == null || words.length == 0)
            return ans;

        Map<String, Integer> freq = new HashMap<String, Integer>();
        for (String word : words)
            freq.put(word, freq.getOrDefault(word, 0) + 1);

        final int L = s.length(), N = words.length, LEN = words[0].length();
        for (int i = 0; i < LEN; ++i) {
            int lo = i, count = 0;
            Map<String, Integer> seen = new HashMap<>();
            for (int j = i; j <= L - LEN; j += LEN) {
                String sub = s.substring(j, j + LEN);
                if (freq.containsKey(sub)) {
                    seen.put(sub, seen.getOrDefault(sub, 0) + 1);

                    if (seen.get(sub) <= freq.get(sub))
                        ++count;
                    else
                        while (seen.get(sub) > freq.get(sub)) {
                            String first = s.substring(lo, lo += LEN);
                            seen.put(first, seen.getOrDefault(first, 0) - 1);
                            if (seen.get(first) < freq.getOrDefault(first, 0))
                                --count;
                        }

                    if (count == N) {
                        ans.add(lo);
                        --count;
                        String first = s.substring(lo, lo += LEN);
                        seen.put(first, seen.get(first) - 1);
                    }
                } else {
                    seen.clear();
                    count = 0;
                    lo = j + LEN;
                }
            }
        }

        return ans;
    }
}