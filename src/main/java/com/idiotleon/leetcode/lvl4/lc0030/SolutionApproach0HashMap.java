package com.idiotleon.leetcode.lvl4.lc0030;

import com.idiotleon.util.Constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Leon
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 *
 * Time Complexity:     O(`N` * `L` * `LEN`)
 * Space Complexity:    O(`N` * `L`)
 *
 * References:
 *  https://leetcode.com/problems/substring-with-concatenation-of-all-words/discuss/13658/Easy-Two-Map-Solution-(C++Java)/299685
 *  https://leetcode.com/problems/substring-with-concatenation-of-all-words/discuss/13658/Easy-Two-Map-Solution-(C++Java)/448495
 *  https://leetcode.com/problems/substring-with-concatenation-of-all-words/discuss/13658/Easy-Two-Map-Solution-(C%2B%2BJava)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0HashMap {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (s == null || s.isEmpty() || words == null || words.length == 0)
            return ans;

        final int L = s.length(), N = words.length, LEN = words[0].length();

        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < L - N * LEN + 1; ++i) {
            String sub = s.substring(i, i + N * LEN);
            if (isConcat(sub, freq, LEN))
                ans.add(i);
        }

        return ans;
    }

    private boolean isConcat(String sub, Map<String, Integer> freq, final int LEN) {
        final int L = sub.length();
        Map<String, Integer> seen = new HashMap<>();
        for (int i = 0; i < L; i += LEN) {
            String word = sub.substring(i, i + LEN);
            seen.put(word, seen.getOrDefault(word, 0) + 1);
            if (!freq.containsKey(word) || seen.get(word) > freq.get(word))
                return false;
        }

        return true;
    }

    // another version of `isConcat(,,)`
    // private boolean isConcat1(String sub, Map<String, Integer> freq, final int
    // LEN) {
    // final int L = sub.length();
    // Map<String, Integer> seen = new HashMap<>();
    // for (int i = 0; i < L; i += LEN) {
    // String word = sub.substring(i, i + LEN);
    // seen.put(word, seen.getOrDefault(word, 0) + 1);
    // }

    // return seen.equals(freq);
    // }
}