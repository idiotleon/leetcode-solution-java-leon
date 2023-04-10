package com.idiotleon.leetcode.lvl2.lc0720;

import com.idiotleon.util.Constant;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/longest-word-in-dictionary/">LC0720</a>
 * <p>
 * Time Complexity: O(N * lg(N))
 * Space Complexity: O(N)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach1Sorting {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        final Set<String> shorter = new HashSet<>();
        String ans = "";
        for (String word : words) {
            if (word.length() == 1 || shorter.contains(word.substring(0, word.length() - 1))) {
                ans = word.length() > ans.length() ? word : ans;
                shorter.add(word);
            }
        }

        return ans;
    }
}