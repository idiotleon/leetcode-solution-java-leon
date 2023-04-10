/**
 * https://leetcode.com/problems/minimum-area-rectangle/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/minimum-area-rectangle/discuss/192021/Python-O(N1.5)-80ms/284140
 */
package com.idiotleon.leetcode.lvl3.lc0939;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SolutionApproach1TreeMap {
    public int minAreaRect(int[][] points) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for(int[] point : points){
            map.putIfAbsent(point[0], new ArrayList<>());
            map.get(point[0]).add(point[1]);
        }
        
        int ans = Integer.MAX_VALUE;
        Map<String, Integer> seen = new HashMap<>();
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            Collections.sort(entry.getValue());
            int curX = entry.getKey();
            List<Integer> ys = entry.getValue();
            for(int i = 0; i < ys.size(); ++i){
                for(int j = i + 1; j < ys.size(); ++j){
                    String encoded = ys.get(i) + "#" + ys.get(j);
                    if(seen.containsKey(encoded)){
                        ans = Math.min(ans, (curX - seen.get(encoded)) * (ys.get(j) - ys.get(i)));
                    }
                    seen.put(encoded, curX);
                }
            }
        }
        
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}