/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 */
package main.java.lcidiot.lc0138;

import java.util.HashMap;
import java.util.Map;
import main.java.lcidiot.utils.NodeWithRandomPtr;;

class SolutionApproachTwoPassesWithHashMap {
    public NodeWithRandomPtr copyRandomList(NodeWithRandomPtr head) {
        if(head == null) return null;
        
        Map<NodeWithRandomPtr, NodeWithRandomPtr> map = new HashMap<NodeWithRandomPtr, NodeWithRandomPtr>();
        
        // 1st pass: to copy all the nodes
        NodeWithRandomPtr node = head;
        while(node != null){
            map.put(node, new NodeWithRandomPtr(node.val));
            node = node.next;
        }
        
        // 2nd pass: to assign next and random pointers
        node = head;
        while(node != null){
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        
        return map.get(head);
    }
}