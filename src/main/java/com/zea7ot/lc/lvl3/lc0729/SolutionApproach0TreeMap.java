/**
 * https://leetcode.com/problems/my-calendar-i/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/my-calendar-i/discuss/109475/JavaC++-Clean-Code-with-Explanation/113896
 *  https://leetcode.com/problems/my-calendar-i/discuss/109475/JavaC%2B%2B-Clean-Code-with-Explanation
 */
package com.zea7ot.lc.lvl3.lc0729;

import java.util.TreeMap;

public class SolutionApproach0TreeMap {
    private TreeMap<Integer, Integer> map;

    public SolutionApproach0TreeMap() {
        this.map = new TreeMap<Integer, Integer>();
    }
    
    public boolean book(int start, int end) {
        Integer low = map.lowerKey(end);
        
        if(low == null || map.get(low) <= start){
            map.put(start, end);
            return true;
        }
        
        return false;
    }
}