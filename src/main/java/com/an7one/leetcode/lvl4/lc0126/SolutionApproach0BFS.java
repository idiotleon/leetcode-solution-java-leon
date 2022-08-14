package com.an7one.leetcode.lvl4.lc0126;

import com.an7one.util.Constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/word-ladder-ii/">LC0126</a>
 * <p>
 * Time Complexity:     O()
 * Space Complexity:    O()
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/word-ladder-ii/discuss/40475/My-concise-JAVA-solution-based-on-BFS-and-DFS/177427">LC Discussion</a>
 * <a href="https://leetcode.com/problems/word-ladder-ii/discuss/40475/My-concise-JAVA-solution-based-on-BFS-and-DFS">LC Discussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0BFS {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        final List<List<String>> paths = new ArrayList<>();
        // sanity check
        if (wordList == null || wordList.isEmpty())
            return paths;

        final Set<String> wordSet = new HashSet<>(wordList);
        // sanity check
        if (!wordSet.contains(endWord))
            return paths;

        final Map<String, List<String>> graph = new HashMap<>();
        Set<String> curLevel = new HashSet<>();
        curLevel.add(beginWord);

        boolean found = false;

        while (!curLevel.isEmpty() && !found) {
            wordSet.removeAll(curLevel);
            final Set<String> nextLevel = new HashSet<>();

            for (String word : curLevel) {
                final int len = word.length();
                graph.putIfAbsent(word, new ArrayList<>());
                final char[] chs = word.toCharArray();

                for (int i = 0; i < len; ++i) {
                    final char HOLD = chs[i];
                    for (char ch = 'a'; ch <= 'z'; ++ch) {
                        chs[i] = ch;
                        final String newWord = new String(chs);
                        if (!wordSet.contains(newWord))
                            continue;
                        graph.get(word).add(newWord);
                        nextLevel.add(newWord);
                        if (newWord.equals(endWord))
                            found = true;
                    }
                    chs[i] = HOLD;
                }

                curLevel = nextLevel;
            }
        }

        if (!found)
            return paths;

        final List<String> path = new ArrayList<>();
        path.add(beginWord);
        backtrack(beginWord, endWord, graph, path, paths);
        return paths;
    }

    private void backtrack(final String start,
                           final String end,
                           final Map<String, List<String>> graph,
                           final List<String> path,
                           final List<List<String>> paths) {
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