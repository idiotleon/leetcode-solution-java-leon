/**
 * https://leetcode.com/problems/the-skyline-problem/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://github.com/mission-peace/interview/blob/master/src/com/interview/geometry/SkylineDrawing.java
 *  https://www.youtube.com/watch?v=GSBLe8cKu0s
 */
package com.idiotleon.leetcode.lvl4.lc0218;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class SolutionApproach0SweepLine1 {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // sanity check
        if(buildings == null || buildings.length == 0 || buildings[0].length == 0) return ans;
        final int N = buildings.length;
        
        BuildingPoint[] points = new BuildingPoint[2 * N];
        int idx = 0;
        for(int[] building : buildings){
            points[idx] = new BuildingPoint(building[0], building[2], true);
            points[idx + 1] = new BuildingPoint(building[1], building[2], false);
            idx += 2;
        }
        Arrays.sort(points);
        
        TreeMap<Integer, Integer> queue = new TreeMap<Integer, Integer>();
        queue.put(0, 1);
        int prevMaxHeight = 0;
        for(BuildingPoint point : points){
            if(point.isStart){
                // to put the key/height into the map, if it does not exist,
                // otherwise to increase it by 1.
                queue.compute(point.height, (key, value) -> {
                    if(value != null) return value + 1;
                    return 1;
                });
            }else{
                // to decrease the value of key/point by 1,
                // to remove the entry if its value is 0.
                queue.compute(point.height, (key, value) -> {
                    if(value == 1) return null;
                    return value - 1;
                });
            }
            
            int curMaxHeight = queue.lastKey();
            if(prevMaxHeight != curMaxHeight){
                ans.add(Arrays.asList(point.x, curMaxHeight));
                prevMaxHeight = curMaxHeight;
            }
        }

        
        return ans;
    }
    
    private class BuildingPoint implements Comparable<BuildingPoint>{
        protected int x;
        protected int height;
        protected boolean isStart;
        
        protected BuildingPoint(int x, int height, boolean isStart){
            this.x = x;
            this.height = height;
            this.isStart = isStart;
        }
        
        @Override
        public int compareTo(BuildingPoint o){
            if(this.x == o.x){
                return (this.isStart ? -this.height : this.height) - (o.isStart ? -o.height : o.height);
            }
            
            return this.x - o.x;
        }
    }
}