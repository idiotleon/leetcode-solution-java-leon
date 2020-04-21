/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 */
package main.java.lcidiot.lc0138;

import java.util.HashMap;

import main.java.lcidiot.data_structure.linkedlist.ListNodeWithRandomPtr;

class SolutionApproachRecursion {
    private HashMap<ListNodeWithRandomPtr, ListNodeWithRandomPtr> visited 
        = new HashMap<ListNodeWithRandomPtr, ListNodeWithRandomPtr>();
    
    public ListNodeWithRandomPtr copyRandomList(ListNodeWithRandomPtr head) {
        if(head == null) return null;
        
        if(this.visited.containsKey(head))
            return this.visited.get(head);
            
            ListNodeWithRandomPtr node = new ListNodeWithRandomPtr(head.val);
        this.visited.put(head, node);
        
        node.next = this.copyRandomList(head.next);
        node.random = this.copyRandomList(head.random);
        
        return node;
    }
}