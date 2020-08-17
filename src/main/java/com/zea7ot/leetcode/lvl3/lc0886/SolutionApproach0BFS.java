/**
 * https://leetcode.com/problems/possible-bipartition/
 * 
 * Time Complexity: O(V + E) ~ O(N + dislikes.length)
 * Space Complexity: O(V + E) ~ O(N + dislikes.length)
 * 
 * References:
 *  https://leetcode.com/problems/possible-bipartition/discuss/159085/java-adj
 */
package com.zea7ot.leetcode.lvl3.lc0886;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionApproach0BFS {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] colors = new int[N + 1];
        List<List<Integer>> adj = new ArrayList<List<Integer>>(N + 1);
        for(int i = 0; i <= N; i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int[] dislike : dislikes){
            adj.get(dislike[0]).add(dislike[1]);
            adj.get(dislike[1]).add(dislike[0]);
        }
        
        for(int i = 1; i <= N; i++){
            if(colors[i] == 0){
                colors[i] = 1;
                Queue<Integer> queue = new LinkedList<Integer>();
                queue.add(i);
                while(!queue.isEmpty()){
                    int cur = queue.poll();
                    for(int neighbor : adj.get(cur)){
                        if(colors[neighbor] == 0){
                            colors[neighbor] = colors[cur] == 1 ? 2 : 1;
                            queue.add(neighbor);
                        }else{
                            if(colors[neighbor] == colors[cur]) return false;
                        }
                    }
                }
            }
        }
                                    
        return true;
    }
}