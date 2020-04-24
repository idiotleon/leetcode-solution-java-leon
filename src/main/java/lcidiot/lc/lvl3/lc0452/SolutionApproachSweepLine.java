/**
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
 * 
 * http://zxi.mytechroad.com/blog/geometry/leetcode-452-minimum-number-of-arrows-to-burst-balloons/
 * 
 * Steps:
 *  1. to sort by end point
 *  2. to merge if cur[0] (start of cur) < last, otherwise, a new arrow is required (then to reset "last")
 * 
 * Time Complexity: O(nlg(n))
 * Space Complexity: O(1)
 */
package main.java.lcidiot.lc.lvl3.lc0452;

import java.util.Arrays;

public class SolutionApproachSweepLine {
    public int findMinArrowShots(int[][] points) {
        // sanity check
        if(points == null || points.length == 0) return 0;
        
        Arrays.sort(points, (p1, p2) -> Integer.compare(p1[1], p2[1]));
        int last = points[0][1];
        int ans = 1;
        for(int[] point : points){
            if(point[0] > last){
                last = point[1];
                ans++;
            }
        }
        
        return ans;
    }
}