/**
 * https://leetcode.com/problems/is-graph-bipartite/
 */
package com.polyg7ot.lc.lvl3.lc0785;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionApproachBFS1 {
    public boolean isBipartite(int[][] graph) {
        final int N = graph.length;
        int[] colors = new int[N];
        
        for(int j = 0; j < N; j++){ // to make sure each node is visited, including disconnected ones
            if(colors[j] != 0) continue;
            Queue<Integer> queue = new LinkedList<Integer>();
            queue.add(j);

            int color = 1;

            while(!queue.isEmpty()){
                int size = queue.size();

                for(int i = 0; i < size; i++){
                    int cur = queue.poll();
                    if(colors[cur] == 0){
                        colors[cur] = color;
                        for(int next : graph[cur]){
                            queue.add(next);
                        }
                    }else{
                        if(colors[cur] != color) 
                            return false;
                    }
                }

                color = -color;
            }
        }

        return true;
    }
}