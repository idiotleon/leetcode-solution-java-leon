/**
 * https://leetcode.com/problems/triangle/
 */
package com.null7ptr.lc.lvl4.lc0120;

import java.util.List;

public class SolutionApproachDP {
    public int minimumTotal(List<List<Integer>> triangle) {
        final int SIZE = triangle.size();
        int[] results = new int[SIZE + 1];
        
        for(int i = SIZE - 1; i >= 0; i--){
            List<Integer> temp = triangle.get(i);
            
            for(int j = 0; j < temp.size(); j++){
                results[j] = Math.min(results[j], results[j + 1]) + temp.get(j);
            }
        }
        
        return results[0];
    }
}