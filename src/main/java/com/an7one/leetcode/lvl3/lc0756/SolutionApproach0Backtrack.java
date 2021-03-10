/**
 * https://leetcode.com/problems/pyramid-transition-matrix/
 * 
 * Time Complexity:     O()
 * Space Compleixty:    O()
 * 
 * References:
 *  https://leetcode.com/problems/pyramid-transition-matrix/discuss/113054/Java-solution-map-%2B-backtracking
 */
package com.an7one.leetcode.lvl3.lc0756;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionApproach0Backtrack {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String str : allowed){
            String seg = str.substring(0, 2);
            map.putIfAbsent(seg, new ArrayList<String>());
            map.get(seg).add(str.substring(2));
        }
        
        return canStack(bottom, map);
    }
    
    private boolean canStack(String bottom, Map<String, List<String>> map){
        if(bottom.length() == 1) return true;
        for(int i = 0; i < bottom.length() - 1; i++){
            if(!map.containsKey(bottom.substring(i, i + 2))){
                return false;
            }
        }
        
        List<String> path = new ArrayList<String>();
        getList(bottom, 0, new StringBuilder(), path, map);
        for(String str : path){
            if(canStack(str, map)){
                return true;
            }
        }
        
        return false;
    }
    
    private void getList(String bottom, 
                         int idx, 
                         StringBuilder builder, 
                         List<String> path, 
                         Map<String, List<String>> map){
        
        if(idx == bottom.length() - 1){
            path.add(builder.toString());
            return;
        }
        
        for(String str : map.get(bottom.substring(idx, idx + 2))){
            builder.append(str);
            getList(bottom, idx + 1, builder, path, map);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}