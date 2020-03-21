/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 */
package main.java.lcidiot.lc0138;

import java.util.HashMap;
import main.java.lcidiot.utils.NodeWithRandomPtr;

class SolutionApproachRecursion {
    private HashMap<NodeWithRandomPtr, NodeWithRandomPtr> visited 
        = new HashMap<NodeWithRandomPtr, NodeWithRandomPtr>();
    
    public NodeWithRandomPtr copyRandomList(NodeWithRandomPtr head) {
        if(head == null) return null;
        
        if(this.visited.containsKey(head))
            return this.visited.get(head);
            
        NodeWithRandomPtr node = new NodeWithRandomPtr(head.val);
        this.visited.put(head, node);
        
        node.next = this.copyRandomList(head.next);
        node.random = this.copyRandomList(head.random);
        
        return node;
    }
}