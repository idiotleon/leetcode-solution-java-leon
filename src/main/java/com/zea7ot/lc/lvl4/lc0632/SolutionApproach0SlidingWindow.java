/**
 * https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References;
 *  https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/discuss/104920/Java-8-Sliding-window/303035
 */
package com.zea7ot.lc.lvl4.lc0632;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SolutionApproach0SlidingWindow {
    public int[] smallestRange(List<List<Integer>> nums) {
        if(nums == null || nums.isEmpty()) return new int[0];
        
        final int NR = nums.size();
        List<Point> points = new ArrayList<Point>();
        for(int row = 0; row < NR; row++){
            for(int col = 0; col < nums.get(row).size(); col++){
                points.add(new Point(row, col, nums.get(row).get(col)));
            }
        }
        
        Collections.sort(points, (a, b) -> Integer.compare(a.value, b.value));
        
        int[] counts = new int[NR];
        int rowCount = 0, start = -1, len = Integer.MAX_VALUE;
        for(int i = 0, j = 0; j < points.size(); j++){
            if(counts[points.get(j).row]++ == 0) ++rowCount;
            while(rowCount == NR){
                if(points.get(j).value - points.get(i).value + 1 < len){
                    start = points.get(i).value;
                    len = points.get(j).value - points.get(i).value + 1;
                }
                
                int prev = points.get(i).value;
                while(i <= j && prev == points.get(i).value){
                    if(--counts[points.get(i++).row] == 0) --rowCount;
                }
            }
        }
        
        return new int[]{start, start + len - 1};
    }
    
    private class Point{
        protected int row;
        @SuppressWarnings("unused")
        protected int col;
        protected int value;
        
        protected Point(int row, int col, int value){
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }
}