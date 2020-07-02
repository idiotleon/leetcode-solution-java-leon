/**
 * https://leetcode.com/problems/campus-bikes/
 * 
 * Time Complexity:     O(N_WORKERS * N_BIKES * lg(N_WORKERS * N_BIKES))
 * Space Complexity:    O()
 * 
 * TLEed
 * 
 * References:
 *  https://leetcode.com/problems/campus-bikes/discuss/309284/Java-counting-sort-solution-47ms-(100)
 */
package com.zea7ot.lc.lvl3.lc1057;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class SolutionApproach1MinHeap {
    private int[][] workers, bikes;
    
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        this.workers = workers;
        this.bikes = bikes;
        
        final int N_WORKERS = workers.length, N_BIKES = bikes.length;
        int[] workersAssigned = new int[N_WORKERS], bikesAssigned = new int[N_BIKES];
        Arrays.fill(workersAssigned, -1);
        Arrays.fill(bikesAssigned, -1);
        Queue<Assignment> minHeap = new PriorityQueue<Assignment>();
        
        for(int idxWorker = 0; idxWorker < N_WORKERS; idxWorker++){
            for(int idxBike = 0; idxBike < N_BIKES; idxBike++){
                minHeap.offer(new Assignment(idxWorker, idxBike));
            }
        }
        
        int assigned = 0;
        while(!minHeap.isEmpty() && assigned < N_WORKERS){
            Assignment top = minHeap.poll();
            int idxWorker = top.idxWorker;
            int idxBike = top.idxBike;
            if(workersAssigned[idxWorker] == -1 && bikesAssigned[idxBike] == -1){
                workersAssigned[idxWorker] = idxBike;
                bikesAssigned[idxBike] = idxWorker;
                assigned++;
            }
        }
        
        return workersAssigned;
    }
    
    private class Assignment implements Comparable<Assignment>{
        protected int idxWorker;
        protected int idxBike;
        protected int distance;
        
        protected Assignment(int idxWorker, int idxBike){
            this.idxWorker = idxWorker;
            this.idxBike = idxBike;
            
            this.distance = getDistance(workers[idxWorker], bikes[idxBike]);
        }
        
        private int getDistance(int[] pos1, int[] pos2){
            return Math.abs(pos1[0] - pos2[0]) + Math.abs(pos1[1] - pos2[1]);
        }
        
        @Override
        public int compareTo(Assignment that){
            if(this.distance != that.distance)
                return Integer.compare(this.distance, that.distance);
            
            if(this.idxWorker != that.idxWorker)
                return Integer.compare(this.idxWorker, that.idxWorker);
                
            return Integer.compare(this.idxBike, that.idxBike);    
        }
    }
}