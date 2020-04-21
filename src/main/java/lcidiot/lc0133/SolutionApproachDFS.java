/**
 * https://leetcode.com/problems/clone-graph/
 */
package main.java.lcidiot.lc0133;

import java.util.ArrayList;
import java.util.HashMap;

import main.java.lcidiot.data_structure.graph.Vertex;

class SolutionApproachDFS {
    private HashMap<Vertex, Vertex> visited = new HashMap<Vertex, Vertex>();
    
    public Vertex cloneGraph(Vertex node) {
        if(node == null) return node;
        
        if(visited.containsKey(node)) return visited.get(node);
        
        Vertex cloneNode = new Vertex(node.val, new ArrayList<Vertex>());
        visited.put(node, cloneNode);
        
        for(Vertex neighbor : node.neighbors)
            cloneNode.neighbors.add(cloneGraph(neighbor));
        
        return cloneNode;
    }
}