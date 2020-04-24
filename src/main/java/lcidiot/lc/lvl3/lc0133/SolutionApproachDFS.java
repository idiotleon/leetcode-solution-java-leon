/**
 * https://leetcode.com/problems/clone-graph/
 */
package main.java.lcidiot.lc.lvl3.lc0133;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import main.java.lcidiot.data_structure.graph.Vertex;

public class SolutionApproachDFS {
    private Map<Vertex, Vertex> visited = new HashMap<Vertex, Vertex>();
    
    public Vertex cloneGraph(Vertex node) {
        // sanity check
        if(node == null) return node;
        
        if(visited.containsKey(node)) return visited.get(node);
        
        Vertex cloneNode = new Vertex(node.val, new ArrayList<Vertex>());
        visited.put(node, cloneNode);
        
        for(Vertex neighbor : node.neighbors){
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        
        return cloneNode;
    }
}