/**
 * https://leetcode.com/problems/word-pattern-ii/
 * 
 * Time Complexity:     O(LEN(str) ^ LEN(pattern))
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/word-pattern-ii/discuss/73664/Share-my-Java-backtracking-solution
 */
package com.zea7ot.lc.lvl5.lc0291;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SolutionApproach0Backtrack {
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<Character, String>();
        Set<String> used = new HashSet<String>();
        
        return isMatch(str, 0, pattern, 0, map, used);
    }
    
    private boolean isMatch(String str, int i, 
                            String pattern, int j, 
                            Map<Character, String> map, 
                            Set<String> used){
        // base case
        if(i == str.length() && j == pattern.length()) return true;
        if(j == str.length() || j == pattern.length()) return false;
        
        char ch = pattern.charAt(j);
        
        // situations where the certain pattern has been matched
        if(map.containsKey(ch)){
            String matched = map.get(ch);
            
            if(!str.startsWith(matched, i)) return false;
            
            return isMatch(str, i + matched.length(), 
                           pattern, j + 1, 
                           map, used);
        }
        
        // situations where not any pattern has been matched
        for(int k = i; k < str.length(); k++){
            String p = str.substring(i, k + 1);
        
            if(used.contains(p)) continue;

            map.put(ch, p);
            used.add(p);
            
            // to continue to match the rest
            if(isMatch(str, k + 1, 
                       pattern, j + 1, 
                       map, used)) 
                return true;
            
            // to backtrack
            map.remove(ch);
            used.remove(p);
        }
        
        return false;
    }
}