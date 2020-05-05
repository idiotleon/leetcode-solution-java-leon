/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 */
package com.polyg7ot.lc.lvl4.lc0138;

import com.polyg7ot.data_structure.linkedlist.ListNodeWithRandomPtr;

public class SolutionApproachThreePassesWoHashMap {
    public ListNodeWithRandomPtr copyRandomList(ListNodeWithRandomPtr head) {
        if(head == null) return null;
        
        // the first pass
        ListNodeWithRandomPtr cur = head;
        while(cur != null){
            ListNodeWithRandomPtr next = cur.next;
            cur.next = new ListNodeWithRandomPtr(cur.val);
            cur.next.next = next;
            cur = next;
        }
        
        // the second pass
        cur = head;
        while(cur != null){
            if(cur.random != null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        
        // the third pass
        cur = head;
        ListNodeWithRandomPtr copyHead = head.next;
        while(cur != null){
            ListNodeWithRandomPtr next = cur.next.next;
            ListNodeWithRandomPtr copy = cur.next;
            cur.next = next;
            if(next != null)
                copy.next = next.next;
            cur = next;
        }
        
        return copyHead;
    }
}