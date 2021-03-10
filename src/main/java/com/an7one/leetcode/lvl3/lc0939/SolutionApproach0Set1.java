/**
 * https://leetcode.com/problems/minimum-area-rectangle/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/minimum-area-rectangle/discuss/192759/Simple-AF-JAVA-solution-with-explanation-O(n2)
 */
package com.an7one.leetcode.lvl3.lc0939;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class SolutionApproach0Set1 {
    public int minAreaRect(int[][] points) {
        final int N = points.length;
        int min = Integer.MAX_VALUE;
        Set<Point> allPoints = new HashSet<Point>();
        for(int[] point : points)
            allPoints.add(new Point(point[0], point[1]));
        
        for(int i = 0; i < N; ++i)
            for(int j = i + 1; j < N; ++j){
                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];
                Point p3 = new Point(x1, y2);
                Point p4 = new Point(x2, y1);
                
                if(allPoints.contains(p3) && allPoints.contains(p4)){
                    int area = Math.abs(x1 - x2) * Math.abs(y1 - y2);
                    
                    if(min > area && area != 0) 
                        min = area;
                }
            }
        
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    
    private class Point{
        protected int x;
        protected int y;
        protected Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        @Override
        public boolean equals(Object that){
            return (((Point)that).x == this.x) 
                    && (((Point)that).y == this.y);
        }
        
        @Override
        public int hashCode(){
            return Objects.hash(x, y);
        }
    }
}