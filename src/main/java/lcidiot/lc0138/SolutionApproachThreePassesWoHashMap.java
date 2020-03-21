/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 */
package main.java.lcidiot.lc0138;

import main.java.lcidiot.utils.NodeWithRandomPtr;

class SolutionApproachThreePassesWoHashMap {
    public NodeWithRandomPtr copyRandomList(NodeWithRandomPtr head) {
        if(head == null) return null;
        
        // the first pass
        NodeWithRandomPtr cur = head;
        while(cur != null){
            NodeWithRandomPtr next = cur.next;
            cur.next = new NodeWithRandomPtr(cur.val);
            cur.next.next = next;
            cur = next;
        }
        
        // the second pass
        cur = head;
        while(cur != null){
            if(cur.random != null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        
        // the third pass
        cur = head;
        NodeWithRandomPtr copyHead = head.next;
        while(cur != null){
            NodeWithRandomPtr next = cur.next.next;
            NodeWithRandomPtr copy = cur.next;
            cur.next = next;
            if(next != null)
                copy.next = next.next;
            cur = next;
        }
        
        return copyHead;
    }
}