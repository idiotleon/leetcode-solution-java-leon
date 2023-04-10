/**
 * https://leetcode.com/problems/perfect-rectangle/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/perfect-rectangle/discuss/87188/O(n-log-n)-sweep-line-solution/92058
 */
package com.idiotleon.leetcode.lvl6.lc0391;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class SolutionApproach0SweepLine {
    public boolean isRectangleCover(int[][] rectangles) {
        Queue<RectLife> minHeap = new PriorityQueue<RectLife>();
        Set<Rect> set = new TreeSet<Rect>();
        int bottom = rectangles[0][1], top = rectangles[0][3];
        
        for(int[] rectangle : rectangles){
            Rect rect = new Rect(rectangle);
            bottom = Math.min(bottom, rect.bottom);
            top = Math.max(top, rect.top);
            
            minHeap.offer(new RectLife(rect.left, false, rect));
            minHeap.offer(new RectLife(rect.right, true, rect));
        }
        
        if(minHeap.isEmpty()) return false;
        
        int height = 0;
        while(!minHeap.isEmpty()){
            int time = minHeap.peek().time;
            
            while(!minHeap.isEmpty() && minHeap.peek().time == time){
                RectLife rl = minHeap.poll();
                if(!rl.isEnd){
                    if(set.add(rl.rect)){
                        height += rl.rect.top - rl.rect.bottom;
                    }else return false; // overlap
                }else{
                    set.remove(rl.rect);
                    height -= rl.rect.top - rl.rect.bottom;
                }
            }
            
            if(!minHeap.isEmpty() && height != top - bottom) return false;
        }
        
        return true;
    }
    
    private class RectLife implements Comparable<RectLife>{
        protected int time;
        protected boolean isEnd;
        protected Rect rect;
        
        protected RectLife(int time, boolean isEnd, Rect rect){
            this.time = time;
            this.isEnd = isEnd;
            this.rect = rect;
        }
        
        @Override
        public int compareTo(RectLife that){
            return (this.time == that.time) ? this.rect.left - that.rect.left : this.time - that.time;
        }
    }
    
    private class Rect implements Comparable<Rect>{
        protected int left, right, top, bottom;
        
        protected Rect(int[] rect){
            this.left = rect[0];
            this.bottom = rect[1];
            this.right = rect[2];
            this.top = rect[3];
        }
        
        @Override
        public int compareTo(Rect that){
            if(this.top <= that.bottom) return -1;
            else if(this.bottom >= that.top) return 1;
            // overlap
            else return 0;
        }
    }
}