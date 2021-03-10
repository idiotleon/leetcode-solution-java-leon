/**
 * https://leetcode.com/problems/snapshot-array/
 * 
 * Time Complexities:     
 *  `set(int index, int val)`:      O(1)
 *  `snap()`:                       O(1)
 *  `get(int index, int snapId)`:   O(N)
 * 
 * Space Complexity:                O(N ^ 2)
 * 
 * References:
 *  https://leetcode.com/problems/snapshot-array/discuss/454280/Java-list-and-map-explained-clean-beats-95
 */
package com.an7one.leetcode.lvl3.lc1146;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionApproach0ListOfHashMaps {
    private List<Map<Integer, Integer>> list;

    public SolutionApproach0ListOfHashMaps(int length) {
        list = new ArrayList<Map<Integer, Integer>>();
        list.add(new HashMap<Integer, Integer>());
    }
    
    public void set(int index, int val) {
        int snapId = list.size() - 1;
        list.get(snapId).put(index, val);
    }
    
    public int snap() {
        list.add(new HashMap<Integer, Integer>());
        return list.size() - 2;
    }
    
    public int get(int index, int snapId) {
        for(int snap = snapId; snap >= 0; snap--){
            if(list.get(snap).containsKey(index)){
                return list.get(snap).get(index);
            }
        }
        
        return 0;
    }
}