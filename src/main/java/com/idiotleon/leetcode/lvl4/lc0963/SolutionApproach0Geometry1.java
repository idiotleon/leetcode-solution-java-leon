/**
 * https://leetcode.com/problems/minimum-area-rectangle-ii/discuss/208470/Java-O(N3)-bruteforce/213035
 * 
 * Time Complexity:     O(N ^ 3)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/minimum-area-rectangle-ii/discuss/208470/Java-O(N3)-bruteforce/213035
 */
package com.idiotleon.leetcode.lvl4.lc0963;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class SolutionApproach0Geometry1 {
    public double minAreaFreeRect(int[][] points) {
        Set<Point> allPoints = new HashSet<Point>();
        for(int[] point : points){
            allPoints.add(new Point(point));
        }
        
        final int N = points.length;
        double minArea = Double.MAX_VALUE;
        for(int i = 0; i < N; ++i){
            for(int j = 0; j < N; ++j){
                for(int k = j + 1; k < N; ++k){
                    if(i == j || i == k) continue;
                    Point p1 = new Point(points[i]);
                    Point p2 = new Point(points[j]);
                    Point p3 = new Point(points[k]);
                    
                    if((p2.row - p1.row) * (p3.row - p1.row) + (p2.col - p1.col) * (p3.col - p1.col) != 0) continue;
                    
                    int x4 = p3.row + p2.row - p1.row;
                    int y4 = p3.col + p2.col - p1.col;
                    Point p4 = new Point(x4, y4);
                    
                    if(!allPoints.contains(p4)) continue;
                    minArea = Math.min(minArea, square(p1, p2, p3));
                }
            }
        }
        
        return minArea == Double.MAX_VALUE ? 0 : minArea;
    }
    
    private double square(Point p1, Point p2, Point p3){
        double width = distance(p1, p2);
        double height = distance(p1, p3);
        return Math.sqrt(width * height);
    }
    
    private double distance(Point p1, Point p2){
        return 1.0D * (p2.row - p1.row) * (p2.row - p1.row) + (p2.col - p1.col) * (p2.col - p1.col);
    }
    
    private class Point{
        protected int row;
        protected int col;
        
        protected Point(int row, int col){
            this.row = row;
            this.col = col;
        }
        
        protected Point(int[] point){
            this(point[0], point[1]);
        }
        
        @Override
        public boolean equals(Object obj){
            if(obj instanceof Point){
                Point that = (Point)obj;
                return this.row == that.row && this.col == that.col;
            }
            
            return false;
        }
        
        @Override
        public int hashCode(){
            return Objects.hash(row, col);
        }
    }
}