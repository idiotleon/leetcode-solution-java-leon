/**
 * https://leetcode.com/problems/perfect-rectangle/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/perfect-rectangle/discuss/87181/Really-Easy-Understanding-Solution(O(n)-Java)/150872
 *  https://leetcode.com/problems/perfect-rectangle/discuss/87181/Really-Easy-Understanding-Solution(O(n)-Java)/92034
 */
package com.zea7ot.leetcode.lvl6.lc0391;

import java.util.HashSet;
import java.util.Set;

public class SolutionApproach0Math {
    public boolean isRectangleCover(int[][] rectangles) {
        // sanity check
        if(rectangles == null || rectangles.length == 0) return false;
        
        // bottom left
        int x1 = Integer.MAX_VALUE, y1 = Integer.MAX_VALUE;
        // top right
        int x2 = Integer.MIN_VALUE, y2 = Integer.MIN_VALUE;
        int area = 0;
        Set<Coordinate> set = new HashSet<Coordinate>();
        for(int[] rec : rectangles){
            area += (rec[2] - rec[0]) * (rec[3] - rec[1]);
            
            x1 = Math.min(x1, rec[0]);
            y1 = Math.min(y1, rec[1]);
            x2 = Math.max(x2, rec[2]);
            y2 = Math.max(y2, rec[3]);
            
            Coordinate c1 = new Coordinate(rec[0], rec[1]);
            if(!set.add(c1)) set.remove(c1);
            
            Coordinate c2 = new Coordinate(rec[0], rec[3]);
            if(!set.add(c2)) set.remove(c2);
            
            Coordinate c3 = new Coordinate(rec[2], rec[3]);
            if(!set.add(c3)) set.remove(c3);
            
            Coordinate c4 = new Coordinate(rec[2], rec[1]);
            if(!set.add(c4)) set.remove(c4);
        }
        
        if(set.size() != 4 
           || !set.contains(new Coordinate(x1, y1)) 
           || !set.contains(new Coordinate(x1, y2)) 
           || !set.contains(new Coordinate(x2, y2)) 
           || !set.contains(new Coordinate(x2, y1))){
            return false;
        }
        
        return area == (x2 - x1) * (y2 - y1);
    }
    
    private class Coordinate{
        protected int x, y;
        
        protected Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        @Override
        public boolean equals(Object o) {
            if (o instanceof Coordinate) {
                Coordinate p = (Coordinate)o;
                return this.x == p.x && this.y == p.y;
            }
            return false;
        }
        
        @Override
        public int hashCode(){
            int code = 1;
            code = code * 31 + x;
            code = code * 31 + y;
            return code;
        }
    }
}