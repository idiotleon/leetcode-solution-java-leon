/**
 * https://leetcode.com/problems/perfect-squares/
 * 
 * Time Complexity:     O(n ^ 2)
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/perfect-squares/discuss/71488/Summary-of-4-different-solutions-(BFS-DP-static-DP-and-mathematics)/311680
 */
package com.polyg7ot.lc.lvl3.lc0279;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SolutionApproach1BFS {
    public int numSquares(int n) {
        // sanity check
        if(n == 0 || n == 1) return n;
        
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);
        int step = 0;
        Set<Integer> visited = new HashSet<Integer>();
        visited.add(0);
        while(!queue.isEmpty()){
            final int SIZE = queue.size();
            step++;
            for(int i = 0; i < SIZE; i++){
                int remain = n - queue.poll();
                for(int j = 1; j * j <= remain; ++j){
                    int v = n - remain + j * j;
                    if(v == n) return step;
                    if(!visited.add(v)) continue;
                    queue.offer(v);
                }
            }
        }
        
        return n;
    }
}