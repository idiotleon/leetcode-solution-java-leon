/**
 * https://leetcode.com/problems/shortest-distance-to-target-color/
 * 
 * Time Complexity: O(Q * lg(N))
 * Space Complexity: O(N)
 * 
 * References:
 *  https://leetcode.com/problems/shortest-distance-to-target-color/discuss/384822/Java-binary-search
 */
package com.idiotleon.leetcode.lvl2.lc1182;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionApproach0BinarySearch {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        Map<Integer, List<Integer>> idxMap = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < colors.length; i++){
            int color = colors[i];
            idxMap.putIfAbsent(color, new ArrayList<Integer>());
            idxMap.get(color).add(i);
        }
        
        List<Integer> ans = new ArrayList<Integer>();
        for(int[] query : queries){
            int index = query[0];
            int color = query[1];
            if(!idxMap.containsKey(color)){
                ans.add(-1);
            }else{
                ans.add(binarySearch(idxMap.get(color), index));
            }
        }
        
        return ans;
    }
    
    private int binarySearch(List<Integer> indexes, int index){
        int left = 0, right = indexes.size() - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(indexes.get(mid) < index){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        
        int ans = left;
        if(left - 1 >= 0 && index - indexes.get(left - 1) < indexes.get(left) - index){
            ans = left - 1;
        }
        return Math.abs(indexes.get(ans) - index);
    }
}