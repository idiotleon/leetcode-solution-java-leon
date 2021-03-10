/**
 * https://leetcode.com/problems/number-of-atoms/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/number-of-atoms/discuss/109346/Java-solution-Map-%2B-Recursion
 */
package com.an7one.leetcode.lvl4.lc0726;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionApproach0Recursion {
    public String countOfAtoms(String formula) {
        Map<String, Integer> map = helper(formula);
        
        List<String> atoms = new ArrayList<String>(map.keySet());
        Collections.sort(atoms);
        StringBuilder builder = new StringBuilder();
        for(String atom : atoms){
            builder.append(atom + (map.get(atom) > 1 ? map.get(atom) : ""));
        }
        
        return builder.toString();
    }
    
    private Map<String, Integer> helper(String formula){
        Map<String, Integer> map = new HashMap<String, Integer>();
        if(formula.isEmpty()) return map;
        
        final int L = formula.length();
        char[] chs = formula.toCharArray();
        
        int i = 0;
        while(i < L){
            if(chs[i] == '('){
                int count = 0, j = i;
                for(; j < L; j++){
                    if(chs[j] == '(') count++;
                    else if(chs[j] == ')') count--;
                    if(count == 0) break;
                }
                
                Map<String, Integer> subMap = helper(formula.substring(i + 1, j));
                
                j++;
                int n = 1, k = j;
                while(k < L && Character.isDigit(chs[k])) k++;
                if(k > j) n = Integer.parseInt(formula.substring(j, k));
                
                for(Map.Entry<String, Integer> entry : subMap.entrySet()){
                    String atom = entry.getKey();
                    int value = entry.getValue();
                    map.put(atom, value * n + map.getOrDefault(atom, 0));
                }
                
                i = k;
            }else{
                int j = i + 1;
                while(j < L && chs[j] >= 'a' && chs[j] <= 'z') j++;
                
                int n = 1, k = j;
                while(k < L && Character.isDigit(chs[k])) k++;
                if(k > j) n = Integer.parseInt(formula.substring(j, k));
                
                String atom = formula.substring(i, j);
                map.put(atom, n + map.getOrDefault(atom, 0));
                
                i = k;
            }
        }
        
        return map;
    }
}