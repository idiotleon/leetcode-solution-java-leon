/**
 * https://leetcode.com/problems/find-smallest-common-element-in-all-rows/
 * 
 * Time Complexity:     O(NR * NC * lg(NR * NC))
 * Space Complexity:    O(NR * NC)
 * 
 * References:
 *  https://leetcode.com/problems/find-smallest-common-element-in-all-rows/discuss/386998/Simple-hashMap-Solution/487153
 */
package com.an7one.leetcode.lvl3.lc1198;

import java.util.Map;
import java.util.TreeMap;

public class SolutionApproach1TreeMap {
    public int smallestCommonElement(int[][] mat) {
        final int NR = mat.length;
        
        // not used
        // final int NC = mat[0].length;
        
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for(int[] row : mat){
            for(int num : row){
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        
        for(int key : map.keySet()){
            if(map.get(key) == NR){
                return key;
            }
        }
        
        return -1;
    }
}