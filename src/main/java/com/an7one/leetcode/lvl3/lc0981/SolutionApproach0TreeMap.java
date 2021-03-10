/**
 * https://leetcode.com/problems/time-based-key-value-store/
 * 
 * References:
 *  https://leetcode.com/problems/time-based-key-value-store/discuss/226663/TreeMap-Solution-Java
 */
package com.an7one.leetcode.lvl3.lc0981;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SolutionApproach0TreeMap {
    private Map<String, TreeMap<Integer, String>> map;

    /** Initialize your data structure here. */
    public SolutionApproach0TreeMap() {
        this.map = new HashMap<String, TreeMap<Integer, String>>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new TreeMap<Integer, String>());
        }
        
        map.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> treeMap = map.get(key);
        if(treeMap == null) return "";
        
        Integer floor = treeMap.floorKey(timestamp);
        if(floor == null) return "";
        
        return treeMap.get(floor);
    }
}