/**
 * https://leetcode.com/problems/vowel-spellchecker/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/vowel-spellchecker/discuss/211189/JavaC%2B%2BPython-Two-HashMap
 */
package com.zea7ot.leetcode.lvl3.lc0966;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SolutionApproach0HashMap1 {
    public String[] spellchecker(String[] wordList, String[] queries) {
        final int N = queries.length;

        Set<String> wordSet = new HashSet<String>(Arrays.asList(wordList));
        Map<String, String> capitalized = new HashMap<String, String>();
        Map<String, String> vowels = new HashMap<String, String>();
        for (String word : wordList) {
            String lower = word.toLowerCase();
            String devowel = lower.replaceAll("[aeiou]", "#");
            capitalized.putIfAbsent(lower, word);
            vowels.putIfAbsent(devowel, word);
        }

        for (int i = 0; i < N; ++i) {
            if (wordSet.contains(queries[i]))
                continue;
            String lower = queries[i].toLowerCase();
            String devowel = lower.replaceAll("[aeiou]", "#");
            if (capitalized.containsKey(lower)) {
                queries[i] = capitalized.get(lower);
            } else if (vowels.containsKey(devowel)) {
                queries[i] = vowels.get(devowel);
            } else
                queries[i] = "";
        }

        return queries;
    }
}