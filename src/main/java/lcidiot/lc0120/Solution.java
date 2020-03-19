/**
 * https://leetcode.com/problems/triangle/
 */
package main.java.lcidiot.lc0120;

import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] results = new int[size + 1];
        
        for(int i = size - 1; i >= 0; i--){
            List<Integer> temp = triangle.get(i);
            
            for(int j = 0; j < temp.size(); j++)
                results[j] = Math.min(results[j], results[j + 1]) + temp.get(j);
        }
        
        return results[0];
    }

    // solution ii: very compact version
    public int minimumTotal2(List<List<Integer>> triangle) {
        for(int i = triangle.size() - 2; i >= 0; i--)
            for(int j = 0; j <= i; j++)
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
        
        return triangle.get(0).get(0);
    }
}