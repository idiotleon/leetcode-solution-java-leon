/**
 * https://leetcode.com/problems/word-ladder/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * double-end BFS
 * 
 * References:
 *  https://leetcode.com/problems/word-ladder/discuss/40711/Two-end-BFS-in-Java-31ms.
 */
package com.an7one.leetcode.lvl4.lc0127;

import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class SolutionApproach0DFS {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        final Set<String> WORD_SET = new HashSet<String>(wordList);
        // sanity check
        if (!WORD_SET.contains(endWord))
            return 0;

        Set<String> beginSet = new HashSet<String>();
        beginSet.add(beginWord);

        Set<String> endSet = new HashSet<String>();
        endSet.add(endWord);

        return dfs(1, beginSet, endSet, WORD_SET);
    }

    private int dfs(int level, Set<String> beginSet, Set<String> endSet, final Set<String> WORD_SET) {
        if (beginSet.isEmpty())
            return 0;

        if (beginSet.size() > endSet.size())
            return dfs(level, endSet, beginSet, WORD_SET);

        // to remove words from both ends
        for (String word : beginSet)
            WORD_SET.remove(word);
        // equivalent
        // dict.removeAll(beginSet);
        for (String word : endSet)
            WORD_SET.remove(word);
        // equivalent
        // dict.removeAll(endSet);

        // the set for the next level
        Set<String> nextSet = new HashSet<String>();

        // for each string in the current level
        for (String str : beginSet) {
            final int LEN = str.length();
            for (int i = 0; i < LEN; ++i) {
                char[] chs = str.toCharArray();

                // to change the letter at every position
                for (char ch = 'a'; ch <= 'z'; ++ch) {
                    chs[i] = ch;
                    String word = String.valueOf(chs);

                    // found the word in other end(set)
                    if (endSet.contains(word))
                        return level + 1;

                    // if not, add it to the next level
                    if (WORD_SET.contains(word))
                        nextSet.add(word);
                }
            }
        }

        return dfs(level + 1, endSet, nextSet, WORD_SET);
    }
}