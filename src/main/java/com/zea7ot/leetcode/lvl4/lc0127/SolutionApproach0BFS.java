/**
 * https://leetcode.com/problems/word-ladder/
 * 
 * Time Complexity:     O(N) + O(N * (26 ^ (L / 2))) ~ O(N * (26 ^ (L / 2)))
 * Space Complexity:    O(N * L) / O(N)
 * 
 * double-end BFS
 * 
 * References:
 *  https://leetcode.com/problems/word-ladder/discuss/40711/Two-end-BFS-in-Java-31ms./119588
 *  https://leetcode.com/problems/word-ladder/discuss/40711/Two-end-BFS-in-Java-31ms.
 *  https://www.youtube.com/watch?v=vWPCm69MSfs
 *  http://zxi.mytechroad.com/blog/searching/127-word-ladder/
 *  http://theoryofprogramming.com/2018/01/21/bidirectional-search/
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
            Set<String> nextSet = new HashSet<String>();
            for (String word : beginSet) {
                final int LEN = word.length();
                final char[] CHS = word.toCharArray();

                for (int i = 0; i < LEN; ++i) {
                    final char HOLD = CHS[i];
                    for (char ch = 'a'; ch <= 'z'; ++ch) {

                        CHS[i] = ch;
                        String newWord = String.valueOf(CHS);

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

            beginSet = nextSet.size() < endSet.size() ? nextSet : endSet;
            endSet = beginSet == nextSet ? endSet : nextSet;
            ++steps;
        }

        return 0;
    }
}