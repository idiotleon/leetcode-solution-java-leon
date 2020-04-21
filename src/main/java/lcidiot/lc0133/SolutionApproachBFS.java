/**
 * https://leetcode.com/problems/clone-graph/
 */
package main.java.lcidiot.lc0133;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import main.java.lcidiot.data_structure.graph.Vertex;

class SolutionApproachBFS {
    public Vertex cloneGraph(Vertex node) {
        if(node == null) return node;
        
        HashMap<Vertex, Vertex> visited = new HashMap<Vertex, Vertex>();
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