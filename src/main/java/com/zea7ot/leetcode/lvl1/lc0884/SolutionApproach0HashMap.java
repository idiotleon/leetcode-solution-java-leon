/**
 * https://leetcode.com/problems/uncommon-words-from-two-sentences/
 * 
 * Time Complexity:     O(LEN_A + LEN_B)
 * Space Complexity:    O(LEN_A + LEN_B)
 * 
 * References:
 *  https://leetcode.com/problems/uncommon-words-from-two-sentences/discuss/158967/C%2B%2BJavaPython-Easy-Solution-with-Explanation
 */
package com.zea7ot.leetcode.lvl1.lc0884;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionApproach0HashMap {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> freq = new HashMap<>();
        for (String word : A.split("\\s"))
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        for (String word : B.split("\\s"))
            freq.put(word, freq.getOrDefault(word, 0) + 1);

        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : freq.entrySet())
            if (entry.getValue() == 1)
                res.add(entry.getKey());

        // return res.toArray(String[]::new);
        // return res.toArray(new String[res.size()]);
        return res.toArray(new String[0]);
    }
}