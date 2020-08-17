/**
 * https://leetcode.com/problems/pyramid-transition-matrix/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/pyramid-transition-matrix/discuss/149032/A-small-trick-to-make-your-backtracking-much-cleaner.-~15-line-Java
 */
package com.zea7ot.leetcode.lvl3.lc0756;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionApproach0DFS {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> map = new HashMap<String, List<Character>>();
        for(String str : allowed){
            String seg = str.substring(0, 2);
            map.putIfAbsent(seg, new ArrayList<Character>());
            map.get(seg).add(str.charAt(2));
        }
        
        return canStack(bottom + ' ', map);
    }
    
    private boolean canStack(String str, Map<String, List<Character>> map){
        if(str.length() == 1) return true;
        String seg = str.substring(0, 2);
        if(seg.charAt(1) == ' ') return canStack(str.substring(2, str.length()) + ' ', map);
        for(Character ch : map.getOrDefault(seg, new ArrayList<Character>())){
            if(canStack(str.substring(1, str.length()) + ch, map)){
                return true;
            }
        }
        
        return false;
    }
}