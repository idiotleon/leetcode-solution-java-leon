/**
 * https://leetcode.com/problems/minimum-area-rectangle-ii/
 * 
 * Time Complexity:     O(N ^ 3)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/minimum-area-rectangle-ii/discuss/208470/Java-O(N3)-bruteforce/213035
 */
package com.zea7ot.lc.lvl4.lc0963;

import java.util.HashSet;
import java.util.Set;

public class SolutionApproach0Geometry {
    public double minAreaFreeRect(int[][] points) {
        Set<String> set = new HashSet<String>();
        for(int[] point : points)
            set.add(hash(point));
        
        final int N = points.length;
        double minArea = Double.MAX_VALUE;
        for(int i = 0; i < N; ++i){
            for(int j = 0; j < N; ++j){
                for(int k = j + 1; k < N; ++k){
                    if(i == j || i == k) continue;
                    int[] p1 = points[i];
                    int[] p2 = points[j];
                    int[] p3 = points[k];
                    
                    // to check whether they are perpendicular to each other
                    // p2 - p1 == a, p3 - p1 == b
                    // (dot product): a . b = |a||b|cos90 == 0
                    if((p2[0] - p1[0]) * (p3[0] - p1[0]) + (p2[1] - p1[1]) * (p3[1] - p1[1]) != 0) continue;
                    
                    // x4 = x3 + (x2 - x1)
                    int x4 = p3[0] + p2[0] - p1[0];
                    // y4 = y3 + (y2 - y1)
                    int y4 = p3[1] + p2[1] - p1[1];
                    if(!set.contains(hash(x4, y4))) continue;
                    minArea = Math.min(minArea, getArea(p1, p2, p3));
                }
            }
        }
        
        return minArea == Double.MAX_VALUE ? 0 : minArea;
    }
    
    private String hash(int x, int y){
        return x + "#" + y;
    };
    
    private String hash(int[] point){
        return hash(point[0], point[1]);
    }
    
    private double getArea(int[] p1, int[] p2, int[] p3){
        double width = getDistance(p1, p2);
        double height = getDistance(p1, p3);
        return Math.sqrt(width * height);
    }
    
    private double getDistance(int[] p1, int[] p2){
        return 1.0D * (p2[0] - p1[0]) * (p2[0] - p1[0]) + (p2[1] - p1[1]) * (p2[1] - p1[1]);
    }
}