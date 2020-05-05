/**
 * https://leetcode.com/problems/triangle/
 */
package com.polyg7ot.lc.lvl4.lc0120;

import java.util.List;

public class SolutionApproachDPInPlace {
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i = triangle.size() - 2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
            }
        }
        
        return triangle.get(0).get(0);
    }

    // to elaborate the above method
    public int minimumTotal2(List<List<Integer>> triangle) {
        for(int i = triangle.size() - 2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                int self = triangle.get(i).get(j);  // to get the [row](i + 1) & [col](j + 1)
                // to get the min value of adjacent values
                int res = Math.min(triangle.get(i + 1).get(j) + self, triangle.get(i + 1).get(j + 1) + self);
                triangle.get(i).set(j, res);    // to update [row](i + 1) & [col](j + 1)
            }
        }
        
        return triangle.get(0).get(0);
    }
}