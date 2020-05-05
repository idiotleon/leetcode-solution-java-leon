/**
 * https://leetcode.com/problems/diagonal-traverse-ii/
 */
package com.polyg7ot.lc.lvl3.lc1424;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class SolutionApproachTreeMap {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        TreeMap<Integer, Integer> idxMap = new TreeMap<Integer, Integer>();
        for(int i = 0; i < nums.size(); i++) idxMap.put(0 - i, 0);
        
        int index = 0;
        List<Integer> ans = new ArrayList<Integer>();
        
        while(!idxMap.isEmpty()){
            int key = idxMap.ceilingKey(index);
            
            while(key != idxMap.size()){
                int row = 0 - key;
                int col = idxMap.get(key);
                ans.add(nums.get(row).get(col));
                
                idxMap.put(key, col + 1);
                
                if(col == nums.get(row).size()) idxMap.remove(key);
            }
            
            index--;
        }
        
        return ans.stream().mapToInt(i -> i).toArray();
    }
}