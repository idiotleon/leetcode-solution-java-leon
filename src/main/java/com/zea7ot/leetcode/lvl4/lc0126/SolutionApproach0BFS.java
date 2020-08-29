/**
 * https://leetcode.com/problems/word-ladder-ii/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/word-ladder-ii/discuss/40475/My-concise-JAVA-solution-based-on-BFS-and-DFS/177427
 *  https://leetcode.com/problems/word-ladder-ii/discuss/40475/My-concise-JAVA-solution-based-on-BFS-and-DFS
 */
package com.zea7ot.leetcode.lvl4.lc0126;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SolutionApproach0BFS {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> paths = new ArrayList<>();
        // sanity check
        if (wordList == null || wordList.isEmpty())
            return paths;

        final Set<String> WORD_SET = new HashSet<>(wordList);
        // sanity check
        if (!WORD_SET.contains(endWord))
            return paths;

        Map<String, List<String>> graph = new HashMap<>();
        Set<String> curLevel = new HashSet<>();
        curLevel.add(beginWord);

        boolean found = false;

        while (!curLevel.isEmpty() && !found) {
            WORD_SET.removeAll(curLevel);
            Set<String> nextLevel = new HashSet<>();

            for (String word : curLevel) {
                final int LEN = word.length();
                graph.putIfAbsent(word, new ArrayList<>());
                final char[] CHS = word.toCharArray();

                for (int i = 0; i < LEN; ++i) {
                    final char HOLD = CHS[i];
                    for (char ch = 'a'; ch <= 'z'; ++ch) {
                        CHS[i] = ch;
                        String newWord = new String(CHS);
                        if (!WORD_SET.contains(newWord))
                            continue;
                        graph.get(word).add(newWord);
                        nextLevel.add(newWord);
                        if (newWord.equals(endWord))
                            found = true;
                    }
                    CHS[i] = HOLD;
                }

                curLevel = nextLevel;
            }
        }

        if (!found)
            return paths;

        List<String> path = new ArrayList<>();
        path.add(beginWord);
        backtrack(beginWord, endWord, graph, path, paths);
        return paths;
    }

    private void backtrack(String start, String end, Map<String, List<String>> graph, List<String> path,
            List<List<String>> paths) {
        if (end.equals(start)) {
            paths.add(new ArrayList<>(path));
            return;
        }

        if (!graph.containsKey(start))
            return;

        for (String next : graph.get(start)) {
            path.add(next);
            backtrack(next, end, graph, path, paths);
            path.remove(path.size() - 1);
        }
    }
}