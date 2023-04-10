/**
 * https://leetcode.com/problems/design-linked-list/
 */
package com.idiotleon.leetcode.lvl3.lc0707;

public class SolutionApproach0DoublyLinkedList {
    private DoublyLinkedList dll;
    private int length;

    /** Initialize your data structure here. */
    public SolutionApproach0DoublyLinkedList() {
        this.dll = new DoublyLinkedList();
        this.length = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index >= length) return -1;
        DLLNode cur = dll.head;
        for(int i = 0; i <= index; i++){
            cur = cur.next;
        }
        return cur.value;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        DLLNode head = dll.head, next = dll.head.next;
        DLLNode newNode = new DLLNode(val);
        head.next = newNode;
        newNode.prev = head;
        newNode.next = next;
        next.prev = newNode;
        
        this.length++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        DLLNode head = dll.tail.prev, next = dll.tail;
        DLLNode newNode = new DLLNode(val);
        head.next = newNode;
        newNode.prev = head;
        next.prev = newNode;
        newNode.next = next;
        
        this.length++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index < 0 || index > length) return;
        
        DLLNode cur = dll.head;
        for(int i = 0; i < index; i++) cur = cur.next;
        DLLNode next = cur.next;
        
        DLLNode newNode = new DLLNode(val);
        cur.next = newNode;
        newNode.prev = cur;
        newNode.next = next;
        next.prev = newNode;
        
        this.length++;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= length) return;
        DLLNode cur = dll.head;
        for(int i = 0; i <= index; i++) cur = cur.next;
        DLLNode prev = cur.prev, next = cur.next;
        prev.next = next;
        next.prev = prev;
        
        this.length--;
    }
    
    private class DoublyLinkedList{
        protected DLLNode head;
        protected DLLNode tail;
        
        protected DoublyLinkedList(){
            this.head = new DLLNode(-1);
            this.tail = new DLLNode(-1);
            
            head.next = tail;
            tail.prev = head;
        }
    }
    
    private class DLLNode{
        protected int value;
        protected DLLNode prev;
        protected DLLNode next;
        
        protected DLLNode(int value){
            this.value = value;
            this.prev = this.next = null;
        }
    }
}