/**
 * https://leetcode.com/problems/time-needed-to-inform-all-employees/
 * 
 * Time Complexity:     O(N)
 * Space Compleixty:    O(W)
 * 
 * References:
 *  https://leetcode.com/problems/time-needed-to-inform-all-employees/discuss/533109/Java-BFSDFS-Solutions-Clean-code
 */
package com.zea7ot.lc.lvl3.lc1376;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionApproach0BFS {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {;
        List<List<Integer>> graph = buildGraph(n, manager);
        
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{headID, 0});
        
        int ans = 0;
        while(!queue.isEmpty()){
            int[] top = queue.poll();
            int id = top[0], time = top[1];
            ans = Math.max(ans, time);
            for(int employee : graph.get(id))
                queue.offer(new int[]{employee, time + informTime[id]});
        }
    
        return ans;
    }

    private List<List<Integer>> buildGraph(int n, int[] manager){
        List<List<Integer>> graph = new ArrayList<List<Integer>>(n);
        for(int i = 0; i < n; i++) graph.add(new ArrayList<Integer>());
        for(int i = 0; i < n; i++){
            int mgr = manager[i];
            if(mgr != -1){
                graph.get(mgr).add(i);
            }
        }
        return graph;
    }
}