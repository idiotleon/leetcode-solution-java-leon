/**
 * https://leetcode.com/problems/my-calendar-ii/
 * 
 * Time Complexity:     O((N ^ 2) * lg(N))
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/my-calendar-ii/discuss/109522/Simplified-winner's-solution/111433
 *  https://leetcode.com/problems/my-calendar-ii/discuss/109522/Simplified-winner's-solution
 *  https://leetcode.com/problems/my-calendar-ii/discuss/109522/Simplified-winner's-solution/375247
 */
package com.zea7ot.leetcode.lvl3.lc0731;

import java.util.Map;
import java.util.TreeMap;

public class SolutionApproach1TreeMap {
    private Map<Integer, Integer> map;

    public SolutionApproach1TreeMap() {
        this.map = new TreeMap<Integer, Integer>();
    }
    
    public boolean book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int booked = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getKey() >= end) return true;
            booked += entry.getValue();
            if(booked == 3){
                map.put(start, map.get(start) - 1);
                map.put(end, map.get(end) + 1);
                return false;
            }
        }
        
        return true;
    }
}