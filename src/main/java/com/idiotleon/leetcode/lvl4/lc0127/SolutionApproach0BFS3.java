/**
 * https://leetcode.com/problems/word-ladder/
 * 
 * Time Complexity:     O(N) + O(N * (L ^ 26)) ~ O(N * (26 ^ L))
 *  L, average length of words in the `wordList`
 * 
 * Space Complexity:    O(N) + O(W) ~ O(N)
 * 
 * one-end BFS approach
 * 
 * References:
 *  https://leetcode.com/problems/word-ladder/discuss/40704/Java-Solution-using-BFS-with-explanation
 */
package com.idiotleon.leetcode.lvl4.lc0127;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionApproach0BFS3 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        final Set<String> WORD_SET = new HashSet<String>(wordList);
        // sanity check
        if (!WORD_SET.contains(endWord))
            return 0;

        Deque<String> queue = new ArrayDeque<String>();
        queue.add(beginWord);

        // to count the number of words transformed
        int steps = 1;
        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            // for all words in this round
            for (int i = 0; i < SIZE; ++i) {
                String first = queue.poll();
                final int LEN = first.length();
                final char[] CHS = first.toCharArray();

                // to traverse the current word
                for (int j = 0; j < LEN; ++j) {
                    final char HOLD = CHS[j];

                    // to change one letter at a time
                    for (char ch = 'a'; ch <= 'z'; ++ch) {
                        CHS[j] = ch;
                        String next = new String(CHS);

                        // when "next" word is in the set
                        if (!WORD_SET.contains(next))
                            continue;
                        if (next.equals(endWord))
                            return steps + 1;
                        queue.add(next);
                        WORD_SET.remove(next);
                    }

                    // have to undo for the next change of letter
                    CHS[j] = HOLD;
                }
            }

            // this round ends with one letter changed
            ++steps;
        }

        return 0;
    }
}