/**
 * https://leetcode.com/problems/clone-graph/
 */
package main.java.lcidiot.lc0133;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import main.java.lcidiot.utils.GraphNode;

class SolutionApproachBFS {
    public GraphNode cloneGraph(GraphNode node) {
        if(node == null) return node;
        
        HashMap<GraphNode, GraphNode> visited = new HashMap<GraphNode, GraphNode>();
        Queue<GraphNode> queue = new LinkedList<GraphNode>();
        queue.add(node);

        visited.put(node, new GraphNode(node.val, new ArrayList<GraphNode>()));
        
        while(!queue.isEmpty()){
            GraphNode cur = queue.poll();
            
            for(GraphNode neighbor : cur.neighbors){
                if(!visited.containsKey(neighbor)){
                    visited.put(neighbor, new GraphNode(neighbor.val, new ArrayList<GraphNode>()));
                    queue.add(neighbor);
                }
                
                visited.get(cur).neighbors.add(visited.get(neighbor));
            }
        }
        
        return visited.get(node);
    }
}