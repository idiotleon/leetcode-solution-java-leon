/**
 * https://leetcode.com/problems/clone-graph/
 */
package main.java.lcidiot.lc0133;

import java.util.ArrayList;
import java.util.HashMap;

import main.java.lcidiot.utils.GraphNode;

class SolutionApproachDFS {
    private HashMap<GraphNode, GraphNode> visited = new HashMap<GraphNode, GraphNode>();
    
    public GraphNode cloneGraph(GraphNode node) {
        if(node == null) return node;
        
        if(visited.containsKey(node)) return visited.get(node);
        
        GraphNode cloneNode = new GraphNode(node.val, new ArrayList<GraphNode>());
        visited.put(node, cloneNode);
        
        for(GraphNode neighbor : node.neighbors)
            cloneNode.neighbors.add(cloneGraph(neighbor));
        
        return cloneNode;
    }
}