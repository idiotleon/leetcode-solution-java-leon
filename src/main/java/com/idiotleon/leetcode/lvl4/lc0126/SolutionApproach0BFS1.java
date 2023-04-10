package com.idiotleon.leetcode.lvl4.lc0126;

import com.idiotleon.util.Constant;

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
 * Time Complexity:     O(N * (26 ^ (L / 2)))
 * Space Complexity:    O(N + k * LEN(path))
 * k, number of paths
 * LEN(path), length of the path
 * <p>
 * a double-ended BFS approach
 * <p>
 * Reference:
 * <a href="http://zxi.mytechroad.com/blog/searching/leetcode-126-word-ladder-ii/">Huahua</a>
 * <a href="https://youtu.be/PblfQrdWXQ4">Youtube</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0BFS1 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        final List<List<String>> paths = new ArrayList<>();

        final Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord))
            return paths;

        // hash set for both ends
        // to initialize words in both ends
        final Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        final Set<String> endSet = new HashSet<>();
        endSet.add(endWord);

        // to help construct the final result
        final Map<String, List<String>> map = new HashMap<>();

        List<String> path = new ArrayList<>();
        path.add(beginWord);

        // to build up the map
        if (canBeBuilt(beginSet, endSet, wordSet, map, false))
            // to generate all the list
            backtrack(beginWord, endWord, map, path, paths);

        return paths;
    }

    private boolean canBeBuilt(final Set<String> beginSet,
                               final Set<String> endSet,
                               final Set<String> dict,
                               final Map<String, List<String>> map,
                               boolean flip) {
        if (beginSet.isEmpty())
            return false;

        if (beginSet.size() > endSet.size())
            return canBeBuilt(endSet, beginSet, dict, map, !flip);

        // to remove words on current both ends from the dict
        dict.removeAll(beginSet);
        dict.removeAll(endSet);

        // as we only need the shortest paths
        // we use a boolean value to help with early termination
        boolean done = false;

        // set for the next level
        final Set<String> nextSet = new HashSet<>();

        // for each string in end1
        for (String word : beginSet) {
            final int len = word.length();
            for (int i = 0; i < len; ++i) {
                final char[] chs = word.toCharArray();

                // to change one character for every position
                for (char ch = 'a'; ch <= 'z'; ++ch) {
                    chs[i] = ch;

                    final String newWord = String.valueOf(chs);

                    // to make sure we construct the tree in the correct direction
                    final String key = flip ? newWord : word;
                    final String val = flip ? word : newWord;

                    final List<String> list = map.getOrDefault(key, new ArrayList<>());

                    if (endSet.contains(newWord)) {
                        done = true;

                        list.add(val);
                        map.put(key, list);
                    }

                    if (!done && dict.contains(newWord)) {
                        nextSet.add(newWord);

                        list.add(val);
                        map.put(key, list);
                    }
                }
            }
        }

        // to early terminate the recursion if "done" is true
        return done || canBeBuilt(endSet, nextSet, dict, map, !flip);
    }

    private void backtrack(final String start,
                           final String end,
                           final Map<String, List<String>> map,
                           final List<String> path,
                           final List<List<String>> paths) {
        if (start.equals(end)) {
            paths.add(new ArrayList<>(path));
            return;
        }

        // to check in case the difference between start and end happens to be one
        // e.g.: "a", "c", {"a", "b", "c"}
        if (!map.containsKey(start))
            return;

        for (String word : map.get(start)) {
            path.add(word);
            backtrack(word, end, map, path, paths);
            path.remove(path.size() - 1);
        }
    }
}