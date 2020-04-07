/**
 * https://leetcode.com/problems/is-graph-bipartite/
 */
package main.java.lcidiot.lc0785;

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

    public boolean isBipartite2(int[][] graph) {
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