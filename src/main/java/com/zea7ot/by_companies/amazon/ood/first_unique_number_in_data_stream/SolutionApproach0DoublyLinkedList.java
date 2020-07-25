/**
 * https://leetcode.com/discuss/interview-question/414970/Amazon-or-Phone-Screen-or-First-Unique-Number-in-Data-Stream
 * 
 * Time Complexities:
 *  add():              O(1)
 *  getFirstUnique():   O(1)
 * 
 * Space Complexity:    O(N) + O(N) + O(L) ~ O(N)
 *  N, the number of all integers visited
 *  L, the number of nodes with unique values
 * 
 * the doubly linked list only saves the nodes with unique values
 */
package com.zea7ot.by_companies.amazon.ood.first_unique_number_in_data_stream;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.zea7ot.by_companies.amazon.ood.first_unique_number_in_data_stream.util.Constants;

public class SolutionApproach0DoublyLinkedList {
    private Map<Integer, DLinkedNode> map;
    private Set<Integer> visited;

    private DLinkedNode dummyHead;
    private DLinkedNode tail;

    public SolutionApproach0DoublyLinkedList(){
        this.map = new HashMap<Integer, DLinkedNode>();
        this.visited = new HashSet<Integer>();

        this.dummyHead = new DLinkedNode(-1);
        this.tail = new DLinkedNode(-1);

        dummyHead.next = tail;
        tail.prev = dummyHead;
    }

    public void add(int num){
        if(!visited.contains(num)){
            DLinkedNode newNode = new DLinkedNode(num);
            map.put(num, newNode);
            visited.add(num);
            // to insert the new node right before the tail node
            insertAtTail(newNode);
        }else{
            if(map.containsKey(num)){
                DLinkedNode node = map.get(num);
                // to remove the referenced node
                removeNode(node);
                // to delete the map entry
                map.remove(num);
            }
            // for situations where duplicate numbers are requested to be added, simply ignore them
        }
    }

    public int getFirstUnique(){
        // to be finalized with the interviewer
        if(dummyHead.next == tail) return Constants.RESPONSE_IMPOSSIBLE;
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