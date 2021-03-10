/**
 * https://leetcode.com/problems/word-pattern/
 * 
 * Time Complexity:     O(L * 26)
 *  L, length of the pattern(String)
 *  map.containsValue(arr[i]) is of O(LEN(map.keySet())),
 *      while in this particular case, 26 at most 
 * 
 * Space Complexity:    O(L)
 * 
 * References:
 *  https://leetcode.com/problems/word-pattern/discuss/73399/Very-fast-(3ms)-Java-Solution-using-HashMap
 */
package com.an7one.leetcode.lvl2.lc0290;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0HashMap1 {
    public boolean wordPattern(String pattern, String str) {
        String[] arr = str.split(" ");
        Map<Character, String> map = new HashMap<Character, String>();

        if (arr.length != pattern.length())
            return false;
        char[] chs = pattern.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char ch = chs[i];
            if (map.containsKey(ch)) {
                if (!map.get(ch).equals(arr[i]))
                    return false;
            } else {
                /**
                 * pattern = "abba" str = "dog dog dog dog" expected: false
                 */
                if (map.containsValue(arr[i]))
                    return false;
                map.put(ch, arr[i]);
            }
        }

        return true;
    }
}