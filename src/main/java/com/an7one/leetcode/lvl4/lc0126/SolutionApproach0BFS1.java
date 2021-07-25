package com.an7one.leetcode.lvl4.lc0126;

import com.an7one.util.Constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-ladder-ii/
 * <p>
 * Time Complexity:     O(N * (26 ^ (L / 2)))
 * Space Complexity:    O(N + k * LEN(path))
 * k, number of paths
 * LEN(path), length of the path
 * <p>
 * a double-ended BFS approach
 * <p>
 * References:
 * http://zxi.mytechroad.com/blog/searching/leetcode-126-word-ladder-ii/
 * https://www.youtube.com/watch?v=PblfQrdWXQ4
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0BFS1 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> paths = new ArrayList<>();

        final Set<String> WORD_SET = new HashSet<>(wordList);
        if (!WORD_SET.contains(endWord))
            return paths;

        // hash set for both ends
        // to initialize words in both ends
        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);

        // to help construct the final result
        Map<String, List<String>> map = new HashMap<>();

        List<String> path = new ArrayList<>();
        path.add(beginWord);

        // to build up the map
        if (canBeBuilt(beginSet, endSet, WORD_SET, map, false))
            // to generate all the list
            backtrack(beginWord, endWord, map, path, paths);

        return paths;
    }

    private boolean canBeBuilt(Set<String> beginSet, Set<String> endSet, Set<String> dict,
                               Map<String, List<String>> map, boolean flip) {
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
        Set<String> nextSet = new HashSet<>();

        // for each string in end1
        for (String word : beginSet) {
            final int LEN = word.length();
            for (int i = 0; i < LEN; ++i) {
                final char[] CHS = word.toCharArray();

                // to change one character for every position
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    CHS[i] = ch;

                    String newWord = String.valueOf(CHS);

                    // to make sure we construct the tree in the correct direction
                    String key = flip ? newWord : word;
                    String val = flip ? word : newWord;

                    List<String> list = map.getOrDefault(key, new ArrayList<>());

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

    private void backtrack(String start, String end, Map<String, List<String>> map, List<String> path,
                           List<List<String>> paths) {
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