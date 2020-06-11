/**
 * https://leetcode.com/problems/word-pattern/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(2 * L) ~ O(L)
 * 
 * References:
 *  https://leetcode.com/problems/word-pattern/discuss/73399/Very-fast-(3ms)-Java-Solution-using-HashMap/270654
 */
package com.zea7ot.lc.lvl2.lc0290;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SolutionApproach0HashMap {
    public boolean wordPattern(String pattern, String str) {
        String[] arr = str.split(" ");
        Map<Character, String> map = new HashMap<Character, String>();
        Set<String> used = new HashSet<String>();
        
        if(arr.length != pattern.length()) return false;
        char[] chs = pattern.toCharArray();
        for(int i = 0; i < arr.length; i++){
            char ch = chs[i];
            if(map.containsKey(ch)){
                if(!map.get(ch).equals(arr[i])) return false;
            }else{
                // str, represented by one pattern,
                // cannot be represented by another one.
                if(used.contains(arr[i])) return false;
                map.put(ch, arr[i]);
                used.add(arr[i]);
            }
        }
        
        return true;
    }
}