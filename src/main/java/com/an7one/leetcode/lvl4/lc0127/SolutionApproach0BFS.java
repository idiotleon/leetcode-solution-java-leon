/**
 * https://leetcode.com/problems/word-ladder/
 * 
 * Time Complexity:     O(N) + O(N * (26 ^ (L / 2))) ~ O(N * (26 ^ (L / 2)))
 * Space Complexity:    O(N * L) / O(N)
 * 
 * Bidirectional BFS
 * 
 * References:
 *  https://www.youtube.com/watch?v=vWPCm69MSfs
 *  http://zxi.mytechroad.com/blog/searching/127-word-ladder/
 *  https://leetcode.com/problems/word-ladder/discuss/40711/Two-end-BFS-in-Java-31ms.
 */
package com.an7one.leetcode.lvl4.lc0127;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionApproach0BFS {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        final Set<String> WORD_SET = new HashSet<>(wordList);
        if (!WORD_SET.contains(endWord))
            return 0;

        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);

        int steps = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                swap(beginSet, endSet);
            }

            Set<String> nextSet = new HashSet<>();
            for (String word : beginSet) {
                final int LEN = word.length();
                final char[] CHS = word.toCharArray();

                for (int i = 0; i < LEN; ++i) {
                    final char HOLD = CHS[i];
                    for (char ch = 'a'; ch <= 'z'; ++ch) {
                        CHS[i] = ch;
                        String newWord = new String(CHS);
                        if (endSet.contains(newWord))
                            return steps + 1;

                        if (!WORD_SET.contains(newWord))
                            continue;
                        nextSet.add(newWord);
                        WORD_SET.remove(newWord);
                    }

                    CHS[i] = HOLD;
                }
            }

            beginSet = nextSet;
            ++steps;
        }

        return 0;
    }

    private void swap(Set<String> set1, Set<String> set2) {
        Set<String> temp = set1;
        set1 = set2;
        set2 = temp;
    }
}