/**
 * https://leetcode.com/problems/is-graph-bipartite/
 */
package com.polyg7ot.lc.lvl3.lc0785;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionApproachBFS {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        
        for(int i = 0; i < colors.length; i++){ // to make sure that all nodes will be visited, including disconnected ones
            if(colors[i] == 0){
                Queue<Integer> queue = new LinkedList<Integer>();
                queue.offer(i);
                colors[i] = 1;  // do not forget to initialize the colors array
                
                while(!queue.isEmpty()){
                    int cur = queue.poll();
                    for(int adj : graph[cur]){
                        if(colors[adj] == 0){   // to paint colors
                            queue.add(adj);
                            colors[adj] = -colors[cur];
                        }else{
                            // if the colors of cur and adj are the same
                            if(colors[adj] == colors[cur])
                                return false;
                        }
                    }
                }
            }
        }
        
        return true;
    }
}