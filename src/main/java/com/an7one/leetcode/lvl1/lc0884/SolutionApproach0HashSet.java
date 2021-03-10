/**
 * https://leetcode.com/problems/uncommon-words-from-two-sentences/
 * 
 * Time Complexity:     O(LEN_A + LEN_B)
 * Space Complexity:    O(LEN_A + LEN_B)
 * 
 * References:
 *  https://leetcode.com/problems/uncommon-words-from-two-sentences/discuss/158981/JavaPython-3-HashMapCounter-and-HashSets.
 */
package com.an7one.leetcode.lvl1.lc0884;

import java.util.HashSet;
import java.util.Set;

public class SolutionApproach0HashSet {
    public String[] uncommonFromSentences(String A, String B) {
        Set<String> distinct = new HashSet<>();
        Set<String> common = new HashSet<>();
        for (String word : (A + " " + B).split("\\s"))
            if (common.contains(word) || !distinct.add(word)) {
                distinct.remove(word);
                common.add(word);
            }

        return distinct.toArray(new String[0]);
    }
}