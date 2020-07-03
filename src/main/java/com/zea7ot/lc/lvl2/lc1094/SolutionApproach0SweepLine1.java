/**
 * https://leetcode.com/problems/car-pooling/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/car-pooling/discuss/317611/C%2B%2BJava-O(n)-Thousand-and-One-Stops
 */
package com.zea7ot.lc.lvl2.lc1094;

import java.util.Map;
import java.util.TreeMap;

public class SolutionApproach0SweepLine1 {
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for(int[] trip : trips){
            map.put(trip[1], map.getOrDefault(trip[1], 0) + trip[0]);
            map.put(trip[2], map.getOrDefault(trip[2], 0) - trip[0]);
        }
        
        for(int value : map.values()){
            capacity -= value;
            if(capacity < 0) return false;
        }
        
        return true;
    }
}