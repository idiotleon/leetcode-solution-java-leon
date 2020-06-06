/**
 * https://leetcode.com/problems/clone-graph/
 */
package com.zea7ot.lc.lvl3.lc0133;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import com.zea7ot.data_structure.graph.Vertex;

public class SolutionApproachBFS {
    public Vertex cloneGraph(Vertex node) {
        // sanity check
        if(node == null) return node;
        
        Map<Vertex, Vertex> visited = new HashMap<Vertex, Vertex>();
        Queue<Vertex> queue = new LinkedList<Vertex>();
        queue.add(node);

        visited.put(node, new Vertex(node.val, new ArrayList<Vertex>()));
        
        while(!queue.isEmpty()){
            Vertex cur = queue.poll();
            
            for(Vertex neighbor : cur.neighbors){
                if(!visited.containsKey(neighbor)){
                    visited.put(neighbor, new Vertex(neighbor.val, new ArrayList<Vertex>()));
                    queue.add(neighbor);
                }
                
                visited.get(cur).neighbors.add(visited.get(neighbor));
            }
        }
        
        return visited.get(node);
    }
}