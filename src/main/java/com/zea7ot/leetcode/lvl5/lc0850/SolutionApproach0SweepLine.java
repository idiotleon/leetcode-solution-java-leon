/**
 * https://leetcode.com/problems/rectangle-area-ii/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/rectangle-area-ii/discuss/137941/Java-TreeMap-solution-inspired-by-Skyline-and-Meeting-Room
 */
package com.zea7ot.leetcode.lvl5.lc0850;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SolutionApproach0SweepLine {
    public int rectangleArea(int[][] rectangles) {
        // sanity check
        if(rectangles == null || rectangles.length == 0) return 0;
        
        final int MOD = 1_000_000_007;
        List<Point> points = new ArrayList<Point>();
        for(int[] rect : rectangles){
            points.add(new Point(rect[0], rect[1], 1));
            points.add(new Point(rect[0], rect[3], -1));
            points.add(new Point(rect[2], rect[1], -1));
            points.add(new Point(rect[2], rect[3], 1));
        }
        
        Collections.sort(points, (a, b) -> (a.x == b.x) ? b.y - a.y : a.x - b.x);
        
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        int preX = -1;
        int preY = -1;
        int ans = 0;
        for(int i = 0; i < points.size(); i++){
            Point point = points.get(i);
            map.put(point.y, map.getOrDefault(point.y, 0) + point.val);
            if(i == points.size() - 1 || points.get(i + 1).x > point.x){
                if(preX > -1){
                    ans += ((long)preY * (point.x - preX)) % MOD;
                    ans %= MOD;
                }
                preY = calcY(map);
                preX = point.x;
            }
        }
        
        return ans;
    }
    
    private int calcY(TreeMap<Integer, Integer> map){
        int result = 0, pre = -1, count = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(pre >= 0 && count > 0){
                result += entry.getKey() - pre;
            }
            count += entry.getValue();
            pre = entry.getKey();
        }
        return result;
    }
    
    private class Point{
        protected int x, y, val;
        
        protected Point(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}