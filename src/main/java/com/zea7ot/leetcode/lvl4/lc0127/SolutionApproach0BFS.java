/**
 * https://leetcode.com/problems/word-ladder/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * double-end BFS
 * 
 * References:
 *  https://leetcode.com/problems/word-ladder/discuss/40711/Two-end-BFS-in-Java-31ms./119588
 *  https://leetcode.com/problems/word-ladder/discuss/40711/Two-end-BFS-in-Java-31ms.
 */
package com.zea7ot.leetcode.lvl4.lc0127;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionApproach0BFS {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        final Set<String> WORD_SET = new HashSet<String>(wordList);
        // sanity check
        if (!WORD_SET.contains(endWord))
            return 0;

        Set<String> beginSet = new HashSet<String>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<String>();
        endSet.add(endWord);

        int steps = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size())
                swap(beginSet, endSet);

            Set<String> nextSet = new HashSet<String>();
            for (String str : beginSet) {
                final int LEN = str.length();
                char[] chs = str.toCharArray();

                for (int i = 0; i < LEN; ++i) {
                    for (char ch = 'a'; ch <= 'z'; ++ch) {
                        char hold = chs[i];

                        chs[i] = ch;
                        String word = String.valueOf(chs);

                        if (endSet.contains(word))
                            return steps + 1;

                        if (WORD_SET.contains(word)) {
                            nextSet.add(word);
                            WORD_SET.remove(word);
                        }

                        chs[i] = hold;
                    }
                }
            }

            beginSet = nextSet.size() < endSet.size() ? nextSet : endSet;
            endSet = beginSet.size() < endSet.size() ? endSet : nextSet;
            ++steps;
        }

        return 0;
    }

    private void swap(Set<String> set1, Set<String> set2) {
        Set<String> set = set1;
        set1 = set2;
        set2 = set;
    }
}