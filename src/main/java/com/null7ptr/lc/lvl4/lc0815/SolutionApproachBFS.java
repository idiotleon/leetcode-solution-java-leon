/**
 * https://leetcode.com/problems/bus-routes/
 */
package com.null7ptr.lc.lvl4.lc0815;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class SolutionApproachBFS {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        Map<Integer, Set<Integer>> stopMap = new HashMap<Integer, Set<Integer>>();
        Set<Integer> visited = new HashSet<Integer>();
        
        for(int i = 0; i < routes.length; i++){
            for(int j = 0; j < routes[i].length; j++){
                stopMap.putIfAbsent(routes[i][j], new HashSet<Integer>());
                stopMap.get(routes[i][j]).add(i);
            }
        }
        
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(S);
        visited.add(S);
        
        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int stop = queue.removeLast();
                if(stop == T) return count;
                
                for(int bus : stopMap.get(stop)){
                    for(int next : routes[bus]){
                        if(visited.contains(next)) continue;
                        
                        queue.push(next);
                        visited.add(next);
                        stopMap.get(next).remove(bus);
                    }
                }
                stopMap.remove(stop);
            }
            count++;
        }
        
        return -1;
    }
}