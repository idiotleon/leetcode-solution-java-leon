/**
 * https://leetcode.com/problems/the-skyline-problem/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://github.com/mission-peace/interview/blob/master/src/com/interview/geometry/SkylineDrawing.java
 *  https://www.youtube.com/watch?v=GSBLe8cKu0s
 *  https://leetcode.com/problems/the-skyline-problem/discuss/61197/(Guaranteed)-Really-Detailed-and-Good-(Perfect)-Explanation-of-The-Skyline-Problem/190968
 */
package com.zea7ot.lc.lvl4.lc0218;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class SolutionApproach0SweepLine {
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
                // otherwise to increase its value by 1.
                queue.put(point.height, queue.getOrDefault(point.height, 0) + 1);
            }else{
                // to decrease the value of key/point by 1,
                // to completely remove the entry, if its value is 0.
                queue.put(point.height, queue.getOrDefault(point.height, 1) - 1);
                if(queue.get(point.height) == 0) 
                    queue.remove(point.height);
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
        public int compareTo(BuildingPoint that){
            if(this.x != that.x) return Integer.compare(this.x, that.x);
                
            if(this.isStart && that.isStart) return Integer.compare(that.height, this.height);
            if(!this.isStart && !that.isStart) return Integer.compare(this.height, that.height);
            return this.isStart ? -1 : 1;
        }
    }
}