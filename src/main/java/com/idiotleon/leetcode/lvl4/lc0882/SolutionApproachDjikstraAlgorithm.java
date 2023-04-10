/**
 * https://leetcode.com/problems/reachable-nodes-in-subdivided-graph/
 * 
 * https://leetcode.com/problems/reachable-nodes-in-subdivided-graph/discuss/156777/Java-Dijkstra-Solution
 * 
 * Time Complexity: O(Elg(E)) ~ O((N ^ 2) lg(N ^ 2))
 * source:
 * https://leetcode.com/problems/reachable-nodes-in-subdivided-graph/discuss/156777/Java-Dijkstra-Solution/163977
 * 
 * Instead of maintaining a MinHeap which keeps track of shortest distances to the source, we maintain a MaxHeap that keeps track of maximum moves remained for each node. Since for a node,
 * moves remained + distance from current node to source = M
 * The bigger moves remained is, the smaller the distance will be. Thus, the MaxHeap can also promise the shortest distance.
 * That's the reason behind pq in @wangzi6147 's code, in my view. Really brilliant.
 * source: 
 * https://leetcode.com/problems/reachable-nodes-in-subdivided-graph/discuss/156777/Java-Dijkstra-Solution/162381
 */
package com.idiotleon.leetcode.lvl4.lc0882;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SolutionApproachDjikstraAlgorithm {
    public int reachableNodes(int[][] edges, int M, int N) {
        // to build up the graph - adjacent matrix
        int[][] graph = new int[N][N];
        for(int[] row : graph){
            // to separate edge conditions:
            // edge with 0 cost, and non-existent at all (nodes are NOT connected)
            Arrays.fill(row, -1);
        }
        
        // graph(int[][]) is the representation of new nodes between two old nodes
        for(int[] edge : edges){
            graph[edge[0]][edge[1]] = edge[2];
            graph[edge[1]][edge[0]] = edge[2];
        }
        
        int count = 0;
        boolean[] visited = new boolean[N];
        
        // max heap for remaining moves
        // (intuitively equivalent to min heap for shortest distance)
        PriorityQueue<int[]> searchPQ = new PriorityQueue<int[]>((e0, e1) -> Integer.compare(e1[1], e0[1]));
        searchPQ.add(new int[]{0, M});
        
        while(!searchPQ.isEmpty()){
            int[] cur = searchPQ.poll();
            int curNode = cur[0];
            int moves = cur[1];
            
            // to check old nodes
            if(visited[curNode]) continue;
            visited[curNode] = true;
            count++;
            
            // to check new nodes
            for(int i = 0; i < N; i++){             // i is the next node
                int cost = graph[curNode][i] + 1;   // cost = new nodes + 1
                // that cost = 0 means that curNode(current node) and i(new node) is NOT connected,
                // otherwise, the valid cost is 1
                if(cost > 0){
                    if(moves >= cost && !visited[i]){
                        searchPQ.offer(new int[]{i, moves - cost});
                    }
                    
                    // only to record the new nodes travelled,
                    // cost(int) can only reach (cost - 1)(int) new nodes
                    int reach = Math.min(moves, cost - 1);
                    
                    // the old node will be counted at the start of the new round
                    count += reach;
                    
                    // to update the remaining new node from i to curNode,
                    // which is important since the new nodes can be visited from both sides
                    graph[i][curNode] -= reach;
                }
            }
        }
        
        return count;
    }
}