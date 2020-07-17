/**
 * https://leetcode.com/problems/triangle/
 */
package com.zea7ot.lc.lvl4.lc0120;

import java.util.List;

public class SolutionApproach0DP1 {
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i = triangle.size() - 2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
            }
        }
        
        return triangle.get(0).get(0);
    }
}