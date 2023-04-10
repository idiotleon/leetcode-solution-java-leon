/**
 * https://leetcode.com/problems/design-hashset/
 * 
 * Time Complexities:
 *  add:        O(L)
 *      L, length of the specific doubly linked list
 *  remove:     O(L)
 *      L, length of the specific doubly linked list
 *  contains:   O(L)
 *      L, length of the specific doubly linked list
 * 
 * Space Complexities:  O(distinct(N))
 *  N, number of distinct elements without being removed
 */
package com.idiotleon.leetcode.lvl3.lc0732;

public class SolutionApproach0ArrayOfDLinkedLists {
    // somewhat arbitrary
    private static final int CAPACITY = 1000;
    private DoublyLinkedList[] arr;

    /** Initialize your data structure here. */
    public SolutionApproach0ArrayOfDLinkedLists() {
        arr = new DoublyLinkedList[CAPACITY];
    }
    
    /**
     * to insert the node right after head node of that doubly linked list
     * 
     * Time Complexity: O(L)
     */ 
    public void add(int key) {
        if(contains(key)) return;
        
        int idx = hashing(key);
        
        if(arr[idx] == null){
            arr[idx] = new DoublyLinkedList();
        }
        

        DLinkedNode head = arr[idx].head, next = head.next;
        DLinkedNode newNode = new DLinkedNode(key);
        head.next = newNode;
        newNode.prev = head;
        newNode.next = next;
        next.prev = newNode;
    }
    
    /**
     * to remove the specific node by value
     * 
     * Time Complexity: O(L)
     */ 
    public void remove(int key) {
        if(!contains(key)) return;
        
        int idx = hashing(key);
        DLinkedNode cur = arr[idx].head, tail = arr[idx].tail;
        while(cur != tail){
            if(cur.val == key) break;
            cur = cur.next;
        }
        
        DLinkedNode prev = cur.prev, next = cur.next;
        prev.next = next;
        next.prev = prev;
    }
    
    /** 
     * Returns true if this set contains the specified element 
     * 
     * Time Complexity: O(L)
     */ 
    public boolean contains(int key) {
        int idx = hashing(key);
        
        if(arr[idx] == null) return false;
        DoublyLinkedList curList = arr[idx];
        DLinkedNode cur = curList.head;
        while(cur != curList.tail){
            if(cur.val == key) return true;
            cur = cur.next;
        }
        return false;
    }
    
    private int hashing(int val){
        return val % CAPACITY;
    }
    
    private class DoublyLinkedList{
        protected DLinkedNode head, tail;
        
        protected DoublyLinkedList(){
            head = new DLinkedNode(-1);
            tail = new DLinkedNode(-1);
            head.next = tail;
            tail.prev = head;
        }
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