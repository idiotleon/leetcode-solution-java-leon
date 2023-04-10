/**
 * https://leetcode.com/discuss/interview-question/414970/Amazon-or-Phone-Screen-or-First-Unique-Number-in-Data-Stream
 * requirement: Any kind of Set is NOT allowed
 * 
 * Time Complexities:
 *  add():              O(1)
 *  getFirstUnique():   O(1)
 * 
 * Space Complexities:  O(N) + O(L) ~ O(N)
 *  N, the amount of numbers visited
 *  L, the length of the doubly linked list
 * 
 */
package com.idiotleon.bycompany.amazon.ood.first_unique_number_in_data_stream.followup;

import java.util.HashMap;
import java.util.Map;

import com.idiotleon.bycompany.amazon.ood.first_unique_number_in_data_stream.util.Constants;

public class SolutionApproach0DoublyLinkedList {
    private Map<Integer, DLinkedNode> map;
    private DLinkedNode dummyHead, tail;
    
    public SolutionApproach0DoublyLinkedList(){
        this.map = new HashMap<Integer, DLinkedNode>();
        this.dummyHead = new DLinkedNode(-1);
        this.tail = new DLinkedNode(-1);

        dummyHead.next = tail;
        tail.prev = dummyHead;
    }

    public void add(int num){
        if(map.containsKey(num)){
            DLinkedNode node = map.get(num);
            if(node != null){   // when the first-met duplicate
                // to remove the referenced node in the doubly linked list
                removeNode(node);
                // to update the map
                map.put(num, null);
            }
            // to simply ignore the upcoming duplicates
        }else{
            DLinkedNode newNode = new DLinkedNode(num);
            // to insert it into the doubly linked list
            insertAtTail(newNode);
            // to save the value into the map
            map.put(num, newNode);
        }
    }

    public int getFirstUnique(){
        // to be finalized with the interviewer
        if(dummyHead.next == null) return Constants.RESPONSE_IMPOSSIBLE;
        return dummyHead.next.val;
    }

    private void removeNode(DLinkedNode node){
        DLinkedNode prev = node.prev, next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void insertAtTail(DLinkedNode node){
        DLinkedNode prev = tail.prev;

        node.prev = prev;
        prev.next = node;
        node.next = tail;
        tail.prev = node;
    }

    private class DLinkedNode{
        protected int val;
        protected DLinkedNode prev, next;

        protected DLinkedNode(int val){
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }
}