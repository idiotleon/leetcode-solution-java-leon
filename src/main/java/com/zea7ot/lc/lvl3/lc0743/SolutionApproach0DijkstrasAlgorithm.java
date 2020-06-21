/**
 * https://leetcode.com/problems/network-delay-time/
 * 
 * Time Complexity:     O(V + Vlg(E)) ~ ?O(N + Nlg(E))
 * Space Compleixty:    O(Vlg(E)) ~ 
 * 
 * References:
 *  https://leetcode.com/problems/network-delay-time/discuss/210698/Java-Djikstrabfs-Concise-and-very-easy-to-understand
 */
package com.zea7ot.lc.lvl3.lc0743;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class SolutionApproach0DijkstrasAlgorithm {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for(int[] time : times){
            map.putIfAbsent(time[0], new HashMap<Integer, Integer>());
            map.get(time[0]).put(time[1], time[2]);
        }
        
        Queue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> Integer.compare(a[0], b[0]));
        minHeap.add(new int[]{0, K});
        
        boolean[] visited = new boolean[N + 1];
        
        int ans = 0;
        while(!minHeap.isEmpty()){
            int[] top = minHeap.poll();
            int node = top[1];
            int distance = top[0];
            if(visited[node]) continue;
            visited[node] = true;
            ans = distance;
            N--;
            if(N == 0) return ans;
            if(map.containsKey(node)){
                for(int next : map.get(node).keySet()){
                    minHeap.add(new int[]{distance + map.get(node).get(next), next});
                }
            }
        }
        
        return -1;
    }
}