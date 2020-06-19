/**
 * https://leetcode.com/problems/my-calendar-ii/
 * 
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(N)
 * 
 * Reference:
 *  https://leetcode.com/problems/my-calendar-ii/discuss/109519/JavaC++-Clean-Code-with-Explanation/111413
 */
package com.zea7ot.lc.lvl3.lc0731;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0BrutalForce1 {
    private List<int[]> bookings;
    private List<int[]> overlaps;

    public SolutionApproach0BrutalForce1() {
        this.bookings = new ArrayList<int[]>();
        this.overlaps = new ArrayList<int[]>();
    }
    
    public boolean book(int start, int end) {
        for(int[] booking : bookings){
            int overlapStart = Math.max(booking[0], start), overlapEnd = Math.min(booking[1], end);
            
            if(overlapStart < overlapEnd){
                for(int[] overlap : overlaps){
                    if(Math.max(overlap[0], overlapStart) < Math.min(overlap[1], overlapEnd)){
                        overlaps.clear();
                        return false;
                    }
                }
                
                overlaps.add(new int[]{overlapStart, overlapEnd});
            }
        }
        
        bookings.add(new int[]{start, end});
        return true;
    }
}