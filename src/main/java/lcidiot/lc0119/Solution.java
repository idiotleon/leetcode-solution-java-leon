/**
 * https://leetcode.com/problems/pascals-triangle-ii/
 */
package main.java.lcidiot.lc0119;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<Integer>();
        if(rowIndex < 0) return ans;
        
        for(int i = 0; i < rowIndex + 1; i++){
            ans.add(0, 1);
            for(int j = 1; j < ans.size() - 1; j++)
                ans.set(j, ans.get(j) + ans.get(j + 1));
        }
        
        return ans;
    }
}