/**
 * https://leetcode.com/problems/group-shifted-strings/
 */
package com.zea7ot.lc.lvl4.lc0249;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> ans = new ArrayList<List<String>>();
        // sanity check
        if(strings == null || strings.length == 0) return ans;
        
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        
        for(String str : strings){
            String key = hash(str);
            map.putIfAbsent(key, new ArrayList<String>());
            map.get(key).add(str);
        }
        
        for(String key : map.keySet()){
            ans.add(map.get(key));
        }
        
        return ans;
    }
    
    private String hash(String str){
        String hash = "0";
        for(int i = 1; i < str.length(); i++){
            // to simulate shift
            int cur =  (int)(str.charAt(i) - str.charAt(0));
            // alphabet letters in a circle
            if(cur < 0) cur += 26;
            hash += "," + cur;
        }
        
        return hash;
    }
}