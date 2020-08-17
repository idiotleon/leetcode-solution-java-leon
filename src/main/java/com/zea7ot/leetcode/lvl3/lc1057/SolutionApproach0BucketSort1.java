/**
 * https://leetcode.com/problems/campus-bikes/
 * 
 * Time Complexity:     O(N_WORKERS * N_BIKES)
 * Space Complexity:    O(N_WORKERS * N_BIKES)
 * 
 * References:
 *  https://leetcode.com/problems/campus-bikes/discuss/308738/C++-bucket-sort-O(M*N)-time-and-space-solution/301229
 *  https://leetcode.com/problems/campus-bikes/discuss/308738/C%2B%2B-bucket-sort-O(M*N)-time-and-space-solution
 */
package com.zea7ot.leetcode.lvl3.lc1057;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionApproach0BucketSort1 {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        final int CAPACITY = 2001, N_WORKERS = workers.length, N_BIKES = bikes.length;
        List<List<int[]>> buckets = new ArrayList<List<int[]>>(CAPACITY);
        for(int i = 0; i < CAPACITY; i++){
            buckets.add(new ArrayList<int[]>());
        }
        
        for(int w = 0; w < N_WORKERS; w++){
            for(int b = 0; b < N_BIKES; b++){
                int distance = getDistance(workers[w], bikes[b]);
                buckets.get(distance).add(new int[]{w, b});
            }
        }
        
        boolean[] bikesAssigned = new boolean[N_BIKES];
        int[] ans = new int[N_WORKERS];
        Arrays.fill(ans, -1);
        for(int dist = 0; dist < CAPACITY; dist++){
            if(buckets.get(dist).isEmpty()) continue;
            List<int[]> distances = buckets.get(dist);
            for(int i = 0; i < buckets.get(dist).size(); i++){
                int worker = distances.get(i)[0];
                int bike = distances.get(i)[1];
                
                if(bikesAssigned[bike] || ans[worker] != -1) continue;
                ans[worker] = bike;
                bikesAssigned[bike] = true;
            }
        }
        
        return ans;
    }
    
    private int getDistance(int[] pos1, int[] pos2){
        return Math.abs(pos1[0] - pos2[0]) + Math.abs(pos1[1] - pos2[1]);
    }
}