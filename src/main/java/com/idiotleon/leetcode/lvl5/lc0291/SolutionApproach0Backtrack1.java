/**
 * https://leetcode.com/problems/word-pattern-ii/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/word-pattern-ii/discuss/73681/20-lines-JAVA-clean-solution-easy-to-understand
 */
package com.idiotleon.leetcode.lvl5.lc0291;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SolutionApproach0Backtrack1 {
    private Map<Character, String> map = new HashMap<Character, String>();
    private Set<String> used = new HashSet<String>();
    
    public boolean wordPatternMatch(String pattern, String str) {
        if(pattern.isEmpty()) return str.isEmpty();
        
        char[] chs = pattern.toCharArray();
        if(map.containsKey(chs[0])){
            String matched = map.get(chs[0]);
            if(str.length() < matched.length() 
               || !str.substring(0, matched.length()).equals(matched)) 
                return false;
            
            if(wordPatternMatch(pattern.substring(1), str.substring(matched.length())))
                return true;
        }else{
            for(int i = 1; i <= str.length(); i++){
                String toBeMatched = str.substring(0, i);
                if(used.contains(toBeMatched)) continue;
                map.put(chs[0], toBeMatched);
                used.add(toBeMatched);
                if(wordPatternMatch(pattern.substring(1), str.substring(i))) return true;
                // to backtrack
                map.remove(chs[0]);
                used.remove(toBeMatched);
            }
            
        }
        
        return false;
    }
}