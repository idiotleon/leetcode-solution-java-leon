/**
 * https://leetcode.com/problems/word-pattern-ii/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/word-pattern-ii/discuss/73681/20-lines-JAVA-clean-solution-easy-to-understand/76629
 */
package com.zea7ot.leetcode.lvl2.lc0290;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0HashMap2 {
    private Map<Character, String> map = new HashMap<Character, String>();

    public boolean wordPatternMatch(String pattern, String str) {
        if (pattern.isEmpty())
            return str.isEmpty();

        char[] chs = pattern.toCharArray();
        if (map.containsKey(chs[0])) {
            String matched = map.get(chs[0]);
            if (str.length() < matched.length() || !str.substring(0, matched.length()).equals(matched))
                return false;

            if (wordPatternMatch(pattern.substring(1), str.substring(matched.length())))
                return true;
        } else {
            for (int i = 1; i <= str.length(); i++) {
                String toBeMatched = str.substring(0, i);
                if (map.containsValue(toBeMatched))
                    continue;
                map.put(chs[0], toBeMatched);
                if (wordPatternMatch(pattern.substring(1), str.substring(i)))
                    return true;
                // to backtrack
                map.remove(chs[0]);
            }
        }

        return false;
    }
}