/**
 * https://leetcode.com/problems/snapshot-array/
 * 
 * Time Complexities:
 *  `set(int index, int val)`:      O(lg(NUMS(`set()`)))
 *  `snap()`:                       O(1)
 *  `get(int index, int snapId)`:   O(lg(NUMS(`set()`)))
 * 
 * Space Complexity:                O(NUMS(`set()`))
 * 
 * References:
 *  https://leetcode.com/problems/snapshot-array/discuss/350562/JavaPython-Binary-Search
 *  https://leetcode.com/problems/snapshot-array/discuss/350574/Java-Two-codes-w-analysis-store-difference-by-HashMap-and-TreeMap-respectively.
 */
package com.an7one.leetcode.lvl3.lc1146;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class SolutionApproach0ListOfTreeMaps {
    private List<TreeMap<Integer, Integer>> list;
    private int snapId;

    public SolutionApproach0ListOfTreeMaps(int length) {
        this.list = new ArrayList<TreeMap<Integer, Integer>>(length);
        for(int i = 0; i < length; i++){
            list.add(new TreeMap<Integer, Integer>());
            list.get(i).put(0, 0);
        }
    }
    
    public void set(int index, int val) {
        list.get(index).put(snapId, val);
    }
    
    public int snap() {
        return snapId++;
    }
    
    public int get(int index, int snapId) {
        return list.get(index).floorEntry(snapId).getValue();
    }
}