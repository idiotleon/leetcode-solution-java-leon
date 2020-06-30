/**
 * https://leetcode.com/problems/best-meeting-point/
 * 
 * Time Complexity:     O(NR * NC * lg(NR * NC))
 * Space Complexity:    O(NR) + O(NC)
 * 
 * References:
 *  https://leetcode.com/problems/best-meeting-point/discuss/74186/14ms-java-solution/249422
 *  https://leetcode.com/problems/best-meeting-point/discuss/74186/14ms-java-solution
 */
package com.zea7ot.lc.lvl4.lc0296;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SolutionApproach0FindMedian1 {
    public int minTotalDistance(int[][] grid) {
        final int NR = grid.length, NC = grid[0].length;
        
        List<Integer> X = new ArrayList<Integer>();
        List<Integer> Y = new ArrayList<Integer>();
        for(int row = 0; row < NR; row++){
            for(int col = 0; col < NC; col++){
                if(grid[row][col] == 1){
                    X.add(row);
                    Y.add(col);
                }
            }
        }
        
        return getMinDistance(X) + getMinDistance(Y);
    }
    
    private int getMinDistance(List<Integer> nums){
        Collections.sort(nums);
        int res = 0;
        int mid = nums.get(nums.size() / 2);
        for(int num : nums){
            res += Math.abs(num - mid);
        }
        return res;
    }
}