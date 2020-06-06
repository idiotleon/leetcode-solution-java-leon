/**
 * https://leetcode.com/problems/group-anagrams/
 */
package com.zea7ot.lc.lvl3.lc0049;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // sanity check
        if(strs == null || strs.length == 0) 
            return new ArrayList<List<String>>();
        
        Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
        for(String str : strs){
            int keyStr = getId(str);
            if(!map.containsKey(keyStr))
                map.put(keyStr, new ArrayList<String>());
            map.get(keyStr).add(str);
        }
        
        return new ArrayList<List<String>>(map.values());
    }
    
    private int getId(String str){
        int[] counter = new int[26];
        for(char ch : str.toCharArray()){
            counter[ch - 'a']++;
        }
        
        return Arrays.hashCode(counter);
    }
}