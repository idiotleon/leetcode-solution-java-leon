/**
 * https://leetcode.com/problems/my-calendar-i/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 */
package com.zea7ot.lc.lvl3.lc0729;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach1BrutalForce {
    private List<int[]> booked;

    public SolutionApproach1BrutalForce() {
        this.booked = new ArrayList<int[]>();
    }
    
    public boolean book(int start, int end) {
        for(int[] appointment : booked){
            if(Math.max(appointment[0], start) < Math.min(appointment[1], end)){
                return false;
            }
        }
        
        booked.add(new int[]{start, end});
        return true;
    }
}