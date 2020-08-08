/**
 * https://leetcode.com/problems/vowel-spellchecker/
 * 
 * Time Complexity:     O(N * L)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/vowel-spellchecker/discuss/211414/Java-Clean-Code-use-Map.
 */
package com.zea7ot.lc.lvl3.lc0966;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SolutionApproach0HashMap {
    private static final Set<Character> VOWELS = new HashSet<Character>() {
        {
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
        }
    };

    private static final char PLACE_HOLDER = '.';

    public String[] spellchecker(String[] wordList, String[] queries) {
        final int N = queries.length;

        Map<String, String> wordMap = new HashMap<>();
        Map<String, String> patternMap = new HashMap<>();
        for (String word : wordList) {
            wordMap.put(word, word);
            patternMap.putIfAbsent(word.toLowerCase(), word);
            patternMap.putIfAbsent(wordPattern(word), word);
        }

        for (int i = 0; i < N; ++i) {
            String query = queries[i];
            if (wordMap.containsKey(query))
                continue;

            String lower = query.toLowerCase();
            if (patternMap.containsKey(lower)) {
                queries[i] = patternMap.get(lower);
                continue;
            }

            String pattern = wordPattern(query);
            if (patternMap.containsKey(pattern)) {
                queries[i] = patternMap.get(pattern);
                continue;
            }

            queries[i] = "";
        }

        return queries;
    }

    private String wordPattern(String word) {
        final int L = word.length();
        char[] chs = word.toLowerCase().toCharArray();
        for (int i = 0; i < L; ++i)
            if (VOWELS.contains(chs[i]))
                chs[i] = PLACE_HOLDER;
        return new String(chs);
    }
}