/**
 * https://leetcode.com/problems/linked-list-cycle-ii/
 */
package com.an7one.leetcode.lvl4.lc0142;

import java.util.HashSet;
import java.util.Set;

import com.an7one.util.data_structure.linkedlist.ListNode;

public class SolutionApproachHashMap {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<ListNode>();
        
        ListNode node = head;
        while(node != null){
            if(visited.contains(node))
                return node;
            visited.add(node);
            node = node.next;
        }
        
        return null;
    }
}