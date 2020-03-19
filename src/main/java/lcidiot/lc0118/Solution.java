/**
 * https://leetcode.com/problems/pascals-triangle/
 */
package main.java.lcidiot.lc0118;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> allRows = new ArrayList<List<Integer>>();
        List<Integer> row = new ArrayList<Integer>();
        
        for(int i = 0; i < numRows; i++){
            row.add(0, 1);
            for(int j = 1; j < row.size() - 1; j++)
                row.set(j, row.get(j) + row.get(j + 1));
            
            allRows.add(new ArrayList<Integer>(row));
        }
        
        return allRows;
    }
}
