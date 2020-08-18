/**
 * https://leetcode.com/problems/perfect-rectangle/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/perfect-rectangle/discuss/87188/O(n-log-n)-sweep-line-solution
 *  https://leetcode.com/problems/perfect-rectangle/discuss/87188/O(n-log-n)-sweep-line-solution/92071
 */
package com.zea7ot.leetcode.lvl6.lc0391;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class SolutionApproach0SweepLine1 {
    public boolean isRectangleCover(int[][] rectangles) {
        Queue<Event> minHeap = new PriorityQueue<Event>();
        
        final int[] BORDER = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        for(int[] rect : rectangles){
            Event e1 = new Event(rect[0], rect);
            Event e2 = new Event(rect[2], rect);
            minHeap.add(e1);
            minHeap.add(e2);
            if(rect[1] < BORDER[0]) BORDER[0] = rect[1];
            if(rect[3] > BORDER[1]) BORDER[1] = rect[3];
        }
        
        Set<int[]> set = new TreeSet<int[]>((a, b) -> {
            if(a[3] <= b[1]) return -1;
            else if(b[3] <= a[1]) return 1;
            // to detect any intersection
            // to return 0 if two y-intervals intersect
            else return 0;
        });
        
        int yRange = 0;
        while(!minHeap.isEmpty()){
            int time = minHeap.peek().time;
            while(!minHeap.isEmpty() && minHeap.peek().time == time){
                Event event = minHeap.poll();
                int[] rect = event.rect;
                if(time == rect[2]){
                    set.remove(rect);
                    yRange -= rect[3] - rect[1];
                }else{
                    if(!set.add(rect)) return false;
                    yRange += rect[3] - rect[1];
                }
            }
            
            // to check the range of intervals
            if(!minHeap.isEmpty() && yRange != BORDER[1] - BORDER[0]){
                return false;
            }
        }
        
        return true;
    }
    
    private class Event implements Comparable<Event>{
        protected int time;
        protected int[] rect;
        
        protected Event(int time, int[] rect){
            this.time = time;
            this.rect = rect;
        }
        
        @Override
        public int compareTo(Event that){
            if(this.time != that.time) return this.time - that.time;
            return this.rect[0] - that.rect[0];
        }
    }
}